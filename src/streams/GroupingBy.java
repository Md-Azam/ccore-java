package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {

		/*
		 * 1.groupingBy(function) 2.groupingBy(function,collector)
		 * 3.groupingBy(function,supplier,collector)
		 */

		Student student1 = new Student(1, 18, "John", 101, new int[] { 90, 85, 92 });
		Student student2 = new Student(2, 20, "Alice", 102, new int[] { 88, 76, 95 });
		Student student3 = new Student(3, 19, "Bob", 103, new int[] { 75, 82, 89 });
		Student student4 = new Student(4, 21, "Emma", 104, new int[] { 94, 87, 91 });
		Student student5 = new Student(5, 18, "Sam", 105, new int[] { 85, 90, 88 });
		Student student6 = new Student(6, 20, "Sophia", 106, new int[] { 78, 93, 85 });
		Student student7 = new Student(7, 19, "Charlie", 107, new int[] { 92, 84, 87 });
		Student student8 = new Student(8, 21, "Olivia", 108, new int[] { 89, 91, 83 });
		Student student9 = new Student(9, 18, "Daniel", 109, new int[] { 80, 88, 90 });
		Student student10 = new Student(10, 20, "Grace", 110, new int[] { 87, 92, 79 });

		List<Student> allStudent = new ArrayList<>();
		allStudent.add(student2);
		allStudent.add(student3);
		allStudent.add(student4);
		allStudent.add(student5);
		allStudent.add(student6);
		allStudent.add(student7);
		allStudent.add(student8);
		allStudent.add(student9);
		allStudent.add(student10);

//	        Map<Integer,List<Student>> groupByAge = allStudent.stream().collect(Collectors.groupingBy(student -> student.getAge()));
//	   System.out.println("group Of Student by Age is: \n"+groupByAge );

		// 2. groupingBy(function,collector)
		Map<Integer, Set<Student>> set = allStudent.stream()
				.collect(Collectors.groupingBy(student -> student.getAge(), Collectors.toSet()));

		System.out.println(set);

		Map<Integer, List<String>> set1 = allStudent.stream().collect(Collectors.groupingBy(student -> student.getAge(),
				Collectors.mapping(Student::getName, Collectors.toList())));

		System.out.println(set1);

		// 3.groupingBy(function,supplier,collector)
	}

}
