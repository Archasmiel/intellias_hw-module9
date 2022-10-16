package net.archasmiel.homework.collections.list;

import net.archasmiel.homework.collections.models.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements List<E> {

	private Node<E> firstNode;
	private Node<E> lastNode;
	int size;

	public MyLinkedList() {
		clear();
	}

	private void init(Node<E> node) {
		firstNode = node;
		lastNode = firstNode;
		size = 1;
	}

	@Override
	public void add(E value) {
		Node<E> node = new Node<>(value);
		if (size <= 0) {
			init(node);
		} else {
			lastNode.connect(node);
			lastNode = node;
			size++;
		}
	}

	@Override
	public E remove(int index) {
		if (size == 0 || index >= size || index < 0) {
			return null;
		}

		if (index == 0) {
			E res = firstNode.getData();
			firstNode = firstNode.getNext();
			size--;
			return res;
		}
		if (index == size-1) {
			E res = lastNode.getData();
			lastNode = lastNode.getPrevious();
			size--;
			return res;
		}

		int i = 0;
		E data = firstNode.getData();
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			if (i == index) {
				iterator.remove();
				return data;
			}
			data = iterator.next();
			i++;
		}

		return null;
	}

	@Override
	public E get(int index) {
		if (size <= 0 || index >= size || index < 0) {
			return null;
		}

		if (index == 0) {
			return firstNode.getData();
		} else
		if (index == size-1)  {
			return lastNode.getData();
		}

		int i = 0;
		E data = firstNode.getData();
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			if (i == index) {
				return data;
			}
			data = iterator.next();
			i++;
		}

		return null;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	public Iterator<E> iterator() {
		return new Iterator<>() {

			private final MyLinkedList<E> list = MyLinkedList.this;
			private Node<E> current = list.firstNode;

			@Override
			public boolean hasNext() {
				return current != null && !current.equals(list.lastNode);
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				current = current.getNext();
				return current.getData();
			}

			@Override
			public void remove() {
				Node<E> node1 = current.getPrevious();
				Node<E> node2 = current.getNext();

				if (node1 != null && node2 != null) {
					node1.connect(node2);
				} else
				if (node1 != null) {
					list.lastNode = node1.setNext(null);
				} else
				if (node2 != null) {
					list.firstNode = node2.setPrevious(null);
				}

				list.size--;
			}

		};
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("MyLinkedList{");
		if (firstNode != null) builder.append(firstNode.getData()).append(", ");

		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			builder.append(iterator.next()).append(", ");
		}
		if (size != 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		return builder.append("}").toString();
	}
}
