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

package com.ghusse.dolomite.flickr;

/**
 * Extra information that can be requested in photo search or when getting a list of photos.
 * @author guillaumegautreau
 */
public enum Extra {
	Description("description"),
	License("license"),
	DateUpload("date_upload"),
	DateTaken("date_taken"),
	OwnerName("owner_name"),
	IconServer("icon_server"),
	OriginalFormat("original_format"),
	LastUpdate("last_update"),
	Geo("geo"),
	Tags("tags"),
	MachineTags("machine_tags"),
	OriginalDimensions("o_dims"),
	View("view"),
	Media("media"),
	PathAlias("path_alias"),
	SquareUrl("url_sq"),
	ThumbUrl("url_t"),
	SmallUrl("url_s"),
	MediumUrl("url_m"),
	ZUrl("url_z"),
	LargeUrl("url_l"),
	OriginalUrl("url_o");
	
	/**
	 * String code for the value.
	 */
	private final String code;
	
	/**
	 * Ctor.
	 * @param value    String value.
	 */
	private Extra(final String value) {
		this.code = value;
	}
	
	/**
	 * Converts the extra parameter to its string value.
	 * @return String value.
	 */
	public String toString(){
		return this.code;
	}
}
