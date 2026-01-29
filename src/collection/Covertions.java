package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Covertions {
	public static void main(String[] args) {

		List<Integer> listInt = List.of(1, 2, 3, 4, 55, 44, 4, 32);
		List<String> list = List.of("Azam", "Pine", "Lichi");

		// Convert list to Map
		Map<String, Integer> result = list.stream().collect(Collectors.toMap(value -> value, value -> value.length()));
		System.out.println("convert List to map: " + result);

		// Comparator [ to find min and max]
		int min = listInt.stream().min(Integer::compareTo).get();
		int max = listInt.stream().max(Integer::compareTo).get();
		System.out.println("Minimun in list is: " + min + " and max in list is: " + max);

		// List to set:
		// Using treeset for sorted set
		List<String> listForSet = Arrays.asList("apple", "banana", "apple", "orange");
		Set<String> set = new TreeSet<>(listForSet);
		System.out.println(set); // Output: [apple, banana, orange]

		// Using collectors.
		Set<String> set2 = listForSet.stream().collect(Collectors.toSet());
		System.out.println(set2); // Output: [banana, orange, apple]

		// List to set for Integers
		List<Integer> intListSet = Arrays.asList(10, 2, 3, 1, 2, 4, 3, 5, 6);
		Set<Integer> intSet = new HashSet<>(intListSet);
//		Set<Integer> intSet = intListSet.stream().collect(Collectors.toSet());
		System.out.println(intSet);

		Set<Integer> newSortedSet = new HashSet<>(listInt);
		System.out.println("newSortedSet: " + newSortedSet);

	}

}
