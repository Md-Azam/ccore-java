package stringsOp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DelloiteeQuestion {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(-1, 2, 2, 3, 4, 4, 4);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				System.out.println(list.get(i));
				map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
			}
		}

//		
		System.out.println(map);
	}

}
