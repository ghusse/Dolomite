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
 * List of granularities for dates.
 * @author guillaumegautreau
 */
public enum DateGranularity {
  /**
   * Y-m-d H:i:s.
   */
  EXACT(0),
  
  /**
   * Y-m.
   */
  MONTH(4),
  
  /**
   * Y.
   */
  YEAR(6),
  
  /**
   * Circa.
   */
  CIRCA(8);
  
  /**
   * Flickr code for the granularity.
   */
  private int code;
  
  /**
   * Ctor.
   * @param value   Int value.
   */
  private DateGranularity(final int value) {
    this.code = value;
  }
  
  /**
   * Gets the integer reprensentation of a value.
   * @return    Int representation.
   */
  public final int getCode() {
    return this.code;
  }
  
  /**
   * Returns the string version of the code.
   * @return    Value as a string.
   */
  public String toString() {
    return String.valueOf(this.code);
  }
}
