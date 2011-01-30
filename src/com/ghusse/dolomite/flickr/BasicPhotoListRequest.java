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

package com.ghusse.dolomite.flickr;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Parent class for photos requests.
 * @author guillaumegautreau
 */
public class BasicPhotoListRequest extends Request<PhotosResponse> {
  
  /**
   * Ctor.
   * @param flickrMethod            Called method.
   * @param connexionCredentials    Connexion credentials.
   */
  protected BasicPhotoListRequest(final String flickrMethod,
      final Credentials connexionCredentials) {
    super(flickrMethod, connexionCredentials);
  }

  /**
   * Number of results per page or results. Maximum is 500. If there is more photos than requested,
   * you'll need to create another GetPublicPhotos request.
   * @param value   Number of photos per page. Max 500.
   */
  public void setPerPage(final int value) {
    this.setArgument("per_page", String.valueOf(value));
  }

  /**
   * Sets the requested page number.
   * @param page    Requested page number.
   */
  public void setPage(final int page) {
    this.setArgument("page", String.valueOf(page));
  }
  
  /**
   * Sets the extra paramter's value.
   * @param extras  Set of extras.
   */
  public void setExtras(final EnumSet<Extra> extras) {
    if (extras != null && extras.size() > 0) {
        boolean first = true;
        StringBuilder value;
            
        if (this.getArguments().containsKey("extras")) {
            value = new StringBuilder(this.getArguments().get("extras"));
        } else {
            value = new StringBuilder();
            first = false;
        }
            
        for (Iterator<Extra> i = extras.iterator(); i.hasNext();) {
            Extra extra = i.next();
            if (!first) {
              value.append(",");
            }
            value.append(extra.toString());
            first = false;
        }
            
        this.setArgument("extras", value.toString());
    }
  }
}
