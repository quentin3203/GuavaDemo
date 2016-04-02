package com.guava.demo;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * ����ʽ��� predicate function
 * 
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		// ���ʽ�������
		// ȷ�������е��ַ������Ȳ�����5�����н�ȡ�����д
		List<String> list = Lists.newArrayList("good", "happiness");
		// ��ȡ
		Function<String, String> f1 = new Function<String, String>() {

			@Override
			public String apply(String arg0) {
				return arg0.length() > 5 ? arg0.substring(0, 5) : arg0;
			}
		};
		// ת�ɴ�д
		Function<String, String> f2 = new Function<String, String>() {

			@Override
			public String apply(String arg0) {
				return arg0.toUpperCase();
			}
		};
		Function<String, String> f = Functions.compose(f1, f2);
		Collection<String> reStrings = Collections2.transform(list, f);
		for (String str : reStrings) {
			System.out.println(str);
		}
	}

	// ������
	public static void filter() {
		// ����List��̬��ʼ��
		List<String> list = Lists.newArrayList("moom", "son", "dad", "refer");
		// �ҳ�����
		// �����ڲ�����������ڲ��࣬ͬʱ��������
		Collection<String> pal = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String arg) {
				// ҵ���߼�
				return new StringBuilder(arg).reverse().toString().equals(arg);
			}
		});
		for (String str : pal) {
			System.out.println(str);
		}
	}

	// ����ת��
	public static void transform() {
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(1000000000L);
		timeSet.add(2000010100L);
		Collection<String> time = Collections2.transform(timeSet, new Function<Long, String>() {

			@Override
			public String apply(Long arg) {
				return new SimpleDateFormat("yyyy-MM-dd").format(arg);
			}
		});
		for (String string : time) {
			System.out.println(string);
		}
	}
}
