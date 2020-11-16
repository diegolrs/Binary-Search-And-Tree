import java.util.Random;
import java.util.Scanner;

public class QuickSort extends Sort {
	private static Random rand = new Random();
	
	@Override
	public void sort(Comparable[] array) {
		sort(0, array.length - 1, array);
	}
	
	private static void sort(int start, int end, Comparable[] array) {
		int left = start;
		int right = end;
		int pivot = rand.nextInt(right - left) + left;
		
		while(array[left].compareTo(array[pivot]) < 0)
			left++;
		
		while(array[right].compareTo(array[pivot]) > 0)
			right--;
		
		if(left <= right) {
			swap(left, right, array);
			left++;
			right--;
		}
		
		if(left < end)
			QuickSort.sort(left, end, array);
		
		if(right > start)
			QuickSort.sort(start, right, array);
	}

}
