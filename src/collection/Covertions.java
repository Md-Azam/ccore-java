package collection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Covertions {
	public static void main(String[] args) {
		
		List<Integer> listInt = List.of(1,2,3,4,55,44,32);
		List<String> list = List.of("Azam","Pine","Lichi");
		
		//Convert list to Map
		Map<String,Integer> result = list.stream().collect(Collectors.toMap(value -> value, value -> value.length()));
		System.out.println("convert List to map: "+ result);
		
		//Comparator [ to find min and max]
		int min = listInt.stream().min(Integer:: compareTo).get();
		int max = listInt.stream().max(Integer:: compareTo).get();
		System.out.println("Minimun in list is: "+ min + " and max in list is: "+ max);
		
	}	

}
