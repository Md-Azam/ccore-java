package basics.paractice;

public class AnagramString {
public static void main(String[] args) {
	System.out.println(checkAnagram("azam","maza"));
}

public static boolean checkAnagram(String s1, String s2) {
	if (s1.length() !=s2.length()) return false;
	  int[] count = new int[26]; // For 26 lowercase letters

      for (int i = 0; i < s1.length(); i++) {
          count[s1.charAt(i) - 'a']++;  // Increment count for s1
          count[s2.charAt(i) - 'a']--;  // Decrement count for s2
      }

      for (int c : count) {
          if (c != 0) return false; // If any count is not zero, not an anagram
      }

      return true;
	
}
}
