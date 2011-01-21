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

package com.ghusse.dolomite.flickr.photos;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;

/**
 * Requests the GetExif method on Flickr.
 * @author guillaumegautreau
 */
public class GetExif extends Request<ExifResponse> {
  
  /**
   * Called method.
   */
  public static final String METHOD = "flickr.photos.getExif";

  /**
   * Ctor.
   * @param credentials Credentials for accessing to the photo.
   * @param photoId     Photo Id.
   */
  protected GetExif(final Credentials credentials, final String photoId) {
	super(METHOD, credentials);
	this.getArguments().put("photo_id", photoId);
  }
	
}
