package net.archasmiel.homework.collections.list;

public class MyArrayList<E> implements List<E> {

	private int expSize;
	private int size;
	private Object[] array;

	public MyArrayList() {
		expSize = 10;
		array = new Object[expSize];
		size = 0;
	}

	@Override
	public void add(E value) {
		int newSize = size+1;
		if (expSize <= newSize) {
			addSize();
		}

		array[newSize-1] = value;
		size++;
	}

	private void addSize() {
		expSize *= 2;
		Object[] newArr = new Object[expSize];
		System.arraycopy(array, 0, newArr, 0, size);
		array = newArr;
	}

	@Override
	public E remove(int index) {
		int newSize = size-1;
		if (size == 0 || index < 0 || index >= size) {
			return null;
		}

		Object removed = array[index];
		if (index < newSize) {
			System.arraycopy(array, index+1, array, index, newSize-index);
		}
		size--;
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
		expSize = 10;
		array = new Object[expSize];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("MyArrayList{");
		for (int i = 0 ; i < size ; i++) {
			builder.append(array[i]).append(", ");
		}
		if (size() != 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		return builder.append("}").toString();
	}
}
