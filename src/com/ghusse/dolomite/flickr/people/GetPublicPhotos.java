package com.ghusse.dolomite.flickr.people;

import java.util.EnumSet;
import java.util.Iterator;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Extra;
import com.ghusse.dolomite.flickr.PhotosResponse;
import com.ghusse.dolomite.flickr.Request;
import com.ghusse.dolomite.flickr.Safety;

public class GetPublicPhotos extends Request<PhotosResponse>{
	public static final String METHOD = "flickr.people.getPublicPhotos";
	
	public GetPublicPhotos(Credentials credentials, String nsid) {
		super(METHOD, credentials);
		this.getArguments().put("user_id", nsid);
	}
	
	public void setSafety(Safety safety){
		this.getArguments().put("safe_search", String.valueOf(safety.getValue()));
	}
	
	public void setPerPage(int value){
		this.getArguments().put("per_page", String.valueOf(value));
	}
	
	public void setPage(int page){
		this.getArguments().put("page", String.valueOf(page));
	}

	public void setExtras(EnumSet<Extra> extras){
		if (extras != null && extras.size() > 0){
			boolean first = true;
			StringBuilder value;
			
			if (this.getArguments().containsKey("extras")){
				value = new StringBuilder(this.getArguments().get("extras"));
			}else {
				value = new StringBuilder();
				first = false;
			}
			
			for (Iterator<Extra> i = extras.iterator(); i.hasNext();){
				Extra extra = i.next();
				if (!first)
					value.append(",");
				value.append(extra.toString());
				first = false;
			}
			
			this.getArguments().put("extras", value.toString());
		}
	}
}
