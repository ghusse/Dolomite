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

package com.ghusse.dolomite.flickr;

/**
 * Requested media.
 * @author guillaumegautreau
 */
public enum Media {
  /**
   * All medias.
   */
  ALL("all"),
  
  /**
   * Only photos.
   */
  PHOTOS("photos"),
  
  /**
   * Only videos.
   */
  VIDEOS("videos");
  
  /**
   * Equivalent string value.
   */
  private String media;
  
  /**
   * Ctor.
   * @param value   String value.
   */
  private Media(final String value) {
    this.media = value;
  }
  
  /**
   * Gets the string value.
   * @return string value.
   */
  public String toString() {
    return this.media;
  }
}
