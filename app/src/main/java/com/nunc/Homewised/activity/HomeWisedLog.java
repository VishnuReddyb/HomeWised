package com.nunc.Homewised.activity;

import android.util.Log;

/**
 * @since 1.0
 * @author Nunc Systems Pvt. Ltd.
 * 
 */
public class HomeWisedLog {

	public static void d(String tag, String msg) {
		if (HomeWisedBuildConfig.DEBUG) {
			Log.e(tag, msg);
		}
	}
}
