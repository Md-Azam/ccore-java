package dsa;

public class BubbleSort {
	public static void main(String[] args) {

		int[] array = { 5, 3, 8, 1, 9 };

		bubbleSort(array);

		System.out.print("Sorted array: ");
		for (int num : array) {
			System.out.print(num + " ");
		}
	}

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped;

		// Outer loop for each pass
		for (int i = 0; i < n - 1; i++) {
			swapped = false;

			// Inner loop for pairwise comparisons
			for (int j = 0; j < n - i - 1; j++) {
				// Swap if the current element is greater than the next
				if (arr[j] > arr[j + 1]) {
					// Swap arr[j] and arr[j + 1]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					swapped = true;
				}
			}

			// If no elements were swapped in this pass, the array is sorted
			if (!swapped) {
				break;
			}
		}
	}
}
