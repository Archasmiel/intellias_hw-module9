package net.archasmiel.homework.collections;


public interface MyList<E> {

	void add(E value);

	E remove(int index);

	E get(int index);

	void clear();

	int size();

}
