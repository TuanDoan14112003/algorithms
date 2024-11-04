// Description: The procedure maxHeapify maintains the max-heap property. Its input are an array, an integer specifying
// the heap size and an index. When it is called, maxHeapify assumes that the binary trees rooted at left and right
// children are max-heaps but that the index node might be smaller than its children. During the procedure, maxHeapify 
// lets the index value float down in the max-heap so that the subtree rooted at index obeys the max heap property.

// Running time: Let T(n) be the running time of maxHeapify procedure, we have:
// T(n) <= T(2n/3) + Theta(1)
// Therefore, T(n) = O(lg(n)) = O(h)
// where h is the height of the heap

package data_structures.heap;

import java.util.Arrays;

public class MaxHeapify {
	public static void main(String[] args) {
		int[] list = new int[] {16,4,10,14,7,9,3,2,8,1};
		maxHeapify(list, list.length, 1);
		System.out.println(Arrays.toString(list));
	}

	public static void maxHeapify(int[] list, int heapSize, int index) {
		int largest = index;
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;

		if (leftChild < heapSize && list[leftChild] > list[index]) {
			largest = leftChild;
		}
		if (rightChild < heapSize && list[rightChild] > list[largest]) {
			largest = rightChild;
		}

		// swapping list[index] and list[largest]
		if (largest != index) {
			int temp = list[index];
			list[index] = list[largest];
			list[largest] = temp;
			maxHeapify(list, heapSize, largest);
		}
	} 
}
