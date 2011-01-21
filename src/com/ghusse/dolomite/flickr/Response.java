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

import com.ghusse.dolomite.core.JsonOverlay;

/**
 * Parent class for Flickr responses to our requests.
 * @author guillaumegautreau
 *
 */
public class Response extends JsonOverlay {
  
  /**
   * Hidden ctor.
   */
  protected Response() { super(); };
	
  /**
   * Returns false if the result is an error, true if OK.
   * @return True if the result is ok, false if Flickr returned an error.
   */
  public final native boolean getStatus() /*-{ return typeof this.stat != 'undefined' && this.stat=="ok"; }-*/;
	
  /**
   * Error code, if any.
   * @return    Error code.
   */
  public final native int getCode() /*-{ return typeof this.code != 'undefined' ? this.code: 0 }-*/;
	
  /**
   * Error message, if any.
   * @return    Error message.
   */
  public final native String getMessage() /*-{ return typeof this.message != 'undefined' ? this.message : ""}-*/; 
}
