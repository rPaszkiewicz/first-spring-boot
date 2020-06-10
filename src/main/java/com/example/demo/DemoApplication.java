package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name",defaultValue = "user")String name){
		return String.format("Welcome, %s",name);
	}
	@GetMapping("/yolo")
	public String yolo(@RequestParam(value = "string", defaultValue = "kolo") String sthg){
		return String.format("Yolo %s",sthg);
	}
	@GetMapping("/howdy")
	public String howdy(@RequestParam(value = "word", defaultValue = "default man") String name){
		return String.format("howdy there %s",name);
	}

}
