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

package com.ghusse.dolomite.flickr.auth;

/**
 * Possible permissions asked when authicating an user.
 * @author guillaumegautreau
 */
public enum Permission {
    /**
     * Read only access.
     */
	READ("read"),
	
	/**
	 * Read & write access.
	 */
	WRITE("write"),
	
	/**
	 * Read, write and delete.
	 */
	DELETE("delete");
	
	/**
	 * String value of the permission.
	 */
	private final String value;
	
	/**
	 * Private ctor.
	 * @param perm    String value of the permission.
	 */
	private Permission(final String perm) {
		this.value = perm;
	}
	
	/**
	 * Converts an enum value to its String value.
	 * @return string value of an enum value.
	 */
	public String toString() {
		return this.value;
	}
}
