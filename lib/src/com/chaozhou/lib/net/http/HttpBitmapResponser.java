package com.chaozhou.lib.net.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.BufferedHttpEntity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

class HttpBitmapResponser extends HttpResponser<Bitmap> {

	public HttpBitmapResponser(HttpResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Bitmap getResponse() throws IllegalStateException,
			IOException {
		// TODO Auto-generated method stub
		HttpEntity entity = response.getEntity();
		BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
		InputStream is = bufHttpEntity.getContent();
		Bitmap bitmap = BitmapFactory.decodeStream(is);
		return bitmap;
	}

}
