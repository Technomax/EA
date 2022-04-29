package edu.miu.cs.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("springconfig.xml");
		SampleClass sc = context.getBean("sampleClass", SampleClass.class);
		for(int i = 0; i < 10; ++i) {
			sc.longRunningMethod();
		}
		System.out.println("Main method continues on!");
	}
}