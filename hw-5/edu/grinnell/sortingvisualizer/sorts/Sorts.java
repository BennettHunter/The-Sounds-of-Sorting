package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.*;


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
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
        ArrayList<SortEvent<T>> events = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++) {
            int sm_index = i;

            for(int j = i ; j < arr.length ; j++) {
                events.add(new CompareEvent<T>(i,j));
                if(arr[j].compareTo(arr[sm_index])<0) sm_index = j;
                
            }
            events.add(new SwapEvent<T>(i,sm_index));
            swap(arr, sm_index, i);
        }
        return events;
    }
    


    /**
     * sorts an array with the insertion technique
     * @param arr the array to be sorted
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = i; j> 0; j--) {
                int x = j - 1;
                events.add(new CompareEvent<T>(x,j));
                if(arr[x].compareTo(arr[j]) > 0) {
                    events.add(new SwapEvent<T>(x,j));
                    swap(arr, x, j);
                }
            }

        }
        return events;
    }

    /**
     * pre: both halves of the array must be sorted
     * sorts an array using the merge technique from lo to hi
     * @param arr the array to sorted
     * @param lo the lower bound index
     * @param hi the upper bound index
     * @param mid the index between lo and hi
     */
    public static <T extends Comparable<T>> ArrayList<SortEvent<T>> merge(T[] arr, int lo, int hi, int mid) {
        ArrayList<SortEvent<T>> events = new ArrayList<>();
        Object[] merged = new Object[hi-lo+1];
        int i = lo;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= hi){
            events.add(new CompareEvent<T>(i,j));
            if(arr[i].compareTo(arr[j])>0) {
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
            arr[lo+a] = (T) merged[a];
        }
        
        return events;
    }

    /**
     * Merge sort helper that sorts both left and right side of an array recursively from lo to hi
     * @param arr the array to be sorted
     * @param lo the lower bound index
     * @param hi the upper bound index
     */
    public static <T extends Comparable<T>> void mergeSortHelper(T[] arr, int lo, int hi) {
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
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSortHelper(arr,0,arr.length-1);
    }


    public static <T extends Comparable<? super T>> ArrayList<SortEvent<T>> bubbleSort(T[] arr) { 
        ArrayList<SortEvent<T>> events = new ArrayList<>();
        int n = arr.length;  
 
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                events.add(new CompareEvent<T>(j-1,j));
                if(arr[j-1].compareTo(arr[j])>0){  
                    events.add(new SwapEvent<T>(j-1,j));
                    swap(arr,j-1,j); 
                }
            }
        }
        return events;
    }

    /**
     * Finds the best pivot point of array arr
     * @param arr the array you want to find pivot of
     * @param fir the first index
     * @param mid the second index
     * @param last the last index
     * @return Median of a, b, c, which should be used as pivot for quicksort
     */
    public static <T extends Comparable<? super T>> int findMedianIndex(T[]arr, int fir, int mid, int last) {
        T answer = arr [mid];
        if(answer.compareTo(arr[fir])>0) {
            if(answer.compareTo(arr[last])<0) {
                return mid;
            }else {
                return last;
            }
        }else {
            if(answer.compareTo(arr[last])>0) {
                return mid; 
            }else {
                return fir;
            }
        }
        /*  //= Math.max(Math.min(arr[fir], arr[mid]), Math.min(Math.max(arr[fir], arr[mid]), arr[last])); 
        if(answer == arr[fir]) {
            return fir;
        }
        else if(answer == arr[mid]) {
            return mid;
        }
        else {
            return last;
        } */
    }

    /**
     * Quicksort helper method that sorts array from arr[lo] to arr[hi]
     * @param arr the array to be sorted
     * @param lo the low end of the array 
     * @param hi the high end of the array
     */
    public static <T extends Comparable<? super T>> void quicksortHelper(T[] arr, int lo, int hi) {

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

            while(arr[i].compareTo(arr[lastIndex]) < 0) {
                i++;
            }	

            while(arr[j].compareTo(arr[lastIndex]) > 0) {
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
    public static <T extends Comparable<? super T>> void quicksort(T[] arr) {
        quicksortHelper(arr, 0, arr.length - 1);
    }
    
    public static <T> void eventSort(T[] l, List<SortEvent<T>> events) {
        for(SortEvent event:events) {
            event.apply(l);
        }
    }

    
}
