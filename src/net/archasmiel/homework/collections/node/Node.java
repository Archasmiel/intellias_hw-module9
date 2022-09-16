package net.archasmiel.homework.collections.node;

public interface Node<E> {

	E getData();

	Node<E> getPrevious();

	Node<E> setPrevious(Node<E> previous);

	Node<E> getNext();

	Node<E> setNext(Node<E> next);

}
