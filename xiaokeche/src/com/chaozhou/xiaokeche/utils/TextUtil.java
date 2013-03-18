package com.chaozhou.xiaokeche.utils;

import java.util.ArrayList;
import java.util.List;

public class TextUtil {

	public static Integer[] findAllIndex(String base, String sub) {
		List<Integer> indexList = new ArrayList<Integer>();
		int index = 0;
		while (index < base.length()) {
			index = base.indexOf(sub, index);

			if (index < 0)
				break;

			indexList.add(index);
			index += sub.length();
		}

		Integer[] result = new Integer[indexList.size()];
		return indexList.toArray(result);
	}
}
