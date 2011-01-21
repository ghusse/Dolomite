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

public class DetailedUserInfo extends SimpleUserInfo{
	protected DetailedUserInfo(){}
	
	public final DetailedUserInfo getDetailedUserInfo(){
		if (!this.getStatus()){
			return null;
		}
		
		return this;
	}
	
	public final native boolean isPro() /*-{
		return typeof this.isPro != 'undefined' && this.isPro;
	}-*/;
	
	public final native int getIconServer() /*-{
		return typeof this.iconserver != 'undefined' ? 0 : this.iconserver;
	}-*/;
	
	public final native int getIconFarm() /*-{
		return typeof this.iconfarm != 'undefined' ? 0 : this.iconfarm;
	}-*/;

	public final native String getRealName()  /*-{
		return typeof this.realname != 'undefined' && this.realname != null && typeof this.realname._content != 'undefined' ? this.realname._content : ""; 
	}-*/;
	
	public final native String getMbox() /*-{
		return typeof this.mbox_sha1sum != 'undefined' && this.mbox_sha1sum != null && typeof this.mbox_sha1sum._content != 'undefined' ? this.mbox_sha1sum._content : ""; 
	}-*/;
	
	public final native String getLocation() /*-{
		return typeof this.location != 'undefined' && this.location != null && typeof this.location._content != 'undefined' ? this.location._content : ""; 
	}-*/;
	
	public final native String getPhotoUrl() /*-{
		return typeof this.photosurl != 'undefined' && this.photosurl != null && typeof this.photosurl._content != 'undefined' ? this.photosurl._content : ""; 
		}-*/;
	
	public final native String getProfileUrl() /*-{
	return typeof this.profileurl != 'undefined' && this.profileurl != null && typeof this.profileurl._content != 'undefined' ? this.profileurl._content : ""; 
	}-*/;
	
	public final native String getMobileUrl() /*-{
	return typeof this.mobileurl != 'undefined' && this.mobileurl != null && typeof this.mobileurl._content != 'undefined' ? this.mobileurl._content : ""; 
	}-*/;
	
	public final native int getPhotosCount() /*-{
		if (typeof this.photos == 'undefined' || this.photos == null || typeof this.photos.count == 'undefined' || this.photos.count == null || typeof this.photos.count._content == 'undefined') return 0;
		
		return this.photos.count._content;
	}-*/;
	
	public final native int getFirstDate() /*-{
		if (typeof this.photos == 'undefined' || this.photos == null || typeof this.photos.firstdate == 'undefined' || this.photos.firstdate == null || typeof this.photos.firstdate._content == 'undefined') return 0;
		
		return this.photos.firstdate._content;
	}-*/;

	public final native int getFirstDateTaken() /*-{
		if (typeof this.photos == 'undefined' || this.photos == null || typeof this.photos.firstdatetaken == 'undefined' || this.photos.firstdatetaken == null || typeof this.photos.firstdatetaken._content == 'undefined') return 0;
		
		return this.photos.firstdatetaken._content;
	}-*/;
}
