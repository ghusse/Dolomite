/**
 * Copyright (c) Guillaume Gautreau 2011
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author guillaumegautreau
 */

package com.ghusse.dolomite.flickr;

import java.util.HashMap;
import com.google.gwt.json.client.JSONObject;
import java.util.Map;

import com.ghusse.dolomite.core.SignedJsonpRequestBuilder;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class Request<T extends Response> {
	public static final String API_URL = "http://api.flickr.com/services/rest/";
	private final String method;
	private final HashMap<String, String> additionalArguments = new HashMap<String, String>();
	private final Credentials credentials;
	
	protected Request(String method, Credentials credentials){
		this.method = method;
		this.credentials = credentials;
	}
	
	protected void send(AsyncCallback<T> callback, Map<String, String> args){
		args.put("method", this.method);
		args.put("format", "json");
		this.credentials.putParams(args);
		
		args.putAll(this.additionalArguments);
		
		if (this.credentials.isSigned()){
			this.sendSignedRequest(callback, args);
		}else{
			this.sendUnsignedRequest(callback, args);
		}
	}
	
	public void send(AsyncCallback<T> callback){
		this.send(callback, new HashMap<String, String>());
	}
	
	/**
	 * Arguments of this instance
	 * @return
	 */
	protected HashMap<String, String> getArguments(){
		return this.additionalArguments;
	}
	
	protected void sendUnsignedRequest(final AsyncCallback<T> callback, Map<String, String> args){
		JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
		jsonp.setCallbackParam("jsoncallback");
		
		boolean first = true;
		StringBuilder uri = new StringBuilder(API_URL);
		for (Map.Entry<String, String> entry : args.entrySet()){
			uri.append(first ? "?" : "&");
			first = false;
			uri.append(entry.getKey());
			uri.append("=");
			uri.append(entry.getValue());
		}
		
		jsonp.requestObject(uri.toString(), new AsyncCallback<T>(){
			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}

			@Override
			public void onSuccess(T result) {
				if (result == null){
					callback.onFailure(new NullResultException());
				}
				else if (result.getStatus() == false){
					callback.onFailure(new FlickrException(result.getCode(), new JSONObject(result).toString()));
				}else{
					callback.onSuccess(result);
				}
			}
			
		});
	}
	
	protected void sendSignedRequest(final AsyncCallback<T> callback, Map<String, String> args){
		SignedJsonpRequestBuilder jsonp = new SignedJsonpRequestBuilder();
		jsonp.setCallbackParam("jsoncallback");
		jsonp.requestObject(Request.API_URL, args, ((SignedCredentials)this.getCredentials()).getSecret(), 
			new AsyncCallback<T>(){

			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}

			@Override
			public void onSuccess(T result) {
				if (result == null){
					callback.onFailure(new NullResultException());
				}
				else if (!result.getStatus()){
					callback.onFailure(new FlickrException(result.getCode(), result.getMessage()));
				}else{
					callback.onSuccess(result);
				}
			}
			
		});
	}
	
	protected Credentials getCredentials(){
		return this.credentials;
	}
}
