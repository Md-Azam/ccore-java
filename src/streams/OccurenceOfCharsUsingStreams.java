package streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceOfCharsUsingStreams {
	public static void main(String[] args) {
		String input = "AZAm is here";
		
		Map<Character, Long> charCount = input.chars() // returns an IntStream
	            .mapToObj(c -> (char) c) // convert int to Character
	            .filter(c -> !Character.isWhitespace(c)) // optional: skip whitespaces
	            .collect(Collectors.groupingBy(
	                Function.identity(),
	                Collectors.counting()
	            ));

	        charCount.forEach((k, v) -> System.out.println(k + ": " + v));
	}
}