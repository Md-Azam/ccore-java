package stringsOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringReverse {
	public static void main(String[] args) {

		String s = "azam";
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		System.out.println("Reverse String is: " + sb);
		String sentence1 = "this siht";
		System.out.println(isPalindromeSentence(sentence1));
		System.out.println(checkAnagram());
	}

	public static boolean isPalindromeSentence(String s) {
		// Convert to lowercase and remove non-alphanumeric characters
		s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

		int left = 0;
		int right = s.length() - 1;

		// Two-pointer approach
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static List<String> checkAnagram() {
		List<String> listStr = new ArrayList<>();
		String s1 = "listen";
		String s2 = "silent";

		System.out.println("s1: " + s1 + " s2: " + s2);

		if (s1.length() == s2.length()) {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();

			Arrays.sort(c1);
			Arrays.sort(c2);

			System.out.println("Sorted c1: " + new String(c1) + " Sorted c2: " + new String(c2));

			if (Arrays.equals(c1, c2)) {
				listStr.add(s1);
				listStr.add(s2);
			}
		}
		return listStr;
	}

}
