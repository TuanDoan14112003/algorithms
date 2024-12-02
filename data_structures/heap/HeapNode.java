package data_structures.heap;

public class HeapNode<T extends Comparable<T>> implements Comparable<HeapNode<T>> {
	
	private Integer index;
	
	private T key;

	public HeapNode(T key, Integer index) {
		this.index = index;
		this.key = key;
	}
	
	public int getIndex() {
		return this.index;
	}

	public void setIndex(int newIndex) {
		this.index = newIndex;
	}

	public T getKey() {
		return this.key;
	}

	public void setKey(T newKey) {
		this.key = newKey;
	}

	public int compareTo(HeapNode<T> other) {
		return key.compareTo(other.key);
	}

	public String toString() {
		return key.toString() + " at " + index.toString();
	}	
}

