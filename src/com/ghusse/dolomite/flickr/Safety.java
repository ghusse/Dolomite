/**
 * Copyright (c) Guillaume Gautreau 2011
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
 * Possible safety values for querying Flickr.
 * @author guillaumegautreau
 */
public enum Safety {
  /**
   * Only safe content.
   */
  Safe(1),
  
  /**
   * Safe & moderate.
   */
  Moderate(2),
  
  /**
   * All kind of content.
   */
  Restricted(3);

  /**
   * Corresponding int value in flickr API.
   */
  private final int value;

  /**
   * Ctor.
   * @param safety   Int value for safety.
   */
  private Safety(final int safety) {
	this.value = safety;
  }

  /**
   * Corresponding int value.
   * @return    Int value
   */
  public int getValue() {
	return this.value;
  }

}
