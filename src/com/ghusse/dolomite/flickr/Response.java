package com.ghusse.dolomite.flickr;

import com.ghusse.dolomite.core.JsonOverlay;

public class Response extends JsonOverlay{
	protected Response() { super(); };
	
	public final native boolean getStatus() /*-{ return typeof this.stat != 'undefined' && this.stat=="ok"; }-*/;
	
	public final native int getCode() /*-{ return typeof this.code != 'undefined' ? this.code: 0 }-*/;
	
	public final native String getMessage() /*-{ return typeof this.message != 'undefined' ? this.message : ""}-*/; 
}
