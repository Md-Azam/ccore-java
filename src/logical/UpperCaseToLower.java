package logical;

public class UpperCaseToLower {

	    public static void main(String args[]) {
	        String s = "AZams";
	        String ns = "";

	        for (int i = 0; i < s.length(); i++) {
	            char ch = s.charAt(i);
	            if ('A' <= ch && ch <= 'Z') {
	                ch = (char)(ch + 32); // convert to lowercase
	            }
	            ns += ch; // add to new string
	        }

	        System.out.println("Original: " + s);
	        System.out.println("Converted: " + ns);
	    }
	


}
