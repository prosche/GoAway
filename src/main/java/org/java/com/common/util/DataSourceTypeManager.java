package org.java.com.common.util;

import org.java.com.common.enums.DataSources;

public class DataSourceTypeManager {
	private static final ThreadLocal<DataSources> dataSourceTypes = new ThreadLocal<DataSources>();

	public static DataSources get() {
		return dataSourceTypes.get();
	}

	public static void set(DataSources dataSourceType) {
		dataSourceTypes.set(dataSourceType);
	}

	public static void reset() {
		dataSourceTypes.remove();
	}
}
