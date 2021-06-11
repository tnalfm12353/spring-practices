package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning)
//		testBeanFactory01();
		
		// XML Bean Configuration(Explicit Configuration)
		testBeanFactory02();
	}

	// XML Auto Configuration(Annotation Scanning)
	private static void testBeanFactory01() {
		ClassPathResource classPath = new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml");
		BeanFactory bf =new XmlBeanFactory(classPath);
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// Bean id가 자동으로 설정됨.
		user1 = (User1)bf.getBean("user1");
		System.out.println(user1.getName());
	}
}
