package net.archasmiel.homework.collections.list;


public interface List<E> {

	void add(E value);
	E remove(int index);
	E get(int index);
	void clear();
	int size();

}
