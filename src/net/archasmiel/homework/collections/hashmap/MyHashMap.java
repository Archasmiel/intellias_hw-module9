package net.archasmiel.homework.collections.hashmap;

public class MyHashMap<A, B> implements HashMap<A, B> {

	private HashMapNode<A, B> node;
	private int size;

	public MyHashMap() {
		clear();
	}

	@Override
	public void put(A key, B value) {
		HashMapNode<A, B> put = new HashMapNode<>(key, value);
		if (node == null) {
			node = put;
			size = 1;
			return;
		}

		HashMapNode<A, B> temp = node;
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				temp.setValue(value);
				return;
			}
			temp = temp.getConnect();
		}

		node = put.setConnect(node);
		size++;
	}

	@Override
	public void remove(A key) {
		HashMapNode<A, B> before = null;
		HashMapNode<A, B> current = node;
		while (current != null) {
			if (current.getKey().equals(key)) {
				if (before == null) {
					node = node.getConnect() == null ? null : node.getConnect();
				} else {
					before.setConnect(current.getConnect());
				}
				size--;
				return;
			}
			before = before == null ? current : before.getConnect();
			current = current.getConnect();
		}
	}

	@Override
	public void clear() {
		node = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public B get(A key) {
		HashMapNode<A, B> temp = node;
		while (temp != null) {
			if (temp.getKey() == key) {
				return temp.getValue();
			}
			temp = temp.getConnect();
		}

		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("MyStack{");

		HashMapNode<A, B> temp = node;
		while (temp != null) {
			builder.append("[").append(temp.getKey())
				.append(",")
				.append(temp.getValue()).append("]")
				.append(", ");
			temp = temp.getConnect();
		}

		if (size() != 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		return builder.append("}").toString();
	}

}
