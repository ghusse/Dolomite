package com.ghusse.dolomite.flickr.photos;

import java.util.Map;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.Photo;
import com.ghusse.dolomite.flickr.PhotoSizesResponse;
import com.ghusse.dolomite.flickr.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GetSizes extends Request<PhotoSizesResponse> {
  public static final String METHOD = "flickr.photos.getSizes";
  
  protected GetSizes(String flickrMethod, Credentials connexionCredentials) {
    super(flickrMethod, connexionCredentials);
  }
  public GetSizes(Credentials cred) {
    this(METHOD, cred);
  }

  public void setPhoto(Photo photo)
  {
    this.setArgument("photo_id", photo.getId());
  }
  
  protected void send(final AsyncCallback<PhotoSizesResponse> callback,
      final Map<String, String> args) {
    super.send(callback, args);
  }
}
