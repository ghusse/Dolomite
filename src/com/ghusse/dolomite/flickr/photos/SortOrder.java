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
 * The order in which to sort returned photos.
 * @author guillaumegautreau
 */
public enum SortOrder {
  /**
   * Default sorting mode : date posted desc.
   */
  DATE_POSTED_DESC("date-posted-desc"),
  DATE_POSTED_ASC("date-posted-asc"),
  DATE_TAKEN_DESC("date-taken-desc"),
  DATE_TAKEN_ASC("date-taken-asc"),
  INTERESTINGNESS_DESC("interestingness-desc"), 
  INTERESTINGNESS_ASC("interestingness-asc"),
  RELEVANCE("relevance");
  
  /**
   * Equivalent string value.
   */
  private String value;
  
  /**
   * Ctor.
   * @param val     String value of the sort order.
   */
  private SortOrder(final String val) {
    this.value = val;
  }
  
  /**
   * Converts the value to a string.
   * @return    String value
   */
  public String toString() {
    return this.value;
  }
}
