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

public class Response extends JsonOverlay{
	protected Response() { super(); };
	
	public final native boolean getStatus() /*-{ return typeof this.stat != 'undefined' && this.stat=="ok"; }-*/;
	
	public final native int getCode() /*-{ return typeof this.code != 'undefined' ? this.code: 0 }-*/;
	
	public final native String getMessage() /*-{ return typeof this.message != 'undefined' ? this.message : ""}-*/; 
}
