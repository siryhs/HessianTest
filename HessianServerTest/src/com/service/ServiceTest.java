package com.service;

import java.net.MalformedURLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caucho.hessian.client.HessianProxyFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:hessian-client.xml")
public class ServiceTest {
	
	@Autowired
	@Qualifier("hessianClient")
	private HelloService hessianClient;
	@Test
	public void testHelloService() throws MalformedURLException {

		System.out.println(hessianClient.helloWorld("jimmy"));
	}
	
	public void test() throws MalformedURLException {
		String url = "http://localhost:80/HessianServer/hessian/service";
		System.out.println(url);
		HessianProxyFactory factory = new HessianProxyFactory();
		HelloService helloService = (HelloService) factory.create(HelloService.class, url);
		System.out.println(helloService.helloWorld("jimmy"));
	}
}