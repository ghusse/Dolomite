package com.ghusse.dolomite.flickr;

public enum Safety {
	Safe(1),
	Moderate(2),
	Restricted(3);
	
	private final int value;
	
	private Safety(final int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}

}
