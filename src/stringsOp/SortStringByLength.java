package stringsOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortStringByLength {

	public static void main(String[] args) {
		List<String> s = Arrays.asList("azam", "Sumaiyya", "zafar", "kashmir","faisal","zafar");
		s.stream().sorted(Comparator.comparing(String::length)).forEach(System.out:: println);
		
		Map<String, Long> map = s.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("map: "+ map);
		
		Long maxCount = Collections.max(map.values());
		for(Map.Entry<String, Long> entry : map.entrySet()) {
			if(maxCount == entry.getValue()) {
				System.out.println("the maximum occurrred word time  is: " + entry.getValue() + " i.e : "  + entry.getKey());
			}
		}
		
		
	}
}
