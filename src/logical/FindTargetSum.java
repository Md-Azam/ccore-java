package logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 */
public class FindTargetSum {
	public static void main(String[] args) {
		int arr[] = { 12, 34, 56, 6, 7, 99, 28, 102 };
		// sorting array using bubble sort:
		// for larger array use merge,quick sorting algorithm:
		for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
		//calling findTargetSumUsingSet
		int[] findTargetSumUsingSetArr = findTargetSumUsingSet(arr);
		System.out.println("findTargetSumUsingSetArr "+ Arrays.toString(findTargetSumUsingSetArr));
		// Print sorted array using Arrays.toString
        System.out.println("Sorted array: " + Arrays.toString(arr));
		// Find two element that sum up to 60:
		int target = 40;
		boolean found = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					System.out.println("element that sum is equals to " + target + " : " + arr[i] + " and " + arr[j]);
					found = true;
					// The break statement exits the inner loop immediately after finding the first matching pair
					break;
				}
			}
			if (found) {
				System.out.println("Second time target matched with two num whose sum equal to "+ target );
				break;
			}
		}
		if (!found) {
			System.out.println("Not found any Targeted sum");
		}
		System.out.println("Calling findSecondLargestInArry");
		findSecondLargestInArry(arr);
	}
	public static int findSecondLargestInArry(int arr[]) {
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : arr) {
			list.add(num);
		}
		System.out.println("sorted List is "+ list);
		int l = list.size();
		System.out.println("size of array is "+l);
		int seondLargest = list.get(l-2);
		System.out.println("second highest element in list is "+seondLargest);
		return seondLargest;
		
	}
	
	public static int[] findTargetSumUsingSet(int[] arr){
		HashSet<Integer> seen = new HashSet<>();
		int target = 60;
		boolean found = false;

        for (int num : arr) {
            int complement = target - num;

            if (seen.contains(complement)) {
                System.out.println("Found target sum: " + complement + " and " + num + " = " + target);
                found = true;
                break;
            }

            seen.add(num);
        }

        if (found) {
            System.out.println("Targeted sum found in findTargetSumUsingSet.");
        } else {
            System.out.println("Targeted sum not found.");
        }
		return arr;
		
	}
	

}
