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
 * Request that modify a photo.
 * @author guillaumegautreau
 */
public abstract class ModifyPhoto extends Request<Response> {

  /**
   * Ctor.
   * @param flickrMethod            Called method.
   * @param connexionCredentials    Credentials for authentified calls.
   * @param photoId                 Photo to modify.
   */
  protected ModifyPhoto(final String flickrMethod,
      final AuthentifiedCredentials connexionCredentials,
      final String photoId) {
    super(flickrMethod, connexionCredentials);
    this.setPhotoId(photoId);
  }
  
  /**
   * Sets the photo id to modify.
   * @param photoId     Photo id.
   */
  public final void setPhotoId(final String photoId) {
    this.setArgument("photo_id", photoId);
  }

}
