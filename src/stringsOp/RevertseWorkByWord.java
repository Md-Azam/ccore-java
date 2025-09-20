package stringsOp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RevertseWorkByWord {

	public static void main(String[] args) {
		String s = " apple , banana , orange , grapes ";
		List<String> list = Arrays.stream(s.split(",")).map(String::trim).collect(Collectors.toList());
		System.out.println(list);
		String splitedString = Arrays.stream(s.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining());
		System.out.println(splitedString);
	}

}
