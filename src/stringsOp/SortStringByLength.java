package stringsOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStringByLength {

	public static void main(String[] args) {
		List<String> s = Arrays.asList("azam", "Sumaiyya", "zafar", "kashmir");
		s.stream().sorted(Comparator.comparing(String::length)).forEach(System.out:: println);
		
		
	}
}
