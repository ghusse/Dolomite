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

package com.ghusse.dolomite.flickr.people;

import com.ghusse.dolomite.flickr.AuthentifiedCredentials;
import com.ghusse.dolomite.flickr.PhotoListSearch;

/**
 * Request that returns the user's photos.
 * 
 * @author guillaumegautreau
 */
public class GetPhotos extends PhotoListSearch {
  /**
   * Method name.
   */
  public static final String METHOD = "flickr.people.GetPhotos";
  
  /**
   * Request Ctor.
   * 
   * @param credentials
   *          Credentials of a authentified user.
   */
  public GetPhotos(final AuthentifiedCredentials credentials) {
    super(METHOD, credentials);

    this.setArgument("user_id", "me");
  }

  /**
   * Sets the requested user id.
   * 
   * @param id
   *          User id.
   */
  public void setUserId(final String id) {
    this.setArgument("user_id", id);
  }
}
