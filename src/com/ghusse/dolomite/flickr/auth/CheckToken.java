/** Copyright (c) Guillaume Gautreau 2011
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

import com.ghusse.dolomite.flickr.Request;
import com.ghusse.dolomite.flickr.SignedCredentials;

/**
 * A requests that returns the credentials attached to an authentication token.
 * @author guillaumegautreau
 *
 */
public class CheckToken extends Request<TokenResponse> {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.auth.checkToken";   
  
  /**
   * Ctor.
   * @param connexionCredentials    Signed connexion credentials.
   * @param token                   The authentification token to check.
   */
  public CheckToken(final SignedCredentials connexionCredentials, final String token) {
    super(METHOD, connexionCredentials);
    this.setToken(token);
  }
  
  /**
   * Sets the auth token to check.
   * @param token       Checked token.
   */
  public final void setToken(final String token) {
    this.setArgument("auth_token", token);
  }

}
