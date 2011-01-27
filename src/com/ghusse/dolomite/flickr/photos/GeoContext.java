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

/**
 * Geo context is a value representing the photo's geotagginess beyond latitude and longitude.
 * @author guillaumegautreau
 */
public enum GeoContext {
  NOT_DEFINED(0),
  INDOORS(1),
  OUTDOORS(2);
  
  /**
   * Equivalent value.
   */
  private int value;
  
  /**
   * Ctor.
   * @param val     Integer value
   */
  private GeoContext(final int val) {
    this.value = val;
  }
  
  /**
   * Gets the string value.
   * @return string value.
   */
  public String toString() {
    return String.valueOf(this.value);
  }
}
