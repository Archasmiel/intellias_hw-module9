package net.archasmiel.homework.collections.stack;

public interface Stack<E> {

	void push(E value);
	E remove(int index);
	void clear();
	int size();
	E peek();
	E pop();

}
