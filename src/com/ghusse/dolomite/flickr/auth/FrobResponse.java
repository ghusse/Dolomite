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
 */

package com.ghusse.dolomite.flickr.auth;

import com.ghusse.dolomite.flickr.Response;

/**
 * Wraps a response to GetFrob method.
 * 
 * @author guillaumegautreau
 */
public class FrobResponse extends Response {
  /**
   * Hidden ctor.
   */
  protected FrobResponse() {
  }

  /**
   * Returns the frob value or an empty string.
   * 
   * @return Frob value.
   */
  public final native String getFrob() 
  /*-{
    return typeof this.frob != 'undefined' 
      && this.frob != null 
      && typeof this.frob._content != 'undefined' ? this.frob._content : ""; 
  }-*/;
}
