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
 * Possible radius units.
 * @author guillaumegautreau
 */
public enum RadiusUnit {
  /**
   * Radius in km.
   */
  KILOMETERS("km"),
  
  /**
   * Radius in miles.
   */
  MILES("mi");
  
  /**
   * Corresponding String value.
   */
  private String value;
  
  /**
   * Ctor.
   * @param unit    String unit.
   */
  private RadiusUnit(final String unit) {
    this.value = unit;
  }
  
  /**
   * Returns the string value of the unit.
   * @return string value.
   */
  public String toString() {
    return this.value;
  }
}
