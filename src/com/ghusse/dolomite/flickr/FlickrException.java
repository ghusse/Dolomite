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

public class FlickrException extends Throwable{
	private static final long serialVersionUID = -6845027970113977345L;
	
	private final int code;
	private final String message;
	
	public FlickrException(int code, String message){
		super();
		
		this.code = code;
		this.message = message;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getMessage(){
		return this.message;
	}
}
