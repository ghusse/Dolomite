package com.ghusse.dolomite.flickr;

public class SimpleUserInfo extends Response{
	protected SimpleUserInfo(){}
	
	public final native String getNSID() /*-{ return typeof this.nsid != 'undefined' ? this.nsid : ""; }-*/;
	
	public final native String getUsername() /*-{ return typeof this.username != 'undefined' ? this.username : ""; }-*/;
	
	public final SimpleUserInfo GetSimpleUser(){
		if (this.getStatus()){
			return this;
		}
		
		return null;
	}
}
