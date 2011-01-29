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

/**
 * A request that sets the meta information for a photo.
 * @author guillaumegautreau
 */
public class SetMeta extends ModifyPhoto {
  
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photos.setMeta";

  /**
   * Ctor.
   * @param connexionCredentials    Credentials with WRITE permission.
   * @param photoId                 Photo's id.
   * @param title                   New title of the photo.
   * @param description             New description of the photo.
   */
  protected SetMeta(final AuthentifiedCredentials connexionCredentials,
      final String photoId,
      final String title,
      final String description) {
    super(METHOD, connexionCredentials, photoId);
    this.setArgument("title", title);
    this.setArgument("description", description);
  }

}
