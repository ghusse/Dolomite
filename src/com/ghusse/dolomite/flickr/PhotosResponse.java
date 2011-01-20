package com.ghusse.dolomite.flickr;

public class PhotosResponse extends Response{
	protected PhotosResponse(){}
	
	public final native Photos getPhotos() /*-{ return this.photos; }-*/;
}
