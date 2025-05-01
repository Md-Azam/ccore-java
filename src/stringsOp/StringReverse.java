package stringsOp;

public class StringReverse {
	public static void main(String[] args) {
		
		String s = "azam";
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		System.out.println("Reverse String is: " +sb);
		String sentence1 = "Azam is here";
		System.out.println(isPalindromeSentence(sentence1));

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
}
