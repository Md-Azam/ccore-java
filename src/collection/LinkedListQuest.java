package collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListQuest {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(6);
		list.add(56);
		System.out.println(list);
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(6);
		linkedList.add(56);
		System.out.println(linkedList.getLast());
		System.out.println(linkedList);
	}

}
