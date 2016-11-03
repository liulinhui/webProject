package com.learn.codeGather.gathe;

import java.util.Random;

public class randomDemo {

	public static void main(String[] args) {
		int a=0;
		Random random=new Random();
		for (int i = 0; i <300000; i++) {
			double b=Math.sqrt(3.5)*random.nextGaussian()+2.909090909090909;  //高斯分布   均值为2  方差为3
			int c=(int)b;
			if (c<1) {
				c=1;
			}
			if (c>10) {
				c=10;
			}
			System.out.println("产生随机数："+c);
			a=a+c;
		}
		System.out.println("随机数总和"+a);
        double avg=a/300000.0;
        System.out.println("均值："+avg);
        String aString="";
        System.out.println("".equals(aString));
//		int a=32;
//		int b=11;
//		double c=(double)a/b;
//		System.out.println(c);
		
	}
}
