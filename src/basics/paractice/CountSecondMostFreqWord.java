package basics.paractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountSecondMostFreqWord {
public static void main(String[] args) {
	
	List<String> words = Arrays.asList("Apple","Banana","Azam","Silpa","Apple","Sar","Banana","Apple","Azam");
	Map<String,Long> map = words.stream().collect(Collectors.groupingBy(
			Function.identity(),Collectors.counting()
			));
	System.out.println(map);
	Optional<Entry<String, Long>> findSecondFreqWord = map.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).skip(1).findFirst();
	System.out.println(findSecondFreqWord);
}
}
