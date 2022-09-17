package net.archasmiel.homework.collections.hashmap;

public class HashMapNode<A, B> {

	private A key;
	private B value;
	private HashMapNode<A, B> connect;

	public HashMapNode(A key, B value) {
		this.key = key;
		this.value = value;
		connect = null;
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

	public HashMapNode<A, B> getConnect() {
		return connect;
	}

	public HashMapNode<A, B> setConnect(HashMapNode<A, B> connect) {
		this.connect = connect;
		return this;
	}
}
