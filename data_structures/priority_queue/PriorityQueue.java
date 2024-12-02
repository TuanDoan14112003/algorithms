// A priority queue is a data structure for maintaining a set S of elements, each with an associated value called a key. A max-priority queue supports the following operations: 
// 		- Insert(S, x, k) inserts the element x with the key k into the set S, which is equivalent to the operation S = S U {x}
// 		- Maximum(S) returns the element of S with the largest key.
// 		- Extract-Max(S) removes and returns the element of S with the largest key.
// 		- Increase-Key(S,x,k) increases the value of element x's key to the new value k, which is assumed to be at least as large as x's current key value

package data_structures.priority_queue;

import data_structures.heap.Heap;
import data_structures.heap.HeapNode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
	public Heap<T> heap;

	public PriorityQueue(List<T> list) {
		this.heap = new Heap<T>(list);
	} 

	public T at(int index) {
		return this.heap.at(index).getKey();
	}

	public int size() {
		return this.heap.getHeapSize();
	}

	@Override
	public String toString() {
		return this.heap.toString();
	}

	public static <T extends Comparable<T>> T maxHeapMaximum(PriorityQueue<T> priorityQueue) {
		// Description: This maxHeapMaximum procedure return the element with the largest key in the heap:
		// Runtime: The procedure runs in Theta(1) time

		if (priorityQueue.heap.getHeapSize() < 1) throw new RuntimeException("Heap underflow");
		return priorityQueue.heap.at(0).getKey();
	}

	public static <T extends Comparable<T>> T maxHeapExtractMax(PriorityQueue<T> priorityQueue) {
		// Description: This maxHeapExtractMax operation removes and returns the element with the largest key in the list
		// Runtime: This operation runs in O(lgn)

		T max = maxHeapMaximum(priorityQueue);
		Heap.swap(priorityQueue.heap, 0, priorityQueue.heap.getHeapSize() - 1);
		priorityQueue.heap.changeHeapSize(-1);
		Heap.maxHeapify(priorityQueue.heap, 0);
		return max;
	}

	public static <T extends Comparable<T>> void maxHeapIncreaseKey(PriorityQueue<T> priorityQueue, int index, T newKey) {
		// Description: maxHeapIncreaseKey will increase an node's key which is assumed to be at least as large as the current key
		// Runtime: This operation runs in O(lgn)
		HeapNode<T> heapNode = priorityQueue.heap.at(index); 	
		if (newKey.compareTo(heapNode.getKey()) < 0) throw new RuntimeException("New key is smaller than current key");
		heapNode.setKey(newKey);
		while (index > 0 && priorityQueue.at((index - 1) / 2).compareTo(priorityQueue.at(index)) < 0) {
			Heap.swap(priorityQueue.heap, index, (index - 1) /2);
			index = (index - 1) / 2;
		}
	}

	public static <T extends Comparable<T>> void maxHeapInsert(PriorityQueue<T> priorityQueue, T newKey) {
		// Description: The operation insert a new node into the priority queue.
		// Runtime: It runs in O(lgn) time

		// if the object representing the heap has limited size (e.g. array), we should do a check here 
		// to see if it is possible to insert another element to the array
		priorityQueue.heap.add(newKey); // this will also increase the heapSize
		maxHeapIncreaseKey(priorityQueue, priorityQueue.heap.getHeapSize() - 1, newKey);
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new ArrayList<>(Arrays.asList(15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1)));
		PriorityQueue.maxHeapInsert(priorityQueue, 10);
		System.out.println(priorityQueue);
		int size = priorityQueue.size();
		for (int i = 0; i < size; i++) {
			System.out.println(maxHeapExtractMax(priorityQueue));
		}
	}
}
