package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramUsingStream {
	public static void main(String[] args) {
		String s1 = "care";
		String s2 = "race";

		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		System.out.println("s1: "+ s1);
		s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		System.out.println("s2: "+ s2);
		if (s1.equals(s2) == true) {
			System.out.println("String is An anagram" + "s1: " + s1 + " s2: " + s2);
		} else {
			System.out.println("String is not Anagram");
		}
	}
}
