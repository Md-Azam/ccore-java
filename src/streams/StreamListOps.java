package streams;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.IntStream;
public class StreamListOps {

	public static void main(String args[]) {

		List<Integer> list = Arrays.asList(2, 2, 3, 3, 4, 5, 6, 7, 8, 9);

		// Sort array in natural order - Return List<integer>
		System.out.println(list.stream().sorted().collect(Collectors.toList()));

		// Print only distinct element - Return List<integer>
		System.out.println(list.stream().distinct().toList());

		// Print only even number from list - Return List<integer>
		System.out.println(list.stream().filter(n -> n % 2 == 0).toList());

		// Print only even numbers square from list - Return List<integer>
		System.out.println(list.stream().filter(n -> n % 2 == 0).map(sq -> sq * sq).collect(Collectors.toSet()));

		// Print square of numbers using stream -Return List<integer>
		System.out.println(list.stream().map(n -> n * n).collect(Collectors.toList()));

		// Sum of all elements in array: Return int
		System.out.println(list.stream().mapToInt(Integer::intValue).sum());

		// counting each element - Returns Map<Int, Int>
		System.out.println(
				list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1))));

		// Find Second highest number - Return Integer
		System.out.println(list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null));

		// Sort in Reverse order - Returns List<Integer>
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());

		// Max and Min in array - Returns Integer
		System.out.println(list.stream().max(Integer::compare).get());
		System.out.println(list.stream().min(Integer::compare).get());

		// find duplicates - returns List<Integer>
		System.out.println(list.stream().filter(e -> Collections.frequency(list, e) > 1).distinct().toList());

	}

}
