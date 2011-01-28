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
 * Privacy on a photo.
 * @author guillaumegautreau
 */
public enum Privacy {
  
  /**
   * Only public photos.
   */
  PUBLIC(1),
  
  /**
   * PhotosPage that are visible to friends.
   */
  FRIENDS(2),
  
  /**
   * PhotosPage that are visible to family.
   */
  FAMILY(3),
  
  /**
   * PhotosPage that are visible to friends and family.
   */
  FRIENDS_AND_FAMILY(4),
  
  /**
   * Private photos.
   */
  PRIVATE(5);
  
  /**
   * Int code.
   */
  private int code;
  
  /**
   * Ctor.
   * @param value Code
   */
  private Privacy(final int value) {
    this.code = value;
  }
  
  /**
   * String value of the code.
   * @return String value of code.
   */
  public String toString() {
    return String.valueOf(this.code);
  }
  
  /**
   * Int code.
   * @return    the code.
   */
  public int getCode() {
    return this.code;
  }

}
