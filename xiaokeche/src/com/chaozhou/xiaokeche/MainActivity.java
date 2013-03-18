package com.chaozhou.xiaokeche;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaozhou.xiaokeche.repositories.MainActivityRepository;

public class MainActivity extends Activity {

	private MainActivityRepository mRepo = null;
	private ProgressDialog mDialog = null;
	private TextView output = null;
	private EditText validCodeInput = null;
	private ImageView validCodeView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRepo = new MainActivityRepository(this);

		mDialog = new ProgressDialog(this);
		mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		mDialog.setMessage(getString(R.string.searching));
		mDialog.setCancelable(false);

		output = (TextView) this.findViewById(R.id.txtOutput);

		validCodeInput = (EditText) this.findViewById(R.id.txtValidCode);
		validCodeView = (ImageView) this.findViewById(R.id.imgValidCode);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		new ValidCodeImageTask(validCodeView).execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == R.id.menu_settings) {
			Intent i = new Intent(this, SettingsActivity.class);
			startActivity(i);
		}

		return false;
	}

	public void onCheckLatestClick(View target) throws Exception {
		mDialog.show();
		new WinCheckTask().execute(0);
	}

	public void onCheckAllClick(View target) {
		mDialog.show();
		new WinCheckTask().execute(1);
	}

	public void gotoSettings(View target) {
		Intent intetn = new Intent(this, SettingsActivity.class);
		startActivity(intetn);
	}

	private void showNotify(boolean win) {
		if (win) {
			showToast("你中签了,赶紧登录北京小客车指标调控管理系统（http://www.bjhjyd.gov.cn/）查看，别忘了打印《小客车配置指标确认通知书》。");
			return;
		}
		showToast("很可惜，没中，登录北京小客车指标调控管理系统（http://www.bjhjyd.gov.cn/）看看是否没有续签。");
	}

	private void showToast(String text) {
		output.setText(text);
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}

	class ValidCodeImageTask extends AsyncTask<Void, Void, BitmapDrawable> {

		private final WeakReference<ImageView> imageViewReference;
		private Exception ex = null;

		public ValidCodeImageTask(ImageView imageView) {
			// Use a WeakReference to ensure the ImageView can be garbage
			// collected
			imageViewReference = new WeakReference<ImageView>(imageView);
		}

		@Override
		protected BitmapDrawable doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				return mRepo.getValidCodeDrawable();
			} catch (Exception ex) {
				this.ex = ex;
				return null;
			}
		}

		// Once complete, see if ImageView is still around and set bitmap.
		@Override
		protected void onPostExecute(BitmapDrawable drawable) {
			if (imageViewReference != null && drawable != null) {
				final ImageView imageView = imageViewReference.get();
				if (imageView != null) {
					imageView.setImageDrawable(drawable);
				}
			}

			if (ex != null) {
				showToast(ex.getMessage());
				return;
			}
		}

	}

	private class WinCheckTask extends AsyncTask<Integer, Void, Boolean> {

		public static final int CHECK_LATEST = 0;
		public static final int CHECK_ALL = 1;

		private Exception ex = null;

		@Override
		protected void onPreExecute() {

			ex = null;
		}

		@Override
		protected Boolean doInBackground(Integer... params) {
			try {
				String validCode = validCodeInput.getText().toString();
				if (params[0] == CHECK_ALL) {
					return mRepo.checkAll(validCode);
				} else if (params[0] == CHECK_LATEST) {
					return mRepo.checkLatestMonth(validCode);
				}
				return false;
			} catch (Exception ex) {
				this.ex = ex;
				return false;
			}
		}

		@Override
		protected void onPostExecute(Boolean result) {
			mDialog.cancel();

			if (ex != null) {
				showToast(ex.getMessage());
				return;
			}

			showNotify(result);
		}
	}

}
