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
 * Add tags to a photo.
 * @author guillaumegautreau
 */
public class AddTags extends Request<Response> {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photos.addTags";
  
  /**
   * Ctor.
   * @param connexionCredentials    Credentials for authentified calls. This request needs the write permission.
   * @param photoId                 Id of the photo.
   * @param tags                    Comma separated tags.
   */
  public AddTags(final AuthentifiedCredentials connexionCredentials,
      final String photoId,
      final String tags) {
    super(METHOD, connexionCredentials);
    this.setPhotoId(photoId);
    this.add(tags);
  }
  
  /**
   * Ctor with missing tags parameter. Be careful, add at least one tag before sending !
   * @param connexionCredentials    Credentials for authentified called. This request needs the write permission.
   * @param photoId                 Photo id.
   */
  public AddTags(final AuthentifiedCredentials connexionCredentials,
      final String photoId) {
    super(METHOD, connexionCredentials);
    this.setPhotoId(photoId);
  }
  
  /**
   * Add tags to the request.
   * @param tags    Comma separated tags;
   */
  public final void add(final String tags) {
    if (tags != "") {
      String currentTags = this.getArgument("tags");
      this.setArgument("tags", currentTags == "" ? tags : currentTags + ", " + tags);
    }
  }
  
  /**
   * Sets the photo Id afterwards.
   * @param photoId     Photo id argument.
   */
  public final void setPhotoId(final String photoId) {
    this.setArgument("photo_id", photoId);
  }
}
