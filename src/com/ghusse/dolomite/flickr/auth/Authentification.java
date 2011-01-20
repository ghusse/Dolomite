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

package com.ghusse.dolomite.flickr.auth;

import java.util.HashMap;

import com.ghusse.dolomite.core.TimeoutException;
import com.ghusse.dolomite.core.UrlBuilder;
import com.ghusse.dolomite.flickr.AuthentifiedCredentials;
import com.ghusse.dolomite.flickr.SignedCredentials;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Authentification helper, proceed as a desktop application.
 * 
 * @author guillaumegautreau
 */
public class Authentification {

  /**
   * Authentification base URL.
   */
  public static final String AUTH_URL = "http://flickr.com/services/auth/";

  /**
   * Default timeout value in ms.
   */
  private static final int DEFAULT_TIMEOUT = 30000; // ms

  /**
   * Signed credentials needed to launch user authentification.
   */
  private final SignedCredentials credentials;

  /**
   * Callback when authentification is performed.
   */
  private AsyncCallback<AuthentifiedCredentials> callback;

  /**
   * Requested permissions on the user's photostream.
   */
  private final Permission perms;

  /**
   * Request timeout, after popup opening.
   */
  private int timeout = DEFAULT_TIMEOUT;

  /**
   * Used to timeout.
   */
  private Timer timer;

  /**
   * Ctor.
   * 
   * @param requestedCredentials
   *          Flickr API access credentials.
   * @param permissions
   *          Requested permissions.
   * @param asyncCallback
   *          Callback methods.
   */
  public Authentification(final SignedCredentials requestedCredentials,
      final Permission permissions,
      final AsyncCallback<AuthentifiedCredentials> asyncCallback) {
    this.credentials = requestedCredentials;
    this.callback = asyncCallback;
    this.perms = permissions;
  }

  /**
   * Returns the authentification URL (Web auth process).
   * 
   * @param apiKey
   *          API key of the application
   * @param permission
   *          Requested perms
   * @param apiSecret
   *          API secret
   * @return Authentification URL
   */
  public static final String getAuthUrl(final String apiKey,
      final Permission permission, final String apiSecret) {
    HashMap<String, String> arguments = new HashMap<String, String>();
    arguments.put("api_key", apiKey);
    arguments.put("perms", permission.toString());

    UrlBuilder.sign(arguments, "api_sig", apiSecret);

    return UrlBuilder.getUri(AUTH_URL, arguments);
  }

  /**
   * Launches the authentification process.
   */
  public final void launch() {
    // First, get a frob
    GetFrob request = new GetFrob(this.credentials);
    request.send(new AsyncCallback<FrobResponse>() {

      @Override
      public void onFailure(final Throwable caught) {
        callback.onFailure(caught);
      }

      @Override
      public void onSuccess(final FrobResponse result) {
        requestPermission(result.getFrob());
      }

    });
  }

  /**
   * Opens an authentification popup.
   * @param frob    Previously returned frob from the API
   */
  private void requestPermission(final String frob) {
    HashMap<String, String> arguments = new HashMap<String, String>();
    arguments.put("api_key", this.credentials.getKey());
    arguments.put("perms", this.perms.toString());
    arguments.put("frob", frob);

    UrlBuilder.sign(arguments, "api_sig", this.credentials.getSecret());

    Window.open(UrlBuilder.getUri(AUTH_URL, arguments), "_blank",
        "resizable=yes,scrollbars=yes,status=yes");

    timer = new Timer() {
      @Override
      public void run() {
        callback.onFailure(new TimeoutException(
            "Timeout : waiting for a valid authentification token"));
        callback = null;
      }
    };

    this.getToken(frob);
  }

  /**
   * Returns the timeout value.
   * @return timeout value
   */
  public int getTimeout() {
    return this.timeout;
  }

  /**
   * Sets the timeout value.
   * @param value timeout value
   */
  public void setTimeout(final int value) {
    this.timeout = value;
  }

  /**
   * Sends a request for getting the authentification token and user info.
   * Until this instance times out, the request is continuously send.
   * 
   * @param frob    Previously returned frob
   */
  private void getToken(final String frob) {
    GetToken request = new GetToken(this.credentials, frob);

    request.send(new AsyncCallback<TokenResponse>() {
      @Override
      public void onFailure(final Throwable caught) {
        if (callback != null) {
          // Try again
          Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
              getToken(frob);
            }
          });
        }
      }

      @Override
      public void onSuccess(final TokenResponse result) {
        timer.cancel();

        if (callback != null) {
          callback.onSuccess(new AuthentifiedCredentials(credentials.getKey(),
              credentials.getSecret(), result.getToken(), result.getUser()));
          callback = null;
        }
      }
    });
  }
}
