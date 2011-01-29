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
 * Request that removes a tag from a photo.
 * @author guillaumegautreau
 */
public class RemoveTag extends Request<Response> {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photos.removeTag";
  
  /**
   * Constructs the request.
   * @param credentials     Credentials with authentification and write permission.
   * @param tagId          Tag id to remove, as returned by GetInfo.
   */
  public RemoveTag(final AuthentifiedCredentials credentials, final String tagId) {
    super(METHOD, credentials);
    this.setTagId(tagId);
  }
  
  /**
   * Sets the tag ID to remove.
   * @param tagId   Tag id.
   */
  public final void setTagId(final String tagId) {
    this.setArgument("tag_id", tagId);
  }
}
