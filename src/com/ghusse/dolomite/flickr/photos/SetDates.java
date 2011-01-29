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

package com.ghusse.dolomite.flickr.photos;

import java.util.Date;

import com.ghusse.dolomite.flickr.AuthentifiedCredentials;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * A request that sets one or both of the dates for a photo.
 * @author guillaumegautreau
 */
public class SetDates extends ModifyPhoto {
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photos.setDates";
  
  /**
   * Format used by Flickr.
   */
  private static final DateTimeFormat DATE_FORMAT = DateTimeFormat.getFormat("y-M-d H:m:s");
  
  /**
   * Constructs the request.
   * @param connexionCredentials    Credentials for authentified calls.
   * @param photoId                 Modified photo's id.
   */
  protected SetDates(final AuthentifiedCredentials connexionCredentials, final String photoId) {
    super(METHOD, connexionCredentials, photoId);
  }
  
  /**
   * Sets the date the photo was uploaded to flickr.
   * @param date    Upload date.
   */
  public void setDatePosted(final Date date) {
    this.setArgument("date_posted", DATE_FORMAT.format(date));
  }
  
  /**
   * Sets the date the photo was taken.
   * @param date    Date the photo was taken.
   */
  public void setDateTaken(final Date date) {
    this.setArgument("date_taken", DATE_FORMAT.format(date));
  }
  
  /**
   * Sets the granularity of the date the photo was taken.
   * @param granularity Granularity of the date the photo was taken
   */
  public void setDateTakenGranularity(final DateGranularity granularity) {
    this.setArgument("date_taken_granularity", granularity.toString());
  }
}
