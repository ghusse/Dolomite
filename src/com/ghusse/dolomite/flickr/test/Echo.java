package com.ghusse.dolomite.flickr.test;

import java.util.HashMap;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Request;

public class Echo extends Request<EchoResponse>{
	public final static String METHOD = "flickr.test.echo";
	
	public Echo(Credentials credentials) {
		super(METHOD, credentials);
	}
	
	public void addArgument(String key, String value){
		HashMap<String, String> map = this.getArguments();
		map.put(key, value);
	}
}
