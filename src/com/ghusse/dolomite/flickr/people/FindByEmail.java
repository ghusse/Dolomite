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
 * Request that will find an user knowing his email.
 * @author guillaumegautreau
 */
public class FindByEmail extends Request<SimpleUserInfo> {
  /**
   * Method name.
   */
  public static final String METHOD = "flickr.people.findByEmail";

  /**
   * Constructs the request.
   * @param credentials     Credentials for requesting the api.
   * @param email           Email of searched user.
   */
  public FindByEmail(final Credentials credentials, final String email) {
	super(METHOD, credentials);
	this.getArguments().put("find_email", email);
  }
}
