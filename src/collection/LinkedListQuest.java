package collection;

import java.util.ArrayList;
import java.util.Iterator;
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
		linkedList.addLast(23);
		System.out.println(linkedList);
		Iterator it = linkedList.iterator();
		System.out.println(it.toString());

		/*
		 * 1. Use This Frequent random access (index-based) ArrayList 
		 * 2. Frequent insertions/deletions in middle/start LinkedList
		 * 3. Memory efficiency is important ArrayList 
		 * 4. You need queue/deque operations LinkedList
		 */
	}

}
