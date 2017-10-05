
public class Sorts {

	/**
	 * swaps two elements of an array
	 * @param arr the array in which the elements will be swapped
	 * @param a the index of the first element being swapped
	 * @param b the index of the second element being swapped
	 */
	public static <T> void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/**
	 * sorts an array with the selection technique
	 * @param arr the array to be sorted
	 */
	public static void slectionSort(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			int sm_index = i;

			for(int j = i ; j < arr.length ; j++) {
				if(arr[j] < arr[sm_index]) sm_index = j;
			}
			swap(arr, sm_index, i);
		}	
	}

	/**
	 * sorts an array with the insertion technique
	 * @param arr the array to be sorted
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = i; j> 0; j--) {
				int x = j - 1;
				if(arr[x].compareTo(arr[j]) > 0) {    //  arr[x] > arr[j]
					swap(arr, x, j);
				}
			}

		}
	}

	/**
	 * pre: both halves of the array must be sorted
	 * sorts an array using the merge technique from lo to hi
	 * @param arr the array to sorted
	 * @param lo the lower bound index
	 * @param hi the upper bound index
	 * @param mid the index between lo and hi
	 */
	public static void merge(int[] arr, int lo, int hi, int mid) {
		int[] merged = new int[hi-lo+1];
		int i = lo;
		int j = mid+1;
		int k = 0;
		while(i <= mid && j <= hi){
			if(arr[i] > arr[j]) {
				merged[k++] = arr[j];
				j++;
			}else {
				merged[k++] = arr[i];
				i++;
			}

		}

		while(j <= hi) {
			merged[k++] = arr[j];
			j++;
		}

		while(i <= mid) {
			merged[k++] = arr[i];
			i++;
		}

		for(int a = 0 ; a<merged.length; a++) {
			arr[lo+a] = merged[a];
		}
	}

	/**
	 * Merge sort helper that sorts both left and right side of an array recursively from lo to hi
	 * @param arr the array to be sorted
	 * @param lo the lower bound index
	 * @param hi the upper bound index
	 */
	public static void mergeSortHelper(int[] arr, int lo, int hi) {
		if(lo<hi) {
			int mid = lo + (hi-lo)/2;

			//Sorting the left half
			mergeSortHelper(arr,lo,mid);

			//Sorting the right half
			mergeSortHelper(arr,mid+1,hi);

			//Merge the sorted parts
			merge(arr,lo,hi,mid);
		}

	}

	/**
	 * Driver method behind merge sort
	 * @param arr the array to be sorted
	 */
	public static void mergeSort(int[] arr) {
		mergeSortHelper(arr,0,arr.length-1);
	}


	public static void bubbleSort(int[] arr) {  
		int n = arr.length;  
		int temp = 0;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(arr[j-1] > arr[j]){  
					//swap elements  
					temp = arr[j-1];  
					arr[j-1] = arr[j];  
					arr[j] = temp;  
				}
			}
		}
	}


	/**
	 * Finds the best pivot point of array arr
	 * @param arr the array you want to find pivot of
	 * @param a the first index
	 * @param b the second index
	 * @param c the last index
	 * @return Median of a, b, c, which should be used as pivot for quicksort
	 */
	public static int findMedianIndex(int[]arr, int a, int b, int c) {
		int answer = Math.max(Math.min(arr[a], arr[b]), Math.min(Math.max(arr[a], arr[b]), arr[c])); 
		if(answer == arr[a]) {
			return a;
		}
		else if(answer == arr[b]) {
			return b;
		}
		else {
			return c;
		}
	}

	/**
	 * Quicksort helper method that sorts array from arr[lo] to arr[hi]
	 * @param arr the array to be sorted
	 * @param lo the low end of the array 
	 * @param hi the high end of the array
	 */
	public static void quicksortHelper(int[] arr, int lo, int hi) {

		// finding the median to be placed at end
		int lastIndex = hi;
		int midIndex = lo + (hi - lo) / 2;
		int quicksortMedian = findMedianIndex(arr, 0, midIndex, lastIndex);
		swap(arr, quicksortMedian, lastIndex);

		//setting pointers 
		int i = lo;
		int j = hi-1;

		//Sorting the array
		while(i <= j) {

			while(arr[i] < arr[lastIndex]) {
				i++;
			}	

			while(arr[j] > arr[lastIndex]) {
				j--;
			}

			if(i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}

		//splitting the array

		swap(arr, i, lastIndex);

		// sorting our two split arrays
		if(lo < j) {
			quicksortHelper(arr, lo, j);
		}
		if(i + 1 < hi) {
			quicksortHelper(arr, i, hi);
		}
	}

	/**
	 * Quicksorts the array arr
	 * @param arr the array to be sorted
	 */
	public static void quicksort(int[] arr) {
		quicksortHelper(arr, 0, arr.length - 1);
	}
}
