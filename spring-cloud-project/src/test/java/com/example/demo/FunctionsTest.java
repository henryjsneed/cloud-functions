package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FunctionsTest {
    
	private Functions functions = new Functions();
	
	@Test
	void testUppercase() {
		String input = "this test";
		String expectedOutput = "THIS TEST";
		
		String actualOutput = functions.uppercase().apply(input);
		
		assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
	void testReverse() {
		String input = "this test";
		String expectedOutput = "tset siht";
		String actualOutput = functions.reverse().apply(input);
		assertThat(actualOutput).isEqualTo(expectedOutput);
	}
	
	@Test
	void testUppercaseAndThenReverse() {
		String input = "this test";
		String expectedOutput = "TSET SIHT";
		String actualOutput = functions.uppercase().andThen(functions.reverse()).apply(input);
		assertThat(actualOutput).isEqualTo(expectedOutput);
	}

}
