package com.service.impl;

import com.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String helloWorld(String message) {
		return "hello," + message;
	}
}