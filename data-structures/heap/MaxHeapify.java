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
