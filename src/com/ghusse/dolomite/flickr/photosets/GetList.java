/** Copyright (c) Guillaume Gautreau 2011
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

package com.ghusse.dolomite.flickr.photosets;

import com.ghusse.dolomite.flickr.AuthentifiedCredentials;
import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;

/**
 * A request that returns the photosets belonging to the specified user.
 * @author guillaumegautreau
 */
public class GetList extends Request<PhotoSetList> {

  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photosets.getList";
  
  /**
   * Creates the request, in order to list sets of a specified user.
   * @param connexionCredentials    Credentials.
   * @param userId                  User NSID
   */
  public GetList(final Credentials connexionCredentials, final String userId) {
    super(METHOD, connexionCredentials);
    this.setArgument("user_id", userId);
  }
  
  /**
   * Creates the request, lists sets of the authentified user.
   * @param authentifiedConnexion   Authentified connexion.
   */
  public GetList(final AuthentifiedCredentials authentifiedConnexion) {
    super(METHOD, authentifiedConnexion);
  }
}
