package com.jdc.demo;

public class Client {

	private Service service;
	
	public Client() {
		this.service = new Service();
	}
	
	public void doSomething() {
		service.methodThrowingUncheckedError();
	}
}
