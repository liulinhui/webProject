package com.learn.codeGather.demo;

import java.util.Arrays;
import java.util.List;

public class NumberFormatTest {
	public static void main(String[] args) {  
	      
	    List<String> numbers = Arrays.asList( 
	    		"200000"
	    );  
	      
	    NumberText nt = NumberText.getInstance(NumberText.Lang.ChineseSimplified);  
	    for(String number : numbers)  
	      System.out.println(nt.getText(number));  
	  }  
}