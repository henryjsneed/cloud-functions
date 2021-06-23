package com.example.demo;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Configuration
@Slf4j
public class Functions {
    private static final Logger log = LoggerFactory.getLogger(SpringCloudProjectApplication.class);

    @Bean
    Function<String, String> uppercase() {
    	return message -> {
    		log.info("Converting {} to uppercase", message);
    		return message.toUpperCase();
    	};
    }
    
    @Bean
    Function<String, String> reverse() {
    	return message -> {
    		log.info("Reversing {}", message);
    		return new StringBuilder(message).reverse().toString();
    	};
    }
    
    @Bean
    Function<Message, String> reverseWithMessage() {
    	return message -> {
    		log.info("Reversing {}", message.getContent());
    		return new StringBuilder(message.getContent()).reverse().toString();
    	};
    }
    
    @Bean
    Function<Flux<String>, Flux<String>> reverseReactive() {
    	return flux -> flux
    			.map(message -> new StringBuilder(message).reverse().toString());
    };
    
}

class Message {

	private String content;
	
	public Message() {};
	
	public Message(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
