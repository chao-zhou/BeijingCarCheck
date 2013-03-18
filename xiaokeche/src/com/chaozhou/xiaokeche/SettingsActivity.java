package com.chaozhou.xiaokeche;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.view.MenuItem;

import com.chaozhou.lib.SharePreferencesEditor;

public class SettingsActivity extends PreferenceActivity implements
		OnSharedPreferenceChangeListener {

	SharePreferencesEditor pEditor = null;
	EditTextPreference prefApplyCode = null;

	@SuppressLint({ "NewApi" })
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.preferences);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		pEditor = new SharePreferencesEditor(this);
		prefApplyCode = (EditTextPreference) getPreferenceScreen()
				.findPreference(getApplyCodeKey());
		prefApplyCode.setSummary(getApplyCode());

		getPreferenceScreen().getSharedPreferences()
				.registerOnSharedPreferenceChangeListener(this);

	}

	private String getApplyCode() {
		String key = getApplyCodeKey();
		String defValue = getString(R.string.pref_applycode_summary);
		String val = pEditor.get(key, defValue);

		if (val.length() == 0)
			return defValue;
		return val;
	}

	private String getApplyCodeKey() {
		return getString(R.string.pref_applycode_key);
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub
		prefApplyCode.setSummary(getApplyCode());
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// getMenuInflater().inflate(R.menu.activity_preference, menu);
	// return true;
	// }
	//
	//
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// NavUtils.navigateUpFromSameTask(this);
			this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
