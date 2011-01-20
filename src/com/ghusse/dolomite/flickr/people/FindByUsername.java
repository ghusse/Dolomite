package com.ghusse.dolomite.flickr.people;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;
import com.ghusse.dolomite.flickr.SimpleUserInfo;

public class FindByUsername extends Request<SimpleUserInfo>{
	public static final String method = "flickr.people.findByUsername";
	
	public FindByUsername(Credentials credentials, String username) {
		super(method, credentials);
		this.getArguments().put("username", username);
	}

}
