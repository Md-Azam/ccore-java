package basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class FindRepeatesChars {

	public static void main(String[] args) {

		String input = "azam";
		List<Character> listChar = new ArrayList<>();
		Map<Character, Long> charCounts = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("charCounts is : " + charCounts);
		Long maxCount = Collections.max(charCounts.values());
		System.out.println("maxCount: " + maxCount);
		for (Map.Entry<Character, Long> entry : charCounts.entrySet()) {
			if (entry.getValue() == maxCount) {
				listChar.add(entry.getKey());
			}
		}
		System.out.println("listChar: " + listChar);
		System.out.println("charCounts: " + charCounts);

	}
}
