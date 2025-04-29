package logical;

public class ReverseNumber {

    public static void main(String[] args) {
        System.out.println(reverseNumberUsingString(789));  // Output should be 987
        System.out.println(palindromeNumberManually(454));
    }

    public static boolean reverseNumberUsingString(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));  // No need for .toString()
        sb.reverse(); // reverse the string
        System.out.println(sb); // shows the reversed string

        int rev = Integer.parseInt(sb.toString()); // convert the reversed string back to int
        if(rev == n){
        	// return the reversed number
        	return true;
        	
        }
        return false;
    }
    public static boolean palindromeNumberManually(int n) {
        int original = n;  // Save the original number
        int rev = 0;
        
        while (n != 0) {  // Continue until n becomes 0
            int reminder = n % 10;  // Get last digit
            rev = rev * 10 + reminder;  // Add it to reversed number
            n = n / 10;  // Remove the last digit
            System.out.println("rev: " + rev + ", rem: " + reminder + ", number: " + n);
        }
        
        return (rev == original);  // After reversing fully, compare with original
    }


}
