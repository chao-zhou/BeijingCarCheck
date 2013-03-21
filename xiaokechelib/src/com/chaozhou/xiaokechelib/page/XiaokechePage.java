package com.chaozhou.xiaokechelib.page;

import java.io.IOException;

public interface XiaokechePage<T> {
	public T getPage() throws IllegalStateException, IOException;
}
