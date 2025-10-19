package collection;

import java.util.HashMap;
import java.util.Map;

public class AnagramUsingMap {

	public static void main(String[] args) {
		String s1 = "madam";
		String s2 = "damam";

		if (isAnagram(s1, s2)) {
			System.out.println(s1 + " and " + s2 + " are anagrams.");
		} else {
			System.out.println(s1 + " and " + s2 + " are NOT anagrams.");
		}
	}

	public static boolean isAnagram(String str1, String str2) {
		// 1. Quick length check
		if (str1.length() != str2.length()) {
			return false;
		}

		// 2. Build frequency map for str1
		Map<Character, Integer> charCount = new HashMap<>();
		for (char c : str1.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		// 3. Decrease count using str2
		for (char c : str2.toCharArray()) {
			if (!charCount.containsKey(c)) {
				return false; // char not found in str1
			}
			charCount.put(c, charCount.get(c) - 1);
			if (charCount.get(c) == 0) {
				charCount.remove(c);
			}
		}

		// 4. If map is empty, strings are anagrams
		return charCount.isEmpty();
	}

}
