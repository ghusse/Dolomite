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

/**
 * A request to the Flickr API.
 * 
 * @author guillaumegautreau
 * 
 * @param <T>
 *          Response type for this request.
 */
public abstract class Request<T extends Response> {
  /**
   * Flickr API url.
   */
  public static final String API_URL = "http://api.flickr.com/services/rest/";

  /**
   * Flickr API method that is called by this request.
   */
  private final String method;

  /**
   * Map of parameters/values sent as arguments of the request.
   */
  private final HashMap<String, String> additionalArguments = new HashMap<String, String>();

  /**
   * Credentials.
   */
  private final Credentials credentials;

  /**
   * Ctor.
   * 
   * @param flickrMethod
   *          Called method on Flickr API
   * @param connexionCredentials
   *          Credentials for calling this method
   */
  protected Request(final String flickrMethod,
      final Credentials connexionCredentials) {
    this.method = flickrMethod;
    this.credentials = connexionCredentials;
  }

  /**
   * Sends the request.
   * 
   * @param callback
   *          Callback object that will handle the result.
   * @param args
   *          Map of arguments for this request.
   */
  protected void send(final AsyncCallback<T> callback,
      final Map<String, String> args) {
    args.put("method", this.method);
    args.put("format", "json");
    this.credentials.putParams(args);

    args.putAll(this.additionalArguments);

    if (this.credentials.isSigned()) {
      this.sendSignedRequest(callback, args);
    } else {
      this.sendUnsignedRequest(callback, args);
    }
  }

  /**
   * Sends the request without any other argument.
   * 
   * @param callback
   *          Callback object that will handle the result.
   */
  public void send(final AsyncCallback<T> callback) {
    this.send(callback, new HashMap<String, String>());
  }

  /**
   * Arguments of this instance.
   * @return Arguments for this request.
   */
  protected HashMap<String, String> getArguments() {
    return this.additionalArguments;
  }
  
  /**
   * Sets an argument value.
   * @param key     Argument
   * @param value   Value
   */
  protected final void setArgument(final String key, final String value) {
    this.additionalArguments.put(key, value);
  }

  /**
   * Sends an unsigned request.
   * @param callback    Callback object.
   * @param args        Request arguments.
   */
  protected void sendUnsignedRequest(final AsyncCallback<T> callback,
      final Map<String, String> args) {
    JsonpRequestBuilder jsonp = new JsonpRequestBuilder();
    jsonp.setCallbackParam("jsoncallback");

    boolean first = true;
    StringBuilder uri = new StringBuilder(API_URL);
    for (Map.Entry<String, String> entry : args.entrySet()) {
      uri.append(first ? "?" : "&");
      first = false;
      uri.append(entry.getKey());
      uri.append("=");
      uri.append(entry.getValue());
    }

    jsonp.requestObject(uri.toString(), new AsyncCallback<T>() {
      @Override
      public void onFailure(final Throwable caught) {
        callback.onFailure(caught);
      }

      @Override
      public void onSuccess(final T result) {
        if (result == null) {
          callback.onFailure(new NullResultException());
        } else if (!result.getStatus()) {
          callback.onFailure(new FlickrException(result.getCode(),
              new JSONObject(result).toString()));
        } else {
          callback.onSuccess(result);
        }
      }

    });
  }

  /**
   * Sends a signed request.
   * @param callback    Callback object
   * @param args        Request arguments
   */
  protected void sendSignedRequest(final AsyncCallback<T> callback,
      final Map<String, String> args) {
    SignedJsonpRequestBuilder jsonp = new SignedJsonpRequestBuilder();
    jsonp.setCallbackParam("jsoncallback");
    jsonp.requestObject(Request.API_URL, args,
        ((SignedCredentials) this.getCredentials()).getSecret(),
        new AsyncCallback<T>() {

          @Override
          public void onFailure(final Throwable caught) {
            callback.onFailure(caught);
          }

          @Override
          public void onSuccess(final T result) {
            if (result == null) {
              callback.onFailure(new NullResultException());
            } else if (!result.getStatus()) {
              callback.onFailure(new FlickrException(result.getCode(), result
                  .getMessage()));
            } else {
              callback.onSuccess(result);
            }
          }

        });
  }

  /**
   * Gets the credentials for this request.
   * @return    Credentials.
   */
  protected Credentials getCredentials() {
    return this.credentials;
  }
}
