package com.learn.codeGather.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {

	public static void main(String[] args) throws IOException, InterruptedException {
		try {
			String commands = " tar -zxvf /home/liulinhui/文档/software/pycharm-professional-2016.2.tar.gz";
			Process process = Runtime.getRuntime().exec(commands);
			InputStreamReader ir = new InputStreamReader(process.getInputStream());
			BufferedReader input = new BufferedReader(ir);
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(process.waitFor());
		} catch (IOException e) {
			System.err.println("IOException " + e.getMessage());
		}
	}
}
