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

import java.util.ArrayList;
import java.util.List;

import com.ghusse.dolomite.core.JsonOverlay;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Response that carries photos.
 * 
 * @author guillaumegautreau
 */
public class PhotoSizesResponse extends Response {
    /**
     * Hidden ctor.
     */
    protected PhotoSizesResponse() {
    }
    
    public static class PhotoSizeResponse extends JsonOverlay {
        protected PhotoSizeResponse() {};
        public final native String getLabel() /*-{ return this.label; }-*/;
        public final native int getWidth() /*-{ return parseInt(this.width); }-*/;
        public final native int getHeight() /*-{ return parseInt(this.height); }-*/;
        public final native String getSource() /*-{ return this.source; }-*/;
        public final native String getUrl() /*-{ return this.url; }-*/;
        public final native String getMedia() /*-{ return this.media; }-*/;
    }
    
    public final native JsArray<PhotoSizeResponse> nativeGetSizes() /*-{
        return this.sizes.size;
    }-*/;
    
    public final List<PhotoSizeResponse> getSizes() {
        return jsArrayToList(this.nativeGetSizes());
    }
    
    // TODO move to common place
    public static <T extends JavaScriptObject> ArrayList<T> jsArrayToList(JsArray<T> results) {
      ArrayList<T> result = new ArrayList<T>();
      for (int i = 0 ; i < results.length(); i++) {
        result.add(results.get(i));
      }
      return result;
    }
}
