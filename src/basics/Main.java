package basics;

import java.util.*;
class Main {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("azam", "car", "act", "maza", "silent", "listen");
		Map<String, List<String>> map = new HashMap<>();
		for (String s : list) {
			char[] carray = s.toCharArray();
			Arrays.sort(carray);
			String sch = new String(carray);
			map.computeIfAbsent(sch, val -> new ArrayList<>()).add(s);
		}
		System.out.println(map);
	}
}