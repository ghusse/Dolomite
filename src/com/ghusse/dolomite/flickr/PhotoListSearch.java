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

import java.util.Date;

/**
 * A search request on photos.
 * @author guillaumegautreau
 */
public abstract class PhotoListSearch extends PhotoListRequest {
  
  /**
   * Ctor.
   * @param flickrMethod            Called method.
   * @param connexionCredentials    Credentials
   */
  protected PhotoListSearch(final String flickrMethod,
      final Credentials connexionCredentials) {
    super(flickrMethod, connexionCredentials);
  }

  /**
   * Coefficient for converting ms to s.
   */
  private static final int MS2S = 1000;

  /**
   * Sets the minimum upload date. PhotosPage with an upload date greater than or
   * equal to this value will be returned.
   * 
   * @param date
   *          Minimum upload date
   */
  public void setMinUploadDate(final Date date) {
    this.setArgument("min_upload_date",
        String.valueOf(date.getTime() / MS2S));
  }

  /**
   * Sets the maximum upload date. PhotosPage with an upload date less than or equal
   * to this value will be returned.
   * 
   * @param date
   *          Max upload date
   */
  public void setMaxUploadDate(final Date date) {
    this.setArgument("max_upload_date",
        String.valueOf(date.getTime() / MS2S));
  }

  /**
   * Sets the minimum taken date. PhotosPage with an taken date greater than or
   * equal to this value will be returned.
   * 
   * @param date
   *          Minimum upload date
   */
  public void setMinTakenDate(final Date date) {
    this.setArgument("min_taken_date",
        String.valueOf(date.getTime() / MS2S));
  }

  /**
   * Sets the maximum taken date. PhotosPage with an taken date less than or equal
   * to this value will be returned.
   * 
   * @param date
   *          Max upload date
   */
  public void setMaxTakenDate(final Date date) {
    this.setArgument("max_tajen_date",
        String.valueOf(date.getTime() / MS2S));
  }

  /**
   * Sets the content type setting.
   * 
   * @param type
   *          Content type.
   */
  public void setContentType(final ContentType type) {
    this.setArgument("content_type", type.toString());
  }

  /**
   * Sets the privacy parameter, used to return photos only matching a certain
   * privacy level. This only applies when making an authenticated call to view
   * photos you own.
   * 
   * @param privacy Requested privacy
   */
  public void setPrivacy(final Privacy privacy) {
    this.setArgument("privacy_filter", privacy.toString());
  }
}
