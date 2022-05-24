package com.incubyte.stringcalculator;

public class StringCalculator {

	public static int add(String numbers) {

		int result = 0;
		if (numbers.isBlank() || numbers.isEmpty()) {
			return result;
		} else {
			String[] nums = numbers.split(",");
			for (String num : nums) {
				result += !num.trim().isBlank() && !num.trim().isEmpty() ? Integer.parseInt(num.trim()) : 0;
			}

		}
		return result;
	}

}
