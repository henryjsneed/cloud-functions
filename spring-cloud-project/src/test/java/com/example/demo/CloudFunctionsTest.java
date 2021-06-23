package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@FunctionalSpringBootTest
class CloudFunctionsTest {

	@Autowired
	private FunctionCatalog catalog;
	@Test
	void testUppercaseThenReverseReactive() {
		String input = "Spring Cloud";
		String expectedOutput = "DUOLC GNIRPS";
		
		Function<Flux<String>, Flux<String>> function = catalog.lookup(Function.class, "uppercase|reverseReactive");
		
		StepVerifier.create(function.apply(Flux.just(input)))
		        .expectNextMatches(actualOutput -> actualOutput.equals(expectedOutput))
		        .verifyComplete();
	}

}
