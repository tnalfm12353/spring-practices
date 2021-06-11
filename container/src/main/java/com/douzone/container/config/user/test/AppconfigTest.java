package com.douzone.container.config.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.config.user.Appconfig01;
import com.douzone.container.user.User;

public class AppconfigTest {

	public static void main(String[] args) {
//		testAppConfig01();
		testAppConfig02();

	}
	
	// Java Config01
	// 직접 설정 자바 클래스를 전달
	// 설정 클래스에 @Configuration이 필요없다.
	private static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig01.class);
		User user = ac.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)ac).close();
	}
	
	// Java Config02
	// 자바 설정 클래스가 있는 베이스 패키지를 전달.
	// 설정 클래스에 @Configuration이 반드시 필요하다.
	private static void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.douzone.container.config.user");
		User user = ac.getBean(User.class);
		System.out.println(user);
		
		((ConfigurableApplicationContext)ac).close();
	}

}
