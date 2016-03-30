package com.guava.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Demo01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		List<String> readList = Collections.unmodifiableList(list);
		// list.add("d");//改变原有List，视图也一起改变
		// readList.add("e");//java.lang.UnsupportedOperationException
		for (String str : readList) {
			System.out.println(str);
		}
		// 对比查看 初始化List
		List<String> strings = ImmutableList.of("a", "b", "c");//guava
		// strings.add("d");//java.lang.UnsupportedOperationException
		for (String str : strings) {
			System.out.println(str);
		}
	}
}
