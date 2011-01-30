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

import com.ghusse.dolomite.core.JsonOverlay;

/**
 * A photo set.
 * @author guillaumegautreau
 */
public class PhotoSet extends JsonOverlay {
  /**
   * Hidden ctor.
   */
  protected PhotoSet() { }
  
  /**
   * Gets the id.
   * @return    Photoset's id.
   */
  public final native String getId() /*-{
    return typeof this.id != "undefined" ? this.id : null;
  }-*/;
  
  /**
   * Gets the primary value of this photoset.
   * @return    Primary value.
   */
  public final native String getPrimary() /*-{
    return typeof this.primary != "undefined" ? this.primary : null;
  }-*/;
  
  /**
   * Gets the secret value of this photo set.
   * @return    Secret value
   */
  public final native String getSecret() /*-{
    return typeof this.secret != "undefined" ? this.secret : null;
  }-*/;
  
  /**
   * Gets the server of this photo set.
   * @return    Server.
   */
  public final native String getServer() /*-{
    return typeof this.server != "undefined" ? this.server : null;
  }-*/;

  /**
   * Gets the farm value of this set.
   * @return    Farm.
   */
  public final native int getFarm() /*-{
    return typeof this.farm != "undefined" ? this.farm : 0;
  }-*/;
  
  /**
   * Gets the number of photos in this set.
   * @return    Number of photos.
   */
  public final native int getPhotos() /*-{
    return typeof this.photos != "undefined" && this.photos !== 0 ? parseInt(this.photos) : 0;
  }-*/;
  
  /**
   * Gets the number of videos in this set.
   * @return    Number of videos.
   */
  public final native int getVideos() /*-{
    return typeof this.videos != "undefined" && this.videos !== 0 ? parseInt(this.videos) : 0;
  }-*/;
  
  /**
   * Gets the photoset's title.
   * @return    Title.
   */
  public final native String getTitle() /*-{
    return typeof this.title != "undefined" && this.title != null && typeof this.title._content != "undefined" ? this.title._content : ""; 
  }-*/;
  
  /**
   * Gets the photoset's description.
   * @return    description.
   */
  public final native String getDescription() /*-{
    return typeof this.description != "undefined" && this.description != null && typeof this.description._content != "undefined" ? this.description._content : ""; 
  }-*/;
}
