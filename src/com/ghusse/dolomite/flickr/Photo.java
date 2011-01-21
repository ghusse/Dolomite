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

import com.ghusse.dolomite.core.JsonOverlay;

public class Photo extends JsonOverlay{
	protected Photo(){}
	
	public final native String getId() /*-{return typeof this.id != 'undefined' ? this.id : ""}-*/;
	
	public final native String getOwner() /*-{return typeof this.owner != 'undefined' ? this.owner : ""}-*/;
	
	public final native String getSecret() /*-{return typeof this.secret != 'undefined' ? this.secret : ""}-*/;
	
	public final native String getServer() /*-{return typeof this.server != 'undefined' ? this.server : ""}-*/;
	
	public final native String getFarm()  /*-{return typeof this.farm != 'undefined' ? this.farm : ""}-*/;
	
	public final native String getTitle() /*-{return typeof this.title != 'undefined' ? this.title : ""}-*/;
	
	public final native boolean isPublic() /*-{ return typeof this.ispublic != 'undefined' ? this.ispublic == 1 : false}-*/;
	
	public final native boolean isFriend() /*-{ return typeof this.isfriend != 'undefined' ? this.isfriend == 1 : false}-*/;
	
	public final native boolean isFamily()  /*-{ return typeof this.isfamily != 'undefined' ? this.isfamily == 1 : false}-*/;

}
