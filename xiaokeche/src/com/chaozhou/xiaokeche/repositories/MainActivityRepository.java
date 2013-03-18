package com.chaozhou.xiaokeche.repositories;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;

import com.chaozhou.xiaokeche.net.RequetSender;
import com.chaozhou.xiaokeche.utils.PeriodUtil;
import com.chaozhou.xiaokeche.utils.SettingsUtil;
import com.chaozhou.xiaokeche.utils.TextUtil;

public class MainActivityRepository extends BaseRepository {

	private RequetSender sender = null;

	public MainActivityRepository(Context context) {
		super(context);
		sender = new RequetSender(context);
	}

	public boolean checkLatestMonth(String validCode) throws Exception {
		return checkMonth(PeriodUtil.getLatestPeriod(), validCode);
	}

	public boolean checkAll(String validCode) throws Exception {

		Iterator<GregorianCalendar> it = PeriodUtil.getAllPeriod().iterator();
		while (it.hasNext()) {
			GregorianCalendar ca = it.next();
			if (checkMonth(ca, validCode)) {
				return true;
			}
		}
		return false;
	}

	public BitmapDrawable getValidCodeDrawable() throws IllegalStateException,
			IOException {
		return sender.getValidCode();
	}

	private boolean checkMonth(GregorianCalendar calendar, String validCode)
			throws Exception {
		String html = sender.search(calendar, validCode);

		String code = SettingsUtil.getApplyCode(mContext);

		if (code.length() == 0) {
			throw new Exception("Î´ÌîÐ´ÉêÇë´úÂë£¡");
		}

		Integer[] indexArray = TextUtil.findAllIndex(html, code);
		return indexArray.length > 1;

	}

	@SuppressWarnings("unused")
	private void saveWinInfo() {

	}
}
