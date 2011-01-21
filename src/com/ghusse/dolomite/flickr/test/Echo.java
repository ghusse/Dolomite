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

import java.util.HashMap;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;

/**
 * Echo request (test purpose).
 * @author guillaumegautreau
 */
public class Echo extends Request<EchoResponse> {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.test.echo";

  /**
   * Ctor.
   * @param credentials Credentials for accessing to the API.
   */
  public Echo(final Credentials credentials) {
	super(METHOD, credentials);
  }

  /**
   * Add an argument to the request, this argument will be returned in response.
   * @param key     Parameter name.
   * @param value   Parameter value.
   */
  public void addArgument(final String key, final String value) {
	HashMap<String, String> map = this.getArguments();
	map.put(key, value);
  }
}
