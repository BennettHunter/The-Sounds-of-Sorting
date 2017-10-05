import static org.junit.Assert.*;

import org.junit.Test;

public class SortsTest {

	@Test
	public void testSort() {
		int[] arr = {6,3,34,6,8,24,34334};
		Sorts.insertionSort(arr);
		assertEquals(arr[0], 3);
		
	}
	
	
	@Test
	public void testMergeSort1() {
		int[] testarr = {3,7,0,4,0,2,1,9,9,7,0,6,2,8,3,0,4,5};
		Sorts.mergeSort(testarr);
		int[] sorted = {0,0,0,0,1,2,2,3,3,4,4,5,6,7,7,8,9,9};
		assertArrayEquals(testarr, sorted);
	}
	
	@Test
	public void testMergeSort2() {
		int[] testarr = {2,8,2,0,2,3,1,4};
		Sorts.mergeSort(testarr);
		int[] sorted = {0,1,2,2,2,3,4,8};
		assertArrayEquals(testarr, sorted);
	}
	
	@Test
	public void testMergeSort3() {
		int[] testarr = {19302, 478901, 174839275, 1, 8695045};
		Sorts.mergeSort(testarr);
		int[] sorted = {1, 19302, 478901,8695045, 174839275};   
		assertArrayEquals(testarr, sorted);
	}
	
	
			
	@Test 
	public void testQuickSort1() {
		int[] test = {3,9,2,8,6,4,1,7,5};
		Sort.quicksort(test);
		int[] sorted = {1,2,3,4,5,6,7,8,9};
		assertArrayEquals(test, sorted);
	} 
	
	@Test 
	public void testQuickSort2() {
		int[] test = {1,4,8,2,1,10};
		Sort.quicksort(test);
		int[] sorted = {1,1,2,4,8,10};
		assertArrayEquals(test, sorted);
	}
	
	@Test 
	public void testQuickSort3() {
		int[] test = {4,8,1,22,4,1,5,6};
		Sort.quicksort(test);
		int[] sorted = {1,1,4,4,5,6,8,22};
		assertArrayEquals(test, sorted);
 
	} 
}
