package basics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LTMStringGrouping {
	public static void main(String[] args) {
		String input = "HA1:234;HA2:456;HA1:456;HG4:678";
		//output = 
		Map<String, List<String>> map = new HashMap<>();
		String[] part1 = input.split(";");
		System.out.println("part1: "+ Arrays.toString(part1));
		for (String s: part1) {
			String[] part2 = s.split(":");
			String key = part2[0];
			String value = part2[1];
			map.computeIfAbsent(key, v -> new ArrayList<>()).add(value);
			
		}
		System.out.println("hospital code with Patient: "+ map);
		
		}

}
