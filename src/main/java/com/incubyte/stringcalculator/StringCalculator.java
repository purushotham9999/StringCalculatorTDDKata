package com.incubyte.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StringCalculator {

	public static int add(String numbers) throws Exception {

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
			List<Integer> numList = Stream.of(nums).filter(s -> !s.isBlank() && !s.trim().isEmpty())
					.mapToInt(s -> Integer.parseInt(s.trim())).collect(ArrayList::new, List::add, List::addAll);

			if (numList.stream().anyMatch(n -> n <= 0)) {

				throw new Exception("negatives not allowed, and the negative(s) passed = "
						+ numList.stream().filter(n -> n <= 0).toList());
			}
			result = numList.stream().reduce(Integer::sum).get();

		}
		return result;
	}

}
