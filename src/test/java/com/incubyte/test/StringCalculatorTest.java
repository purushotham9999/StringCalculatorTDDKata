package com.incubyte.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.incubyte.stringcalculator.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void whenEmptyStringReturnZero() throws Exception {

		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void when1NumberReturnResult() throws Exception {

		assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public void when2NumbersReturnResult() throws Exception {

		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void whenWrongInputThrowException() {

		assertThrows(NumberFormatException.class, () -> StringCalculator.add("1,X"));
	}

	@Test
	public void handleNewLinesBetweenNumbersAndReturnSum() throws Exception {

		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

	@Test
	public void handleMultipleNewLinesAndCommasBetweenNumbesAndReturnSum() throws Exception {

		assertEquals(30, StringCalculator.add("    1,2\n3\n4\n   4,  4\n4 ,4 \n4 "));
	}

	@Test
	public void handleDifferentDelimitersAndReturnSum() throws Exception {

		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}

	@Test
	public void handleDifferentDelimitersAndReturnSumTest2() throws Exception {

		assertEquals(6, StringCalculator.add("//@\n1@2\n3"));
	}

	@Test
	public void whenNegativeInputThrowException() {

		Exception exception = assertThrows(Exception.class, () -> StringCalculator.add("1,-2, 3, -4,5"));
		assertEquals(exception.getMessage(), "negatives not allowed, and the negative(s) passed = [-2, -4]");

	}

}
