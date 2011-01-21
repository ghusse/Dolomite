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

public class ErrorCodes {
	public static final int OK = 0;
	
	public static final int NOT_FOUND = 1;
	public static final int PERMISSION_DENIED = 2;
	public static final int INVALID_SIGNATURE = 96;
	public static final int MISSING_SIGNATURE = 97;
	public static final int INVALID_TOKEN = 98;
	public static final int INSUFFICIENT_PERMISSIONS = 99;
	public static final int INVALID_API_KEY = 100;
	public static final int SERVICE_UNAVAILABLE = 105;
	public static final int INVALID_FROB = 108;
	public static final int FORMAT_NOT_FOUND = 111;
	public static final int METHOD_NOT_FOUND = 112;
	public static final int INVALID_SOAP = 114;
	public static final int INVALID_RPC = 115;
	public static final int BAD_URL = 116;
}
