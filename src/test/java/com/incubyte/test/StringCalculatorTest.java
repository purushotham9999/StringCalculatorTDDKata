package com.incubyte.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.incubyte.stringcalculator.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void whenEmptyStringReturnZero() {

		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void when1NumberReturnResult() {

		assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public void when2NumbersReturnResult() {

		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void whenWrongInputThrowException() {

		assertThrows(NumberFormatException.class, () -> StringCalculator.add("1,X"));
	}

	@Test
	public void handleNewLinesBetweenNumbersAndReturnSum() {

		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

	@Test
	public void handleMultipleNewLinesAndCommasBetweenNumbesAndReturnSum() {

		assertEquals(30, StringCalculator.add("    1,2\n3\n4\n   4,  4\n4 ,4 \n4 "));
	}

}
