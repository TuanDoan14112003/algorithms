// The HeapSort algorithm starts by calling the BuildMaxHeap procedure to build a max-heap on the input array. Since the maximum element of the array
// is stored at the root A[0]. HeapSort can place it into its correct final position by exchanging it with A[size-1]. Because the new root might violate
// the max-heap property, we will have to call MaxHeapify to restore the property. The procedure repeats this process downto a heap size of 2 where it terminates

// Running time: 
// Let T(n) be the worst case running time of HeapSort
// T(n) = O(nlgn)
// Since BuildMaxHeap takes O(n) time and each of the size-1 calls to MaxHeapify takes O(lgn) time.


package data_structures.heap;
import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] list = new int[] {4,2,7,12,23,8,3,0,11,43,2};
		heapSort(list, list.length);
		System.out.println(Arrays.toString(list));
	}

	public static void heapSort(int[] list, int size) {
		int heapSize = size;
		BuildMaxHeap.buildMaxHeap(list, size);
		for (int i = size - 1; i >= 1; i--) {
			// swapping list[0] and list[i]
			int temp = list[0];
			list[0] = list[i];
			list[i] = temp;
			
			heapSize -= 1;
			MaxHeapify.maxHeapify(list, heapSize, 0);
		}
	}
}
