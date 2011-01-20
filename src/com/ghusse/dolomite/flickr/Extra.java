package com.ghusse.dolomite.flickr;

public enum Extra {
	Description("description"),
	License("license"),
	DateUpload("date_upload"),
	DateTaken("date_taken"),
	OwnerName("owner_name"),
	IconServer("icon_server"),
	OriginalFormat("original_format"),
	LastUpdate("last_update"),
	Geo("geo"),
	Tags("tags"),
	MachineTags("machine_tags"),
	OriginalDimensions("o_dims"),
	View("view"),
	Media("media"),
	PathAlias("path_alias"),
	SquareUrl("url_sq"),
	ThumbUrl("url_t"),
	SmallUrl("url_s"),
	MediumUrl("url_m"),
	ZUrl("url_z"),
	LargeUrl("url_l"),
	OriginalUrl("url_o");
	
	private final String code;
	
	private Extra(final String code){
		this.code = code;
	}
	
	public String toString(){
		return this.code;
	}
}
