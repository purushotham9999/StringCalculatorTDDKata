package com.incubyte.stringcalculator;

import java.util.stream.Stream;

public class StringCalculator {

	public static int add(String numbers) {

		int result = 0;
		if (numbers.isBlank() || numbers.isEmpty()) {
			return result;
		} else {
			String[] nums;

			if (!numbers.contains("//")) {
				nums = numbers.trim().split(",|\n");
			} else {
				nums = numbers.trim().substring(2).split(numbers.charAt(2) + "|\n");
			}
			result = Stream.of(nums).filter(s -> !s.isBlank() && !s.trim().isEmpty())
					.mapToInt(s -> Integer.parseInt(s.trim())).sum();

		}
		return result;
	}

}
