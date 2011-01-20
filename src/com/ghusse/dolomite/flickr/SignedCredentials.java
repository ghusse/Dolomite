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

/**
 * Credentials for accessing the Flickr API for requests needing signed
 * parameters.
 * 
 * @author guillaumegautreau
 */
public class SignedCredentials extends Credentials {

  /**
   * Api secret key of your application.
   */
  private final String apiSecret;

  /**
   * Ctor.
   *
   * @param apiKey  Api key of your application
   * @param secret  Api secret of your application
   */
  public SignedCredentials(final String apiKey, final String secret) {
    super(apiKey);
    this.apiSecret = secret;
  }

  /**
   * Indicates whether or not this instance need signed parameter when applied
   * to a request.
   *
   * @return true;
   */
  public boolean isSigned() {
    return true;
  }

  /**
   * Access to the secret key.
   * @return    secret key
   */
  public String getSecret() {
    return this.apiSecret;
  }

}
