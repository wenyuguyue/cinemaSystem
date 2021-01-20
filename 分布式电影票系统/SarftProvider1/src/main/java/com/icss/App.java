package com.icss;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		context.start();
		System.out.println("provider start ...");
		System.in.read(); // 按任意键退出
	}
}
