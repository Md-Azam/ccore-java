package stringsOp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Parses input "HAB:234;HAB:345;HAC:323;HA5:678;" into
 * { HAB: [234, 345], HAC: [323], HA5: [678] }
 *
 * EXPLANATION (without streams):
 * - Input format: "KEY:value;KEY:value;..." (pairs separated by ;  key and value by :)
 * - Goal: Group all values by their key → Map<Key, List<values>>
 * - Without streams we: split by ";", loop over each pair, split by ":", then add value to the list for that key.
 */
public class KeyValueGrouping {

	public static void main(String[] args) {
		String input = "HAB:234;HAB:345;HAC:323;HA5:678;HB4:678;HB4:889";

		// WITHOUT STREAMS (simple loop + get/put)
		Map<String, List<String>> result0 = groupByKeyWithoutStreams(input);
		System.out.println("Without streams (get/put): " + result0);

		// WITHOUT STREAMS (using computeIfAbsent - shorter)
		Map<String, List<String>> result1 = groupByKeyImperative(input);
		System.out.println("Without streams (computeIfAbsent): " + result1);

		// WITH STREAMS
		Map<String, List<String>> result2 = groupByKeyStreams(input);
		System.out.println("With streams: " + result2);
	}

	// ========== WITHOUT STREAMS – detailed step-by-step ==========

	/**
	 * Pure imperative: no streams, no computeIfAbsent. Uses only loop, split, get, put.
	 * Step-by-step:
	 * 1) Split input by ";" → ["HAB:234", "HAB:345", "HAC:323", "HA5:678", ""]
	 * 2) For each piece, find ":" to get key and value.
	 * 3) If key is new → create a new ArrayList, put in map. If key exists → get that list.
	 * 4) Add the value to that list.
	 */
	public static Map<String, List<String>> groupByKeyWithoutStreams(String input) {
		// Map: key (e.g. "HAB") -> list of values (e.g. ["234", "345"])
		Map<String, List<String>> map = new HashMap<>();

		if (input == null || input.isBlank()) {
			return map;
		}

		// Step 1: Split by semicolon so we get each "KEY:value" as one string
		// "HAB:234;HAB:345;HAC:323;HA5:678;" → ["HAB:234", "HAB:345", "HAC:323", "HA5:678", ""]
		String[] pairs = input.split(";");

		for (String pair : pairs) {
			pair = pair.trim();
			if (pair.isEmpty())
				continue;  // skip empty (e.g. after last ";")

			// Step 2: Find where ":" is to separate key from value
			int colonIndex = pair.indexOf(':');
			if (colonIndex == -1)
				continue;  // no colon, invalid pair

			String key   = pair.substring(0, colonIndex).trim();   // e.g. "HAB"
			String value = pair.substring(colonIndex + 1).trim();   // e.g. "234"
			if (key.isEmpty() || value.isEmpty())
				continue;

			// Step 3: Get the list for this key (or create if first time)
			List<String> list = map.get(key);
			if (list == null) {
				list = new ArrayList<>();
				map.put(key, list);
			}
			// Step 4: Add this value to the list
			list.add(value);
		}
		return map;
	}

	/**
	 * Same logic as above, but using computeIfAbsent so we don't write get/if-null/put.
	 * computeIfAbsent(key, k -> new ArrayList<>()) means:
	 * "If key is not in map, put key -> new ArrayList<>(); then return the list for key."
	 * Then we just .add(value) to that list.
	 */
	public static Map<String, List<String>> groupByKeyImperative(String input) {
		Map<String, List<String>> map = new HashMap<>();
		if (input == null || input.isBlank()) {
			return map;
		}
		String[] pairs = input.split(";");
		for (String pair : pairs) {
			pair = pair.trim();
			if (pair.isEmpty()) continue;
			int colonIndex = pair.indexOf(':');
			if (colonIndex == -1) continue;
			String key = pair.substring(0, colonIndex).trim();
			String value = pair.substring(colonIndex + 1).trim();
			if (key.isEmpty() || value.isEmpty()) continue;
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
		}
		return map;
	}

	// ========== WITH STREAMS (for comparison) ==========

	/**
	 * Streams: split by ";", trim, filter empty, map each to [key, value], then
	 * groupingBy(key, mapping to list of values).
	 */
	public static Map<String, List<String>> groupByKeyStreams(String input) {
		if (input == null || input.isBlank()) {
			return new HashMap<>();
		}
		return Arrays.stream(input.split(";"))
				.map(String::trim)
				.filter(s -> !s.isEmpty())
				.map(s -> {
					int i = s.indexOf(':');
					return i == -1 ? null : new String[] { s.substring(0, i).trim(), s.substring(i + 1).trim() };
				})
				.filter(arr -> arr != null && !arr[0].isEmpty() && !arr[1].isEmpty())
				.collect(Collectors.groupingBy(
						arr -> arr[0],
						Collectors.mapping(arr -> arr[1], Collectors.toList())));
	}
}
