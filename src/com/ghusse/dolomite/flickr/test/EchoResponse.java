package com.ghusse.dolomite.flickr.test;

import com.ghusse.dolomite.flickr.Response;

public class EchoResponse extends Response{
	protected EchoResponse(){};
	
	public final native String getMethod() /*-{
		return typeof this.method != 'undefined' && this.method != null && typeof this.method._content != 'undefined' ? this.method._content : ""; 
	}-*/;
}
