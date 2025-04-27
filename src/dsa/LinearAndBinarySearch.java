package dsa;

public class LinearAndBinarySearch {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 12, 16,3, 23, 38, 42 };
		int target = 38;

		int result = linearSearch(arr, target);
		if (result != -1) {
			System.out.println("Element found at index " + result);
		} else {
			System.out.println("Element not found in the array");
		}

		int result1 = binarySearch(arr, target);
		if (result1 != -1) {
			System.out.println("Element found at index " + result1);
		} else {
			System.out.println("Element not found in the array");

		}

	}

	/*
	 * In the worst-case scenario, the linear search has a time complexity of O(n),
	 * where 'n' is the number of elements in the array. This is because in the
	 * worst case, you may have to go through all the elements in the array to find
	 * the target.
	 * 
	 * 1.define a 1D Array: 2.loop over the Array.length -1 3.Check if element at
	 * index[i] == target then return i else return -1.
	 * 
	 */
	// Linear Search:
	public static int linearSearch(int[] array, int target) {
		int step = 0;
		for (int i = 0; i < array.length; i++) {
			step++;
			if (array[i] == target) {
				System.out.println("steps taken by linear search: " + step);
				return i;
			}
		}
		return -1;
	}

	/*
	 * Binary Search : The time complexity of binary search is O(log n) in the worst
	 * case. This is because with each comparison, the search space is halved.
	 * 1.Define a array: 2.
	 */

	public static int binarySearch(int[] array, int target) {
		int steps = 0;
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			steps++;
			int mid = (left + right) / 2;
			if (array[mid] == target) {
				System.out.println("steps taken by binay search:" + steps);
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {

				right = mid - 1;
			}
		}
		System.out.println("steps to completing searching is: " + steps);
		return -1;

	}

}
