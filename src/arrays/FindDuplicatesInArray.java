package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicatesInArray {

	// Make method static (so it can be called from main)
	public static <T> Set<T> checkDuplicates(T[] array) {
		Set<T> seenRecord = new HashSet<>();
		return Arrays.stream(array).filter(val -> !seenRecord.add(val)).collect(Collectors.toSet());
	}

	public static void main(String[] args) {

		Integer[] genericArray = { 1, 2, 3, 4, 5, 3, 2, 1, 66, 77 };

		System.out.println("checkDuplicates: " + checkDuplicates(genericArray));
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(56);
		list.add(2);
		list.add(32);
		list.add(5);
		System.out.println("list: " + list);
		HashSet<Integer> seen = new HashSet<>();
		HashSet<Integer> duplicate = new HashSet<>();
		for (int num : list) {
			if (!seen.add(num)) {
				duplicate.add(num);
			}
		}
		System.out.println("duplicate: " + duplicate);

		// approach 2 using MAP:
		Map<Integer, Integer> counts = new HashMap<>();

		for (int num : list) {
			counts.put(num, counts.getOrDefault(num, 0) + 1);
		}

		System.out.println(counts);
		System.out.println("Finding Duplicate elements..... : ");
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " → " + entry.getValue() + " times");
			}
		}

	}

}
