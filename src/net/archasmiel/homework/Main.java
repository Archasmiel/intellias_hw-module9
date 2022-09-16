package net.archasmiel.homework;

import net.archasmiel.homework.collections.MyArrayList;
import net.archasmiel.homework.collections.MyLinkedList;
import net.archasmiel.homework.collections.MyList;

public class Main {

	public static void main(String[] args) {
		testArrayList();
	}

	private static void testArrayList() {
		MyList<String> list = new MyArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		System.out.println(list);
		list.remove(5);
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		System.out.println();

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
		System.out.println();

		list.clear();
		System.out.println(list);
	}

	private static void testLinkedList() {
		MyList<String> list = new MyLinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		System.out.println(list);
		System.out.println(list.remove(2));
		System.out.println(list);
		System.out.println(list.remove(2));
		System.out.println(list.remove(11));
		System.out.println(list);
		System.out.println();

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(11));
		System.out.println();

		list.clear();
		System.out.println(list);
	}


}
