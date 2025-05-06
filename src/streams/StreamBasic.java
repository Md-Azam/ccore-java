
package streams;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasic {
    public static void main(String[] args) {
    	
    	List<Integer> numbers = Arrays.asList(2,4,3,7,5,55,66,51);
    	//convert list into streams and only unique number
    	List<Integer> list = numbers.stream().distinct().toList();
    	System.out.println("list "+ list);
    	
    	// list of string.
    	List<String> fruits = Arrays.asList("Apple","Mango","Banana","Apple");
    	List<String> fruiltInStream = fruits.stream().distinct().toList();
    	System.out.println("fruiltInStream: "+ fruiltInStream);
    	
    	//Event number in list of integers:
    	List<Integer> evens = list.stream().filter(num -> num%2==0).toList();
    	System.out.println(evens);
    	
    	//Odd number in list of integers:
    	List<Integer> odds = list.stream().filter(num -> num%2!=0).collect(Collectors.toList());
    	System.out.println(odds);
    	
    	//Sum off all elements :
    	int sum = list.stream().mapToInt(Integer :: intValue).sum();
    	System.out.println(sum);
    	
    	//Search Char in a List of string
    	List<String> upperCaseStrings = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    	System.out.println("upperCaseStrings "+ upperCaseStrings);
    	char toFind = 'A';
    	long count = upperCaseStrings.stream().filter(str -> str.contains(String.valueOf(toFind))).count();
    	System.out.println("total count of "+toFind + " is "+ count);
        
    }
}