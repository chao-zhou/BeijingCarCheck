package com.chaozhou.xiaokeche.repositories;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import android.content.Context;
import android.graphics.Bitmap;

import com.chaozhou.xiaokechelib.RequestHelper;
import com.chaozhou.xiaokechelib.analysis.WinResultAnalysis;
import com.chaozhou.xiaokeche.utils.PeriodUtil;
import com.chaozhou.xiaokeche.utils.SettingsUtil;

public class MainActivityRepository extends BaseRepository {

	private RequestHelper helper = new RequestHelper();

	public MainActivityRepository(Context context) {
		super(context);
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

	public Bitmap getValidCodeBitmap() throws IllegalStateException,
			IOException {
		return helper.getValidCodeBitmap();
	}

	private boolean checkMonth(GregorianCalendar calendar, String validCode)
			throws Exception {
		String applyCode = getApplyCode();
		String html = helper.getWinResult(calendar,applyCode,validCode);

		WinResultAnalysis analysis = new WinResultAnalysis(applyCode);
		return analysis.analysis(html);

	}

	private String getApplyCode(){
		return SettingsUtil.getApplyCode(mContext);
	}
}
