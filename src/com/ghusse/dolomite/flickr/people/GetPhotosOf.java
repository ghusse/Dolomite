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

package com.ghusse.dolomite.flickr.people;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.SafetyPhotoListRequest;

/**
 * A request that returns a list of photos containing a particular Flickr member.
 * @author guillaumegautreau
 */
public class GetPhotosOf extends SafetyPhotoListRequest {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.people.getPhotosOf";
  
  /**
   * Ctor.
   * @param connexionCredentials    Connexion credentials.
   * @param userId                  User NSID.
   */
  public GetPhotosOf(final Credentials connexionCredentials, final String userId) {
    super(METHOD, connexionCredentials);
    this.setUserId(userId);
  }

  /**
   * Sets the user id param for this request.
   * @param userId  User NSID.
   */
  public final void setUserId(final String userId) {
    this.setArgument("user_id", userId);
  }
}
