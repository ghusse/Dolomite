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

import java.util.Map;

/**
 * Credentials used to send request that have to be authentified.
 * 
 * @author guillaumegautreau
 */
public class AuthentifiedCredentials extends SignedCredentials {

  /**
   * Authentification token.
   */
  private final String token;

  /**
   * User info.
   */
  private final UserInfoWithFullName user;

  /**
   * Ctor with authentification data.
   *
   * @param apiKey      Flickr API key
   * @param apiSecret   Flickr API secret
   * @param authToken   User authentification token
   * @param userInfo    User info
   */
  public AuthentifiedCredentials(final String apiKey, final String apiSecret,
      final String authToken, final UserInfoWithFullName userInfo) {
    super(apiKey, apiSecret);
    this.token = authToken;
    this.user = userInfo;
  }

  /**
   * Ctor with credentials.
   * @param credentials Basic credentials
   * @param apiSecret   Flickr API secret
   * @param authToken   User authentification token
   * @param userInfo    User info
   */
  public AuthentifiedCredentials(final Credentials credentials,
      final String apiSecret, final String authToken,
      final UserInfoWithFullName userInfo) {
    this(credentials.getKey(), apiSecret, authToken, userInfo);
  }

  /**
   * Indicates if this instance needs a signed request.
   *
   * @return true if this credential needs a signed request
   */
  public boolean isSigned() {
    return true;
  }
  
  /**
   * {@inheritDoc}
   */
  public void putParams(final Map<String, String> arguments) {
    super.putParams(arguments);
    arguments.put("auth_token", this.token);
  }

  /**
   * Gets the full user info.
   * @return full user info
   */
  public UserInfoWithFullName getUser() {
    return this.user;
  }

  /**
   * Gets the authentification token.
   * @return    auth token.
   */
  public String getToken() {
    return this.token;
  }
}
