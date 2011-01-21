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
import com.ghusse.dolomite.flickr.DetailedUserInfo;
import com.ghusse.dolomite.flickr.Request;

/**
 * Get detailed info about an user.
 * @author guillaumegautreau
 */
public class GetInfo extends Request<DetailedUserInfo> {
  /**
   * Requested API method.
   */
  public static final String METHOD = "flickr.people.getInfo";
	
  /**
   * Ctor.
   * @param credentials Credentials for requesting the API.
   * @param id          User NSID.
   */
  public GetInfo(final Credentials credentials, final String id) {
	super(METHOD, credentials);
	this.getArguments().put("user_id", id);
  }

}
