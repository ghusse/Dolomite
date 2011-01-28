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

package com.ghusse.dolomite.flickr.people;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;
import com.ghusse.dolomite.flickr.SimpleUserInfo;

/**
 * Request that finds an user knowing his username. Tough job.
 * @author guillaumegautreau
 *
 */
public class FindByUsername extends Request<SimpleUserInfo> {

  /**
   * Requested API method.
   */
  public static final String METHOD = "flickr.people.findByUsername";
	
  /**
   * Construct a FindByUsername request.
   * @param credentials     Credential for requesting the API.
   * @param username        Searched username.
   */
  public FindByUsername(final Credentials credentials, final String username) {
	super(METHOD, credentials);
	this.setArgument("username", username);
  }

}
