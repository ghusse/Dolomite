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

package com.ghusse.dolomite.flickr.photos;

import com.ghusse.dolomite.flickr.AuthentifiedCredentials;
import com.ghusse.dolomite.flickr.Request;
import com.ghusse.dolomite.flickr.Response;

/**
 * Request that deletes a photo from flickr.
 * @author guillaumegautreau
 */
public class Delete extends Request<Response> {

  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photos.delete";
  
  /**
   * Constructs the request.
   * @param connexionCredentials    Credentials with authentification and Write permission.
   * @param photoId                 Id of the photo to delete.
   */
  public Delete(final AuthentifiedCredentials connexionCredentials, final String photoId) {
    super(METHOD, connexionCredentials);
    this.setPhotoId(photoId);
  }
  
  /**
   * Sets the id of the photo to delete.
   * @param photoId     Photo's id.
   */
  public final void setPhotoId(final String photoId) {
    this.setArgument("photo_id", photoId);
  }
}
