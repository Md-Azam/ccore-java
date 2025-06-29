package dsa;

import java.util.ArrayList;
import java.util.List;

public class ParanthesisGenerator {
	public static void main(String[] args) {
		System.out.println(generateParantheses(1));
		
	}

		//write a function to generate well formed combination of parentheses
	public static void generate(List<String> result,int max, int open, int close, String unProcessed) {
		if(unProcessed.length() == (2*max)) {
			result.add(unProcessed);
		}
			if (open<max) {
				generate(result,max,open+1,close,unProcessed+"(");
			}
			if(close <open) {
				generate(result,max,open,close+1,unProcessed+")");
				
		}
		
	}
	public static List<String> generateParantheses(int n) {
		List<String> ls = new ArrayList<String>();
		generate(ls,n,0,0,"");
		return ls;
		
	}
}
