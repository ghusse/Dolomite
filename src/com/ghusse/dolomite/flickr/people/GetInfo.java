package com.ghusse.dolomite.flickr.people;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.DetailedUserInfo;
import com.ghusse.dolomite.flickr.Request;

public class GetInfo extends Request<DetailedUserInfo>{
	public static final String METHOD = "flickr.people.getInfo";
	
	
	public GetInfo(Credentials credentials, String id) {
		super(METHOD, credentials);
		this.getArguments().put("user_id", id);
	}

}
