package com.scotthensen.toolbox.si;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@Configuration
//@ImportResource("classpath:messageschannels/channels-all-direct-boot.xml")
public class SiMessagesChannelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiMessagesChannelsApplication.class, args);
	}

}
