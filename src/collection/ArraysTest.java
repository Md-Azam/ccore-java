package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {

		List<String> list1 = new ArrayList<>();
		List<String> myList1 = Arrays.asList("mango", "litchi", "melon");

		System.out.println(myList1.get(2));

		list1.add("Azam");
		list1.add("faiz");

		// method 1 to print list
		System.out.println(list1);

		// method 2 for printing list -using forEach loop
		list1.forEach(e -> System.out.println(e));

		// method-3 using enhanced for loop:
		for (String element : myList1) {
			System.out.print(element + " ");
		}

		// method 4 - using iterator:
		Iterator<String> it = myList1.iterator();
		System.out.println(it.next());

		// method 5 - using stream with forEach
		myList1.stream().forEach(System.out::println);

		// method 6 - to print list using stream with arrow function
		myList1.stream().forEach(element -> System.out.println(element));

		// method 7 - using tradition for loop:
		for (int i = 0; i < myList1.size(); i++) {
			System.out.print(myList1.get(i) + " ");
		}

	} }
