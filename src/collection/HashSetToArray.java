package collection;

import java.util.HashSet;

public class HashSetToArray {
	
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("Doctor");
		hashSet.add("Engineer");
		hashSet.add("Plumber");
		hashSet.add("Doctor");
		hashSet.add("Developer");
		System.out.println(hashSet);
		
		String[] arrStr = new String[hashSet.size()];
		hashSet.toArray(arrStr);
		for (String s : arrStr) {
			System.out.println(s);
		}


	}

}
