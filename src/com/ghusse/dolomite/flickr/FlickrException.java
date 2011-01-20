package com.ghusse.dolomite.flickr;

public class FlickrException extends Throwable{
	private static final long serialVersionUID = -6845027970113977345L;
	
	private final int code;
	private final String message;
	
	public FlickrException(int code, String message){
		super();
		
		this.code = code;
		this.message = message;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getMessage(){
		return this.message;
	}
}
