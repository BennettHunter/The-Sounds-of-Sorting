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
		assertEquals(testarr[0], 0);
	}
	
	@Test
	public void testMergeSort2() {
		int[] testarr = {2,8,2,0,2,3,1,4};
		Sorts.mergeSort(testarr);
		assertEquals(testarr[0], 0);
	}
	
	@Test
	public void testMergeSort3() {
		int[] testarr = {19302, 478901, 174839275, 1, 8695045};
		Sorts.mergeSort(testarr);
		assertEquals(testarr[0], 1);
	}
			
	
	// Test Suite for merge sort end
	
	

}
