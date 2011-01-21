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

package com.ghusse.dolomite.flickr.test;

import com.ghusse.dolomite.flickr.Response;

/**
 * Response to an echo request.
 * @author guillaumegautreau
 */
public class EchoResponse extends Response {
  
  /**
   * Hidden Ctor.
   */
  protected EchoResponse() { };

  /**
   * Gets the method's name, which is returned for sure.
   * @return    Method's name.
   */
  public final native String getMethod() /*-{
	return typeof this.method != 'undefined' && this.method != null && typeof this.method._content != 'undefined' ? this.method._content : ""; 
  }-*/;
}
