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
