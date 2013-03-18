package com.chaozhou.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

public class HttpUtil {

	static HttpClient client = new DefaultHttpClient();

	public static String get(String url) throws IllegalStateException,
			IOException {
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		return readResponseText(response);
	}

	public static BitmapDrawable getBitmap(String url)
			throws IllegalStateException, IOException {
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		return readResponseImage(response);
	}

	public static String postString(String url, String value)
			throws IllegalStateException, IOException {

		HttpPost request = new HttpPost(url);
		request.setEntity(getPostEntity(value));
		HttpResponse response = client.execute(request);

		return readResponseText(response);
	}

	private static String readResponseText(HttpResponse response)
			throws IllegalStateException, IOException {
		String html = "";
		InputStream in = response.getEntity().getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder str = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			str.append(line);
		}
		in.close();
		html = str.toString();
		return html;

	}

	private static BitmapDrawable readResponseImage(HttpResponse response)
			throws IOException {
		HttpEntity entity = response.getEntity();
		BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
		InputStream is = bufHttpEntity.getContent();
		Bitmap bitmap = BitmapFactory.decodeStream(is);
		return new BitmapDrawable(bitmap);

	}

	private static UrlEncodedFormEntity getPostEntity(String value)
			throws UnsupportedEncodingException {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		String[] keyVals = value.split("&");
		String[] params = null;
		for (int i = 0; i < keyVals.length; i++) {
			params = keyVals[i].split("=");
			if (params.length > 1) {
				nameValuePairs
						.add(new BasicNameValuePair(params[0], params[1]));
			} else {
				nameValuePairs.add(new BasicNameValuePair(params[0], ""));
			}
		}

		return new UrlEncodedFormEntity(nameValuePairs);
	}
}
