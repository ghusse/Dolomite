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

package com.ghusse.dolomite.flickr.photosets;

import com.ghusse.dolomite.flickr.BasicPhotoListRequest;
import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Privacy;
import com.ghusse.dolomite.flickr.Media;

/**
 * A request that gets the list of photos in a set.
 * @author guillaumegautreau
 */
public class GetPhotos extends BasicPhotoListRequest {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photosets.getPhotos";
  
  /**
   * Constructs the request.
   * @param credentials     Connexion credentials.
   * @param photoSetId      Id of the photoset of which photos must be returned.
   */
  public GetPhotos(final Credentials credentials, final String photoSetId) {
    super(METHOD, credentials);
    this.setArgument("photoset_id", photoSetId);
  }
  
  /**
   * Sets the privacy filter.
   * @param filter  Desired value.
   */
  public void setPrivacy(final Privacy filter) {
    this.setArgument("privacy_filter", filter.toString());
  }
  
  /**
   * Filter results by media type.
   * @param media   Media type.
   */
  public void setMedia(final Media media) {
    this.setArgument("media", media.toString());
  }
}
