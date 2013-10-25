package lesson03.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet {
	ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출됨");
		this.config = config;
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출됨");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service() 호출됨");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig() 호출됨");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo() 호출됨");
		return "version=1.0;author=eomjinyoung;copyright=eomjinyoung 2013";
	}
}
