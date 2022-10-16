package net.archasmiel.homework.collections.hashmap;

public interface HashMap<A, B> {

	void put(A key, B value);
	void remove(A key);
	void clear();
	int size();
	B get(A key);

}
