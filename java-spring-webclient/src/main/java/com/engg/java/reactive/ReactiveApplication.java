package com.engg.java.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReactiveApplication.class, args);

		ReqResWebClient webClient = new ReqResWebClient();
		System.out.println(webClient.getResult());
		System.out.println(webClient.getUser1());
		System.out.println(webClient.getUser2());
	}
}
