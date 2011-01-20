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
