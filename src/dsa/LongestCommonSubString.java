package dsa;

public class LongestCommonSubString {

	public static String findLongestSubstring(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

//		stores results of the previous row.
		int[] prev = new int[n + 1];
//		curr → stores results for the current row.
		int[] curr = new int[n + 1];

		int maxLength = 0;
		int endIndex = 0; // End index in s1

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					curr[j] = prev[j - 1] + 1;

					if (curr[j] > maxLength) {
						maxLength = curr[j];
						endIndex = i;
					}
				} else {
					curr[j] = 0;
				}
			}
			// Move curr to prev for next iteration
			int[] temp = prev;
			prev = curr;
			curr = temp;
		}

		return s1.substring(endIndex - maxLength, endIndex);
	}

	public static void main(String[] args) {
//    	Time: O(m × n) and Space: O(n)
		String s1 = "Azamishere";
		String s2 = "ishereAzam";

		String result = findLongestSubstring(s1, s2);
		System.out.println("Longest Common Substring: " + result);
	}
}
