package com.ghusse.dolomite.flickr.people;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;
import com.ghusse.dolomite.flickr.SimpleUserInfo;

public class FindByEmail extends Request<SimpleUserInfo>{
	public static final String METHOD="flickr.people.findByEmail";
	
	public FindByEmail(Credentials credentials, String email) {
		super(METHOD, credentials);
		this.getArguments().put("find_email", email);
	}
}
