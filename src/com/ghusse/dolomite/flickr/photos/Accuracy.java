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
 * Recorded accuracy level of the location information.
 * @author guillaumegautreau
 */
public enum Accuracy {
  /**
   * World level is 1.
   */
  WORLD(1),
  
  /**
   * Between world and country.
   */
  LEVEL2(2),
  
  /**
   * Country level is approximatively 3.
   */
  COUNTRY(3),
  
  /**
   * Between country(3) and region(6).
   */
  LEVEL4(4),
  
  /**
   * Between country(3) and region(6).
   */
  LEVEL5(5),
  
  /**
   * Region level is approximatively 6.
   */
  REGION(6),
  
  /**
   * Between region(6) and city(11).
   */
  LEVEL7(7),
  
  /**
   * Between region(6) and city(11).
   */
  LEVEL8(8),
  
  /**
   * Between region(6) and city(11).
   */
  LEVEL9(9),
  
  /**
   * Between region(6) and city(11).
   */
  LEVEL10(10),
  
  /**
   * City level is approximatively 11.
   */
  CITY(11),
  
  /**
   * Between city(11) and street(16).
   */
  LEVEL12(12),
  
  /**
   * Between city(11) and street(16).
   */
  LEVEL13(13),
  
  /**
   * Between city(11) and street(16).
   */
  LEVEL14(14),
  
  /**
   * Between city(11) and street(16).
   */
  LEVEL15(15),
  
  /**
   * Street level is approximatively 16.
   */
  STREET(16);
  
  /**
   * Corresponding integer value.
   */
  private int value;
  
  /**
   * Ctor.
   * @param val Integer value.
   */
  private Accuracy(final int val) {
    this.value = val;
  }
  
  /**
   * Gets the string value of an Accuracy.
   * @return    String value
   */
  public String toString() {
    return String.valueOf(this.value);
  }
}
