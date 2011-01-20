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
import com.ghusse.dolomite.flickr.UserInfoWithFullName;

/**
 * Wraps a response to the GetToken request.
 * 
 * @author guillaumegautreau
 */
public class TokenResponse extends Response {
  /**
   * Hidden ctor.
   */
  protected TokenResponse() {
  }

  /**
   * Gets the auth token.
   * @return    Auth token or an empty string.
   */
  public final String getToken() {
    return this.getAuth("token");
  }

  /**
   * Requested permissions.
   * @return Requested permissions value.
   */
  public final String getPerms() {
    return this.getAuth("perms");
  }

  /**
   * Gets the user info.
   * @return User info including full name.
   */
  public final native UserInfoWithFullName getUser() 
  /*-{
    return typeof this.auth != 'undefined' && this.auth != null
      && typeof this.auth.user != 'undefined' ? this.auth.user : null;
  }-*/;

  /**
   * Private utilitary for accessing to properties of the auth property.
   * @param key     Property name
   * @return        Property value
   */
  private native String getAuth(final String key) 
  /*-{
    return typeof this.auth != 'undefined' && this.auth != null 
      && typeof this.auth[key] != 'undefined' && this.auth[key] != null
      && typeof this.auth[key]._content != 'undefined' 
        ? this.auth[key]._content : ""; 
  }-*/;
}
