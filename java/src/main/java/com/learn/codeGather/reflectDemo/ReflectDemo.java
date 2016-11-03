package com.learn.codeGather.reflectDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) {
		Field[] fs = Bean.class.getDeclaredFields(); // 得到所有的fields
		System.out.println(fs[0].getType().getSimpleName());
		Bean bean=test(Bean.class);
		System.out.println(bean.getStringsString());
	}
	public static <E> E test(Class<E> clazz) {
		try {
			Class<E> classType = clazz;
			E ob = clazz.newInstance();
			Method issuccess = classType.getMethod("isSuccess",
					new Class[] { boolean.class });
			Object result = issuccess.invoke(ob, new Object[] { new Boolean(
					false) });
			System.out.println(result);
			Method setStringsString = classType.getMethod("setStringsString",
					new Class[] { String.class });
			setStringsString.invoke(ob, new Object[] { new String(
					"草拟吗的") });
			return ob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
