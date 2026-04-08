package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapAndHashMap {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String inputString = "azam";

		List<String> list = Arrays.asList("Azam", "Faisal", "Zinda", "Mallah", "Azam", "Sidra", "silent", "listen",
				"cat", "act", "Faisal");

		// Group Anagram:
		Map<String, List<String>> groupAnagrammap = new HashMap<>();
		for (String s : list) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String skey = new String(ch);
			groupAnagrammap.computeIfAbsent(skey, k -> new ArrayList<>()).add(s);
		}
		System.out.println("groupAnagrammap: " + groupAnagrammap);

		Map<String, Long> listMapping = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(word -> word.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		System.out.println("listMapping: Mean counting works that are duplicates: " + listMapping);
		Set<String> listset = new HashSet<>(list);
		System.out.println("list Set: " + listset);
		inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> {
					System.out.println(k);
				});

		Map<Character, Long> mapwa = inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("mapwa : " + mapwa);

		Map<Character, Integer> charCountMap = countCharacters(inputString);

		// Display the occurrences of each character
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			System.out.println("Character: " + entry.getKey() + "  Occurrences: " + entry.getValue());
		}
//        charCountMap.forEach((k, v) -> System.out.print("(" + k + ":" + v + ")"));
		String result = charCountMap.entrySet().stream().map(e -> "(" + e.getKey() + ":" + e.getValue() + ")")
				.collect(Collectors.joining(",", "{", "}"));

		System.out.println(result);
	}

	public static Map<Character, Integer> countCharacters(String input) {
		// Create a map to store character occurrences
		Map<Character, Integer> charCountMap = new HashMap<>();
		// Iterate through each character in the input string
		for (char c : input.toCharArray()) {
			// Update the count in the map
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}
		return charCountMap;
	}
}