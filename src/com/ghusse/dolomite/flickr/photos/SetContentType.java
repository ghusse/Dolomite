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
import com.ghusse.dolomite.flickr.ContentType;

/**
 * A request that sets the content type of a photo.
 */
public class SetContentType extends ModifyPhoto {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photos.setContentType";
  
  /**
   * Ctor.
   * @param connexionCredentials    Credentials.
   * @param photoId                 Id of the photo.
   * @param type                    Content type
   */
  protected SetContentType(final AuthentifiedCredentials connexionCredentials,
      final String photoId,
      final ContentType type) {
    super(METHOD, connexionCredentials, photoId);
    this.setArgument("content_type", type.toString());
  }
}
