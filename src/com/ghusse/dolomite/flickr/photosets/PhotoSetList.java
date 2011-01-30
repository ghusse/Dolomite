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

import com.ghusse.dolomite.flickr.Response;
import com.google.gwt.core.client.JsArray;

/**
 * Response to a request that list photo sets.
 * @author guillaumegautreau
 */
public class PhotoSetList extends Response {
  /**
   * Hidden ctor.
   */
  protected PhotoSetList() { }
  
  /**
   * Gets an array of photosets.
   * @return    Array of sets.
   */
  public final native JsArray<PhotoSet> getPhotoSets() /*-{
    return typeof this.photosets != "undefined" && this.photosets != null
      && typeof this.photosets.photoset != "undefined" && this.photosets.photoset != null ?
      this.photosets.photoset : new Array();
  }-*/;
}
