package com.ghusse.dolomite.core;

import java.util.Map;

public abstract class BeforeSendingHandler {
	public abstract String ProcessArguments(final String uri, Map<String, String> arguments);
}
