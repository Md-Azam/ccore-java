package basics.paractice;

import java.util.Arrays;

public class AnagramString {
	public static void main(String[] args) {
		System.out.println(checkAnagram("azam", "maza"));
	}

	public static boolean checkAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch2);
		Arrays.sort(ch1);
		if(Arrays.equals(ch1, ch2)) {
			return true;
		}else {
			return false;
		}

	}
}
