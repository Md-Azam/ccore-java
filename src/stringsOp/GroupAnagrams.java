package stringsOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public static void main(String args[]) {
		// Create an array of words we want to group
		String[] words = { "bat", "cat", "act", "tac", "dog", "tab" };

		// Call our method to group anagrams and store the result
		List<List<String>> groupedAnagrams = groupAnagrams(words);
		System.out.println("groupedAnagrams: "+ groupedAnagrams);

		// Print each group from the result
		for (List<String> group : groupedAnagrams) {
			System.out.println(group); // Example output: [bat, tab]
		}
	}

// Method to group anagrams and return a List of Lists
	static List<List<String>> groupAnagrams(String[] words) {
		// Create a HashMap where:
		// Key -> sorted version of the word (e.g. "bat" -> "abt")
		// Value -> list of all words with that key (anagrams)
		Map<String, List<String>> map = new HashMap<>();

		// Loop through each word in the input array
		for (String word : words) {
			// Convert word into its sorted "canonical form"
			System.out.println("word by word: " + word);
			String sortedKey = sortString(word);
			System.out.println("sortedKey: "+ sortedKey);

			// Add word to the list in the map for this key
			// If key doesn't exist, create a new ArrayList first
			map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(word);
		}

		// Return all values from the map as a new ArrayList
		// This gives us a List<List<String>> (each list = one group)
		return new ArrayList<>(map.values());
	}

// Helper method: sort characters of a string alphabetically
	static String sortString(String str) {
		// Convert string to char array
		char[] chars = str.toCharArray();
		// Sort the characters in ascending order
		Arrays.sort(chars);
		// Convert sorted char array back into a string
		return new String(chars);
	}

}
