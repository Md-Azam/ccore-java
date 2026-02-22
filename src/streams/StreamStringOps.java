
package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStringOps {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(2, 4, 3, 7, 5, 55, 66, 51);
		// convert list into streams and only unique number
		List<Integer> list = numbers.stream().distinct().toList();
		System.out.println("list " + list);

		// list of string.
		List<String> fruits = Arrays.asList("Apple", "Mango", "Banana", "Apple");
		List<String> fruiltInStream = fruits.stream().distinct().toList();
		System.out.println("fruiltInStream: " + fruiltInStream);

		// Event number in list of integers:
		List<Integer> evens = list.stream().filter(num -> num % 2 == 0).toList();
		System.out.println(evens);

		// Odd number in list of integers:
		List<Integer> odds = list.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
		System.out.println(odds);

		// Sum off all elements :
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);

		// Search Char in a List of string
		List<String> upperCaseStrings = fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("upperCaseStrings " + upperCaseStrings);
		char toFind = 'A';
		long count = upperCaseStrings.stream().filter(str -> str.contains(String.valueOf(toFind))).count();
		System.out.println("total count of " + toFind + " is " + count);

		// Sort Arrays in descending order
		int[] array = { 5, 3, 8, 1, 9 };
		array = Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(array));

		// natural sorting of int[] array = { 5, 3, 8, 1, 9 };
		array = Arrays.stream(array).sorted().toArray();
		System.out.println(Arrays.toString(array));

		// natural sorting on List<Integer> numbers = Arrays.asList(2, 4, 3, 7, 5, 55,
		// 66, 51);
		List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedNumbers);

		
		//Taking a string
		String s = "Linkeidn";

		//Find first character of string
		Optional<Map.Entry<Character, Long>> first = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
		System.out.println("first character: " + first);
		
		//Find most frequent character in a string
		String st = "banana";
		Map.Entry<Character, Long> mostFreqChar = st.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
		System.out.println(mostFreqChar);
		
		//Find occurence of each word in a list of string
		List<String> listFruit = Arrays.asList("apple", "banana", "litchi", "pomagranete", "litchi", "banana");
		Map<String, Long> map = listFruit.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Result count of occurence of word" + map);
		
		
		//Print Occurence of chars in json format
		String listFruit1 = "MangoAAm";
		listFruit1 = listFruit1.toLowerCase();
		Map<Character, Integer> countChars = new HashMap<>();
		for (char c : listFruit1.toCharArray()) {
			countChars.put(c, countChars.getOrDefault(c, 0) + 1);
		}
		System.out.println(countChars);
		StringBuilder sb = new StringBuilder();
		StringBuilder json = new StringBuilder();
		json.append("{\n");
		for (Map.Entry<Character, Integer> entry : countChars.entrySet()) {
			json.append("  \"").append(entry.getKey()).append("\": ").append(entry.getValue()).append(",\n");
		}

		// remove last comma
		json.setLength(json.length() - 2);
		json.append("\n}");

		System.out.println(json.toString());

		// 🔹 Output 1: { (a:2),(b:3),(c:2),(d:2) }
		StringBuilder format1 = new StringBuilder();
		format1.append("{ ");

		for (Map.Entry<Character, Integer> entry : countChars.entrySet()) {
			format1.append("(").append(entry.getKey()).append(":").append(entry.getValue()).append("),");
		}

		format1.setLength(format1.length() - 1); // remove last comma
		format1.append(" }");

		System.out.println(format1.toString());
		// 🔹 Output 2: a2b3c2d2
		StringBuilder format2 = new StringBuilder();

		for (Map.Entry<Character, Integer> entry : countChars.entrySet()) {
			format2.append(entry.getKey()).append(entry.getValue());
		}

		System.out.println(format2.toString());

	}
}