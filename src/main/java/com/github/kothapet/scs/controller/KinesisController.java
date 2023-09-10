package com.github.kothapet.scs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.google.common.base.Supplier;

@Configuration
@Controller
public class KinesisController {
	
	@Autowired
	StreamBridge streamBridge;
	
	@Bean
	Supplier<Integer> mySupplier() {
		return() -> {
			Integer int1 = (int) (Math.random() * 1000);
			System.out.println("mySupplier creating payload " + int1);
			return int1;
		};
	}

}
