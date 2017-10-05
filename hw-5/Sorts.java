
public class Sorts {
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void slectionSort(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			int sm_index = i;
			
			for(int j = i ; j < arr.length ; j++) {
				if(arr[j] < arr[sm_index]) sm_index = j;
			}
			swap(arr, sm_index, i);
		}	
	}
	
	public static void insertionSort(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = i; j> 0; j--) {
                int x = j - 1;
				if(arr[x]>arr[j]) {
					swap(arr, x, j);
				}
			}

		}
	}
	
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
	
	public static void mergeSort(int[] arr) {
		mergeSortHelper(arr,0,arr.length-1);
	}
	
	
       public static void bubbleSort(int[] arr) {  
           int n = arr.length;  
           int temp = 0;  
           for(int i=0; i < n; i++){  
                  for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                          }                
                   }  
            }
       }
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
	
	public static void quicksortHelper(int[] arr, int lo, int hi) {

		// finding the median to be placed at end
		int lastIndex = hi;
		int midIndex = lo + (hi - lo) / 2;
		int quicksortMedian = findMedianIndex(arr, 0, midIndex, lastIndex);
		Sort.swap(arr, quicksortMedian, lastIndex);

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
	
	public static void quicksort(int[] arr) {
		quicksortHelper(arr, 0, arr.length - 1);
	}
}
