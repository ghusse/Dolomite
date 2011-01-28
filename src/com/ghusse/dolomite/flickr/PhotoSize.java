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
 * List of possible photo sizes.
 * @author guillaumegautreau
 */
public enum PhotoSize {
  /**
   * 75x75.
   */
  SMALL_SQUARE("s"),
  
  /**
   * 100 on longest side.
   */
  THUMBNAIL("t"),
  
  /**
   * 240 on longest side.
   */
  SMALL("m"),
  
  /**
   * 500 on longest side.
   */
  MEDIUM_500("-"),
  
  /**
   * 640 on longest side.
   */
  MEDIUM_640("z"),
  
  /**
   * 1024 on longest side.
   */
  LARGE("b"),
  
  /**
   * Original.
   */
  ORIGINAL("o");
  
  /**
   * Flickr encoded value.
   */
  private String value;
  
  /**
   * Ctor.
   * @param code    Encoded code.
   */
  private PhotoSize(final String code) {
    this.value = code;
  }
  
  /**
   * Gets the string representation of the size.
   * @return String value
   */
  public String toString() {
    return this.value;
  }
}
