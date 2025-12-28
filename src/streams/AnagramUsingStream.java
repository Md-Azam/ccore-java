package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramUsingStream {
	public static void main(String[] args) {
		String str1 = "care";
		String str2 = "race";
		
		str1 = Stream.of(str1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		System.out.println("str1: "+ str1);
		str2 = Stream.of(str2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		System.out.println("value of str2: "+ str2);
		if (str1.equals(str2) == true) {
			System.out.println("String is An anagram" + "s1: " + str1 + " s2: " + str2);
		} else {
			System.out.println("String is not Anagram");
		}
	}
}
