package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class FindDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(56);
		list.add(2);
		list.add(32);
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
