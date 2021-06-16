package com.douzone.hellospring.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.hellospring.config.WebConfig;

public class HelloSpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	//web.xml에 설정된 것들을 여기에서 설정함.
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// Root Application Context 설정 클래스
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Web Application Context 설정 클래스 
		return new Class<?>[] {WebConfig.class};
	} 

	@Override
	protected String[] getServletMappings() {
		// DispatcherServlet Mapping URL
		return new String[] {"/"};
	}

}
