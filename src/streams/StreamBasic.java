
package streams;
import java.util.*;
import java.util.stream.Collectors;

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
        
    }
}