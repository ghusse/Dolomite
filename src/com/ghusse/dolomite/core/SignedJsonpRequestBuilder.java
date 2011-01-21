/*
 * Modified by Guillaume Gautreau
 */
/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ghusse.dolomite.core;

import java.util.Map;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Creates and launches a Signed JSONP request.
 * @author guillaumegautreau
 */
public class SignedJsonpRequestBuilder {
  /**
   * Default request timeout.
   */
  public static final int DEFAULT_TIMEOUT = 10000;
  
  /**
   * Request timeout.
   */
  private int timeout = DEFAULT_TIMEOUT;
  
  /**
   * Callback parameter name.
   */
  private String callbackParam = "callback";
  
  /**
   * Failure callback parameter name.
   */
  private String failureCallbackParam = null;
  
  /**
   * Signature parameter name.
   */
  private String signatureParam = "api_sig";
  
  /**
   * Ctor.
   */
  public SignedJsonpRequestBuilder() { }
  
  /**
   * Returns the name of the callback url parameter to send to the server. The
   * default value is "callback".
   * @return The callback parameter name.
   */
  public String getCallbackParam() {
    return callbackParam;
  }

  /**
   * Returns the name of the failure callback url parameter to send to the
   * server. The default is null.
   * @return The failure callback parameter name.
   */
  public String getFailureCallbackParam() {
    return failureCallbackParam;
  }

  /**
   * Returns the expected timeout (ms) for this request.
   * @return Timout in ms
   */
  public int getTimeout() {
    return timeout;
  }
  
  /**
   * Sends a JSONP request and expects a JavaScript object as a result. The caller can either use
   * {@link com.google.gwt.json.client.JSONObject} to parse it, or use a JavaScript overlay class.
   * @param <T>     Type of returned object
   * @param url     Base url for the request
   * @param args    Map of arguments/values to send
   * @param secret  Secret key used to sign the call
   * @param callback Callback object
   * 
   * @return A signed JSONP sent request
   */
  public <T extends JavaScriptObject> SignedJsonpRequest<T> requestObject(
      final String url, final Map<String, String> args, final String secret, 
      final AsyncCallback<T> callback) {
    return send(url, args, secret, callback, false);
  }
  
  /**
   * @param callbackParamName The name of the callback url parameter to send to the server. The default
   *     value is "callback".
   */
  public void setCallbackParam(final String callbackParamName) {
    this.callbackParam = callbackParamName;
  }

  /**
   * @param failureCallbackParamName The name of the failure callback url parameter to send to the
   *     server. The default is null.
   */
  public void setFailureCallbackParam(final String failureCallbackParamName) {
    this.failureCallbackParam = failureCallbackParamName;
  }

  /**
   * @param timeoutDelay The expected timeout (ms) for this request. The default is 10s.
   */
  public void setTimeout(final int timeoutDelay) {
    this.timeout = timeoutDelay;
  }

  /**
   * Send a signed JSONP request.
   * 
   * @param <T>             Type of returned object.
   * @param url             Requested base URL.
   * @param args            Arguments and values for this request.
   * @param secret          Secret key used to sign the call.
   * @param callback        Callback object
   * @param expectInteger   True if an integer is expected
   * @return                A sent JSONP signed request.
   */
  private <T> SignedJsonpRequest<T> send(
      final String url, final Map<String, String> args,
      final String secret, final AsyncCallback<T> callback, final boolean expectInteger) {
  	SignedJsonpRequest<T> request = new SignedJsonpRequest<T>(callback, timeout, expectInteger, callbackParam,
        failureCallbackParam, signatureParam, secret);
    request.send(url, args);
    return request;
  }
}
