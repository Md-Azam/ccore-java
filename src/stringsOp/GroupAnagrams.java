package stringsOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public static void main(String args[]) {
		/*
		 * 1.Take a ArrayList of String, and Map<String, List<String>> 2.Loop over list
		 * of String, and convert each String to toCharArray() 3.Sort charArray 4.Assign
		 * each character as a key, and value will be ArrayList().add(each string of
		 * loop) 5.use computeifAbsent(key, k -> new ArrayList<.()).add(s)
		 */
		
		Map<String, List<String>> map = new HashMap<>();
		List<String> input = Arrays.asList("azam", "maza", "act", "cat");
		for (String s : input) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);
			map.computeIfAbsent(key, k -> new ArrayList()).add(s);
		}
		System.out.println("map: "+ map);
		List<List<String>> listChar = new ArrayList<>(map.values());
		System.out.println("listChar: "+ listChar);
	}
}
