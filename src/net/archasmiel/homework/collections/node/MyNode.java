package net.archasmiel.homework.collections.node;

public class MyNode<E> implements Node<E> {

	private final E data;
	private Node<E> previous;
	private Node<E> next;

	public MyNode(E content) {
		this.data = content;
	}

	public E getData() {
		return data;
	}

	public Node<E> getPrevious() {
		return previous;
	}

	public Node<E> setPrevious(Node<E> previous) {
		this.previous = previous;
		return this;
	}

	public Node<E> getNext() {
		return next;
	}

	public Node<E> setNext(Node<E> next) {
		this.next = next;
		return this;
	}
}
