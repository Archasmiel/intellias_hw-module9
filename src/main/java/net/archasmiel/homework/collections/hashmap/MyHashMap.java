package net.archasmiel.homework.collections.hashmap;

import java.util.NoSuchElementException;
import net.archasmiel.homework.collections.list.MyArrayList;
import net.archasmiel.homework.collections.list.MyLinkedList;
import net.archasmiel.homework.collections.models.Entity;

public class MyHashMap<A, B> implements HashMap<A, B> {

	private int bucketSize;
	private MyArrayList< MyLinkedList<Entity<A, B>>> bucket;
	private int size;

	public MyHashMap() {
		clear();
	}

	private void resizeMap() {
		int newBucketSize = bucketSize*2;
		MyArrayList< MyLinkedList< Entity<A, B>>> newBucket = new MyArrayList<>();
		for (int i = 0 ; i < newBucketSize ; i++) {
			newBucket.add(new MyLinkedList<>());
		}

		int hash;
		for (int i = 0 ; i < bucketSize ; i++) {
			for (int j = 0 ; j < bucket.size() ; j++) {
				hash = bucket.get(i).get(j).getKey().hashCode();
				newBucket.get(hash % newBucketSize).add(bucket.get(i).get(j));
			}
		}
		bucketSize = newBucketSize;
		bucket = newBucket;
	}

	@Override
	public void put(A key, B value) {
		Entity<A, B> entity = null;
		int hash = key.hashCode();
		if (size >= bucketSize*5) {
			resizeMap();
		}

		MyLinkedList< Entity<A, B>> currBucket = bucket.get(hash % bucketSize);
		for (int i = 0 ; i < currBucket.size() ; i++) {
			if (currBucket.get(i).getHash() == hash) {
				entity = currBucket.get(i);
				break;
			}
		}



		if (entity == null) {
			currBucket.add(new Entity<>(key, value));
			size++;
		} else {
			entity.setValue(value);
		}
	}

	@Override
	public void remove(A key) {
		int index = -1;
		int hash = key.hashCode();

		MyLinkedList< Entity<A, B>> currBucket = bucket.get(hash % bucketSize);
		for (int i = 0 ; i < currBucket.size() ; i++) {
			if (currBucket.get(i).getHash() == hash) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			throw new NoSuchElementException();
		} else {
			currBucket.remove(index);
			size--;
		}
	}

	@Override
	public void clear() {
		bucketSize = 16;
		bucket = new MyArrayList<>();
		for (int i = 0 ; i < bucketSize ; i++) {
			bucket.add(new MyLinkedList<>());
		}
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public B get(A key) {
		B resValue = null;
		int hash = key.hashCode();

		MyLinkedList< Entity<A, B>> currBucket = bucket.get(hash % bucketSize);
		for (int i = 0 ; i < currBucket.size() ; i++) {
			if (currBucket.get(i).getHash() == hash) {
				resValue = currBucket.get(i).getValue();
				break;
			}
		}

		return resValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("MyStack{");

		for (int i = 0 ; i < bucket.size() ; i++) {
			for (int j = 0 ; j < bucket.get(i).size(); j++) {
				builder.append("[").append(bucket.get(i).get(j).getKey())
						.append(",")
						.append(bucket.get(i).get(j).getValue()).append("]")
						.append(", ");
			}
		}

		if (size() > 0) {
			builder.delete(builder.length()-2, builder.length());
		}
		return builder.append("}").toString();
	}

}
