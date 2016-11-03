package com.learn.codeGather.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ImportantFile {

	public static void main(String[] args) {
		String tempPathString="/opt/jboss-test/UploadFiles/";
		String commands="jar -xvf "+tempPathString+args[0]+" resources";//arg[0]表示war包的路径
		System.out.println("====解压war包命令："+commands);
		System.out.println(TransferFile(commands));
	}

	public static String TransferFile(String commands) {
		String result = "false";
		System.out.println("================临时目录解压war包开始==================");
		try {
			Process process = Runtime.getRuntime().exec(commands);
			InputStreamReader ir = new InputStreamReader(
					process.getInputStream());
			BufferedReader input = new BufferedReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(process.waitFor());
			if (process.waitFor() == 0) {
				result = "true";
			}
		} catch (Exception e) {
			result = "false";
			e.printStackTrace();
		}
		return result;
	}
}
