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
