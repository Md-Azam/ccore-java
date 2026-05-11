package basics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) {
		/*
		 * Given a list of integers: [-1, 2, 2, 3, 4, 4, 4]
		 * 
		 * Using Java Streams, return a Map<Integer, Long> that contains only even
		 * numbers with their frequency, e.g. {2=2, 4=3}.
		 */
		List<Integer> list = Arrays.asList(-1, 2, 2, 3, 4, 4, 4);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				System.out.println(list.get(i));
				map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
			}
		}

//		
		System.out.println(map);
	}

	// Map<Integer, Long> map = list.stream()
//			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
//			.filter(entry -> entry.getValue() % 2 == 0)
//			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//	Map<Integer, Long> map2 = list.stream().filter(n -> n % 2 == 0)
//			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}