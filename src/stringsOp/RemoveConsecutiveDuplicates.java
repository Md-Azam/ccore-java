package stringsOp;

public class RemoveConsecutiveDuplicates {

	public static String removeConsecutiveDuplicateChars(String input) {

		if (input == null || input.isEmpty()) {
			return input;
		}
		StringBuilder result = new StringBuilder();
		// Append the first character unconditionally
		result.append(input.charAt(0));
		// Iterate from the second character
		for (int i = 1; i < input.length(); i++) {
			// Append the current character only if it's different from the last character
			// in the result
			if (input.charAt(i) != result.charAt(result.length() - 1)) {
				result.append(input.charAt(i));
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		
		 String str1 = "aabbcdefafffa";
	        System.out.println("Original: " + str1 + ", After removal: " + removeConsecutiveDuplicateChars(str1)); // Output: abcdef

	        String str2 = "aaaaa";
	        System.out.println("Original: " + str2 + ", After removal: " + removeConsecutiveDuplicateChars(str2)); // Output: a

	}

}
