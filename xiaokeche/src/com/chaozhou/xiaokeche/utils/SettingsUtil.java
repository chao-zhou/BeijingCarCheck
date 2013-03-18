package com.chaozhou.xiaokeche.utils;

import android.content.Context;

import com.chaozhou.lib.SharePreferencesEditor;
import com.chaozhou.xiaokeche.R;

public class SettingsUtil {

	public static String getApplyCode(Context context) {
		String key = context.getString(R.string.pref_applycode_key);
		String code = new SharePreferencesEditor(context).get(key, "-1");
		return code;
	}
}
