package net.archasmiel.homework.collections.queue;

public interface Queue<E> {

	void add(E value);
	E remove(int index);
	void clear();
	int size();
	E peek();
	E poll();

}
