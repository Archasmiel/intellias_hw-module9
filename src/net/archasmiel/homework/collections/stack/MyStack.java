package net.archasmiel.homework.collections.stack;

import net.archasmiel.homework.collections.queue.Queue;

import java.util.Arrays;

public class MyStack<E> implements Stack<E> {

	private Object[] array;

	public MyStack() {
		array = new Object[0];
	}

	public MyStack(E value) {
		array = new Object[]{value};
	}

	public MyStack(E... values) {
		array = values;
	}

	@Override
	public void push(E value) {
		int newSize = array.length+1;
		array = Arrays.copyOf(array, newSize);
		array[newSize-1] = value;
	}

	@Override
	public E remove(int index) {
		int newSize = array.length - 1;
		if (newSize < 0 || index > newSize) {
			return null;
		}

		Object removed = array[index];
		Object[] newArray = new Object[newSize];
		if (index > 0) {
			System.arraycopy(array, 0, newArray, 0, index);
		}
		if (index < newSize) {
			System.arraycopy(array, index+1, newArray, index, newSize-index);
		}
		array = newArray;
		return (E) removed;
	}

	@Override
	public void clear() {
		array = new Object[0];
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public E peek() {
		E res = null;
		if (size() > 0) {
			res = (E) array[size()-1];
		}
		return res;
	}

	@Override
	public E pop() {
		E res = null;
		if (size() > 0) {
			res = (E) array[size()-1];
			remove(size()-1);
		}
		return res;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("MyStack{");
		for (Object o: array) {
			builder.append(o).append(", ");
		}
		if (size() != 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		return builder.append("}").toString();
	}
}
