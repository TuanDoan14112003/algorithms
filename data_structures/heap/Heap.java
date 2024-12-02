package data_structures.heap;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Heap<T extends Comparable<T>> {
	
	private List<HeapNode<T>> list;
	
	private int heapSize;
	
	public Heap(List<T> list) {
		List<HeapNode<T>> heapNodes = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			heapNodes.add(new HeapNode<T>(list.get(i),i));
		}
		this.list = heapNodes;
		this.heapSize = list.size();
	}

	public HeapNode<T> at(int index) {
		return this.list.get(index);
	}
	
	public void set(int index, T value) {
		HeapNode<T> heapNode = new HeapNode<T>(value, index);
		this.list.set(index, heapNode);
	}

	public void add(T value) {
		HeapNode<T> newHeapNode = new HeapNode<T>(value, getHeapSize());
		this.list.add(newHeapNode);
		changeHeapSize(1);
	}

	public void changeHeapSize(int difference) {
		this.heapSize += difference;
	}

	public int getHeapSize() {
		return this.heapSize;
	}	

	public String toString() {
		return this.list.toString();
	}

	public static <T extends Comparable<T>> void swap(Heap<T> heap, int firstIndex, int secondIndex) {	
		T temp = heap.at(firstIndex).getKey();
		heap.set(firstIndex, heap.at(secondIndex).getKey());
		heap.set(secondIndex, temp);
	}

	public static void main(String[] args) {
		// test maxheapify
		Heap<Integer> heap = new Heap<Integer>(Arrays.asList(16, 4, 10, 14, 7, 9, 3, 2, 8, 1));
		Heap.maxHeapify(heap, 1);
		System.out.println(heap.toString());


		// test build max heap
		List<Integer> list = Arrays.asList(16, 4, 10, 14, 7, 9, 3, 2, 8, 1);
		Heap.<Integer>buildMaxHeap(list);
		System.out.println(heap.toString());

		// test heap sort
		list = Arrays.asList(4, 2, 7, 12, 23, 8, 3, 0, 11, 43, 2);
		List<Integer> result = Heap.<Integer>heapSort(list);
		System.out.println(result);
	}  
 
	public static <T extends Comparable<T>> void maxHeapify(Heap<T> heap, int index) {
		
		// Description: The procedure maxHeapify maintains the max-heap property. 
		// Its input are a heap and an index. When it is called, maxHeapify assumes 
		// that the binary trees rooted at left and right children are max-heaps but 
		// that the index node might be smaller than its children. During the procedure, 
		// maxHeapify lets the index value float down in the max-heap so that the subtree
		// rooted at index obeys the max heap property.

		// Running time: Let T(n) be the running time of maxHeapify procedure, we have:
		// T(n) <= T(2n/3) + Theta(1)
		// Therefore, T(n) = O(lg(n)) = O(h)
		// where h is the height of the heap
		
		int largest = index;
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;

		if (leftChild < heap.getHeapSize() && heap.at(leftChild).compareTo(heap.at(index)) > 0) {
			largest = leftChild;
		}

		if (rightChild < heap.getHeapSize() && heap.at(rightChild).compareTo(heap.at(largest)) > 0) {
			largest = rightChild;
		}

		// swapping heap[index] and heap[largest]
		if (largest != index) {
			swap(heap, index, largest);
			maxHeapify(heap, largest);
		}
	}

	public static <T extends Comparable<T>> Heap<T> buildMaxHeap(List<T> list) {
		
		// Description: The algorithm BuildMaxHeap converts an array into a 
		// max-heap by calling MaxHeapify in a bottom-up manner
		
		// Running time: Let T(n) be the running time of BuildMaxHeap procedure, we have
		// T(n) = O(n)
		// Hence, we can build a max-heap from an unordered array in linear time.
		int heapSize = list.size();
		Heap<T> maxHeap = new Heap<>(list);
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			Heap.maxHeapify(maxHeap, i);
		}

		return maxHeap;
	}

	public static <T extends Comparable<T>> List<T> heapSort(List<T> list) {

		// The HeapSort algorithm starts by calling the BuildMaxHeap procedure to build a max-heap 
		// on the input array. Since the maximum element of the array is stored at the root A[0]. 
		// HeapSort can place it into its correct final position by exchanging it with A[size-1]. 
		// Because the new root might violate the max-heap property, we will have to call 
		// MaxHeapify to restore the property. The procedure repeats this process downto 
		// a heap size of 2 where it terminates

		// Running time: 
		// Let T(n) be the worst case running time of HeapSort
		// T(n) = O(nlgn)
		// Since BuildMaxHeap takes O(n) time and each of the size-1 calls to MaxHeapify takes O(lgn) time.

		int heapSize = list.size();
		Heap<T> maxHeap = Heap.<T>buildMaxHeap(list);
		for (int i = heapSize - 1; i >= 1; i--) {
			Heap.swap(maxHeap, 0, i);
			maxHeap.changeHeapSize(-1);
			Heap.<T>maxHeapify(maxHeap, 0);
		}
		
		return maxHeap.list.stream().map(node -> node.getKey()).collect(Collectors.toList());
	}
}
