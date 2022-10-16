package net.archasmiel.homework;

import net.archasmiel.homework.collections.hashmap.HashMap;
import net.archasmiel.homework.collections.hashmap.MyHashMap;
import net.archasmiel.homework.collections.list.MyArrayList;
import net.archasmiel.homework.collections.list.MyLinkedList;
import net.archasmiel.homework.collections.list.List;
import net.archasmiel.homework.collections.queue.MyQueue;
import net.archasmiel.homework.collections.queue.Queue;
import net.archasmiel.homework.collections.stack.MyStack;
import net.archasmiel.homework.collections.stack.Stack;

public class Main {

	public static void main(String[] args) {
		testQueue();
	}

	private static void testArrayList() {
		List<String> list = new MyArrayList<>();
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
		List<String> list = new MyLinkedList<>();
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

	private static void testQueue() {
		Queue<String> queue = new MyQueue<>();
		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");
		queue.add("5");

		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println();

		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");
		queue.add("5");
		System.out.println(queue);
		System.out.println(queue.size());
		queue.clear();
		System.out.println(queue);
		System.out.println(queue.size());
	}

	private static void testStack() {

	}

	private static void testHashMap() {

	}

}
