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
 * Thrown or returned when Flickr returns an error to our request.
 * @author guillaumegautreau
 */
public class FlickrException extends Throwable {
  
  /**
   * Needed for serializing, i suppose.
   */
  private static final long serialVersionUID = -6845027970113977345L;
	
  /**
   * Integer error code.
   */
  private final int code;
  
  /**
   * Error message returned by Flickr.
   */
  private final String message;
	
  /**
   * Ctor.
   * @param errorCode    Error code.
   * @param errorMessage Error message.
   */
  public FlickrException(final int errorCode, final String errorMessage) {
    super();
		
	this.code = errorCode;
	this.message = errorMessage;
  }
	
  /**
   * Gets the error code.
   * @return    The error code.
   */
  public int getCode() {
	return this.code;
  }

  /**
   * Gets the error message.
   * @return error message.
   */
  public String getMessage() {
	return this.message;
  }
}
