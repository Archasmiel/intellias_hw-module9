package net.archasmiel.homework.collections.list;

import java.util.Arrays;

public class MyArrayList<E> implements List<E> {

	private Object[] array;

	public MyArrayList() {
		array = new Object[0];
	}

	@Override
	public void add(E value) {
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
	public E get(int index) {
		if (index >= array.length) {
			return null;
		}

		return (E) array[index];
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
	public String toString() {
		StringBuilder builder = new StringBuilder("MyArrayList{");
		for (Object o: array) {
			builder.append(o).append(", ");
		}
		if (size() != 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		return builder.append("}").toString();
	}
}
