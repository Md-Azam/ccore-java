package collection;

import java.util.HashSet;

public class HashSet1 {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 3, 4, 5, 6, 7, 8 };
//		System.out.println((arr));
		printDuplicates(arr);
	}

	public static void printDuplicates(int[] nums) {
		HashSet<Integer> seen = new HashSet<>();
		HashSet<Integer> duplicates = new HashSet<>();

		for (int num : nums) {
			if (!seen.add(num)) {
				duplicates.add(num); // already seen -> it's a duplicate
			}
		}

		if (duplicates.isEmpty()) {
			System.out.println("No duplicates found.");
		} else {
			System.out.println("Duplicate elements:");
			for (int dup : duplicates) {
				System.out.println(dup);
			}
		}
	}
}
