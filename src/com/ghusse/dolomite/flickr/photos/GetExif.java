package com.ghusse.dolomite.flickr.photos;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;

public class GetExif extends Request<ExifResponse> {
	public static final String METHOD = "flickr.photos.getExif";
	
	protected GetExif(Credentials credentials, String photoId) {
		super(METHOD, credentials);
		this.getArguments().put("photo_id", photoId);
	}
	
}
