package net.archasmiel.homework.collections.models;

public class Entity<A, B> {

	private final int hash;
	private A key;
	private B value;

	public Entity(A key, B value) {
		this.key = key;
		this.value = value;
		this.hash = key.hashCode();
	}

	public int getHash() {
		return hash;
	}

	public void setKey(A key) {
		this.key = key;
	}

	public void setValue(B value) {
		this.value = value;
	}

	public A getKey() {
		return key;
	}

	public B getValue() {
		return value;
	}

}
