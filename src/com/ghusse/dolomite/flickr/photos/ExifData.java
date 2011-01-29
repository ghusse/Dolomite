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

import com.ghusse.dolomite.core.JsonOverlay;

/**
 * An exif information.
 * @author guillaumegautreau
 *
 */
public class ExifData extends JsonOverlay {
  /**
   * Hidden Ctor.
   */
  protected ExifData() { }
  
  /**
   * Gets the exif data tag space.
   * @return    Tagspace
   */
  public final native String getTagSpace() /*-{
    return this.tagspace;
  }-*/;
  
  /**
   * Gets the tagspace's id.
   * @return    the tagspace's id.
   */
  public final native int getTagSpaceId() /*-{
    return this.tagspaceid;
  }-*/;
  
  /**
   * Gets the exif tag.
   * @return    Exif tag.
   */
  public final native String getTag() /*-{
    return this.tag;
  }-*/;
  
  /**
   * Gets the exif data label.
   * @return    Exif label.
   */
  public final native String getLabel()  /*-{
    return this.label;
  }-*/;
  
  /**
   * Gets the exif raw value.
   * @return    Exif raw value.
   */
  public final native String getRawValue()  /*-{
    return this.raw._content;
  }-*/;
  
  /**
   * Returns true if the exif value has a clean representation.
   * @return    True if a clean value is present
   */
  public final native boolean hasCleanValue()  /*-{
    return typeof this.clean != 'undefined' && this.clean != null && typeof this.clean._content != 'undefined' && this.clean._content != null;
  }-*/;
  
  /**
   * Returns the clean value corresponding to the raw value, returns an empty string if not present.
   * @return    Clean value.
   */
  public final String getCleanValue() {
    if (this.hasCleanValue()) {
      return this.getClean();
    }
    
    return "";
  }
  
  /**
   * Gets the clean value.
   * @return    Clean value.
   */
  protected final native String getClean()  /*-{
    return this.clean._content;
  }-*/;
}
