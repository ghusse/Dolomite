package com.ghusse.dolomite.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

public abstract class JsonOverlay extends JavaScriptObject{
	protected JsonOverlay(){}
	
	public final String toJSON() {
		return new JSONObject(this).toString();
	}
}
