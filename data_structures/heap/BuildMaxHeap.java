// The algorithm BuildMaxHeap converts an array into a max-heap by calling MaxHeapify in a bottom-up manner

// Running time: Let T(n) be the running time of BuildMaxHeap procedure, we have
// T(n) = O(n)
// Hence, we can build a max-heap from an unordered array in linear time.

package data_structures.heap;
import java.util.Arrays;
import data_structures.heap.*;

public class BuildMaxHeap {
	public static void main(String[] args) {
		int[] list = new int[] {1,3,8,6,4,0,12,5,16};
		buildMaxHeap(list, list.length);
		System.out.println(Arrays.toString(list));
	}
	public static void buildMaxHeap(int[] list, int size) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			MaxHeapify.maxHeapify(list, list.length, i);
		}
	}
}
