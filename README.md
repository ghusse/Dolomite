Dolomite: a GWT pure client library for Flickr
==============================================

Dolomite is a **GWT library** that allow you to connect a client GWT application to the **Flickr API**. Dolomite uses **pure client-side code**, no server side code is required.

Flickr authentification process and authentified API calls are fully supported.

Dolomite uses **Jsonp** requests for connecting to the Flickr API for normal, signed and authentified calls. Responses are directly interpreted as javascript objects, and available in **GWT java-objects wrappers**.

Example
-------

	// You'll need to import com.ghusse.dolomite.flickr.test;
	
	// You need an Flickr API key to use Dolomite
	Credentials credentials = new Credentials(API_KEY);
	
	// Create the request
	Echo request = new Echo(credentials);
	
	// Send it and handle the result
	request.send(new AsyncCallback<EchoResponse>() {
		@Override
		public void onFailure(Throwable caught) {
			// Manage the error
		}
		
		@Override
		public void onSuccess(EchoResponse result) {
			// Use your results, in this case, the echo method returns all parameters and their values.
			// Only the method name is required
			String calledMethod = result.getMethod();
		}
	});

Implemented Flickr methods
--------------------------

If you need a method that is not is this list, you can (fill in a bug)[https://github.com/ghusse/Dolomite/issues], ask me, or even try to implement it by derivating *Request* and *Response* classes.

### flickr.auth 4/4

* flickr.auth.getFrob
* flickr.auth.getToken
* flickr.auth.checkToken
* flickr.auth.getFullToken

### flickr.people 6/8

* flickr.people.findByEmail
* flickr.people.findByUsername
* flickr.people.getInfo
* flickr.people.getPhotos
* flickr.people.getPublicPhotos
* flickr.people.getPhotosOf

### flickr.photos 8/26

* flickr.photos.addTags
* flickr.photos.delete
* flickr.photos.getExif
* flickr.photos.removeTag
* flickr.photos.search
* flickr.photos.setContentType
* flickr.photos.setDates
* flickr.photos.setMeta

### flickr.photosets 2/14

* flickr.photosets.getList
* flickr.photosets.getPhotos

### flickr.test 1/3

* flickr.test.echo