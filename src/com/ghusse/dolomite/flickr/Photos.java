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
import com.google.gwt.core.client.JsArray;

public class Photos extends JsonOverlay{
	protected Photos(){}
	
	public final native int getPage() /*-{ return typeof this.page != 'undefined' ? this.page : 0; }-*/;
	
	public final native int getPagesCount() /*-{ return typeof this.pages != 'undefined' ? this.pages : 0; }-*/;
	
	public final native int getPerPage() /*-{ return typeof this.perpage != 'undefined' ? this.perpage : 0; }-*/;
	
	public final native int getTotal() /*-{ return typeof this.total != 'undefined' ? this.total : 0; }-*/;
	
	public final native JsArray<Photo> getPhotos()/*-{
		return typeof this.photo != 'undefined' ? this.photo : new Array();
	}-*/;
}
