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

public class SignedJsonpRequestBuilder {
  private int timeout = 10000;
  private String callbackParam = "callback";
  private String failureCallbackParam = null;
  private String signatureParam = "api_sig";
  
  public SignedJsonpRequestBuilder(){}
  
  /**
   * Returns the name of the callback url parameter to send to the server. The
   * default value is "callback".
   */
  public String getCallbackParam() {
    return callbackParam;
  }

  /**
   * Returns the name of the failure callback url parameter to send to the
   * server. The default is null.
   */
  public String getFailureCallbackParam() {
    return failureCallbackParam;
  }

  /**
   * Returns the expected timeout (ms) for this request.
   */
  public int getTimeout() {
    return timeout;
  }
  
  /**
   * Sends a JSONP request and expects a JavaScript object as a result. The caller can either use
   * {@link com.google.gwt.json.client.JSONObject} to parse it, or use a JavaScript overlay class.
   */
  public <T extends JavaScriptObject> SignedJsonpRequest<T> requestObject(final String url, Map<String, String> args, final String secret, 
      AsyncCallback<T> callback) {
    return send(url, args, secret, callback, false);
  }
  
  /**
   * @param callbackParam The name of the callback url parameter to send to the server. The default
   *     value is "callback".
   */
  public void setCallbackParam(String callbackParam) {
    this.callbackParam = callbackParam;
  }

  /**
   * @param failureCallbackParam The name of the failure callback url parameter to send to the
   *     server. The default is null.
   */
  public void setFailureCallbackParam(String failureCallbackParam) {
    this.failureCallbackParam = failureCallbackParam;
  }

  /**
   * @param timeout The expected timeout (ms) for this request. The default is 10s.
   */
  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  private <T> SignedJsonpRequest<T> send(String url, Map<String, String> args, final String secret, AsyncCallback<T> callback, boolean expectInteger) {
  	SignedJsonpRequest<T> request = new SignedJsonpRequest<T>(callback, timeout, expectInteger, callbackParam,
        failureCallbackParam, signatureParam, secret);
    request.send(url, args);
    return request;
  }
}
