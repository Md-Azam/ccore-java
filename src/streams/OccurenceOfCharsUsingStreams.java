package streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceOfCharsUsingStreams {
	public static void main(String[] args) {
		String input = "AZAm is here";
		countEachChar(input);
		char c = 'A';
		System.out.println(countParticularCharOccurence(input, c));
		
		
	}
	
	//count of each character is string using streams
	public static void countEachChar(String s){
		Map<Character, Long> charCount = s.chars() // returns an IntStream
	            .mapToObj(c -> (char) c) // convert int to Character
	            .filter(c -> !Character.isWhitespace(c)) // optional: skip whitespaces
	            .collect(Collectors.groupingBy(
	                Function.identity(),
	                Collectors.counting()
	            ));

	      charCount.forEach((k, v) -> System.out.println(k + ": " + v));
		
	}
	/*Return only selected character occurence in a given string:
	 * Convert the string into character stream.
	 * Check if the character in the stream is the character to be counted using filter() function.
	 * Count the matched characters using the count() function.
	 * */
	public static long countParticularCharOccurence(String s, char ch)
    {

        long total =  s.chars()
            .filter(c -> c == ch)
            .count();
        System.out.println(ch+ " occurs "+ total + " time in give string: "+ s);
        return total;
    }

	
}