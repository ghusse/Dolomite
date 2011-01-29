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
 */

package com.ghusse.dolomite.flickr.auth;

import com.ghusse.dolomite.flickr.Request;
import com.ghusse.dolomite.flickr.SignedCredentials;

/**
 * A request that gets the full authentication token for a mini-token.
 * @author guillaumegautreau
 */
public class GetFullToken extends Request<TokenResponse> {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.auth.getFullToken";
  
  /**
   * Ctor.
   * @param connexionCredentials    Credentials for a signed call.
   * @param miniToken               The mini-token typed in by a user.
   */
  public GetFullToken(final SignedCredentials connexionCredentials, final String miniToken) {
    super(METHOD, connexionCredentials);
    this.setMiniToken(miniToken);
  }
  
  /**
   * Sets the mini-token.
   * @param miniToken   Mini token typed by the user.
   */
  public final void setMiniToken(final String miniToken) {
    this.setArgument("mini_token", miniToken);
  }
}
