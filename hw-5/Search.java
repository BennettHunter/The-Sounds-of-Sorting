
public class Search {

    public static boolean contains(int v, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == v) {
                return true;
            }
        }
        return false;
    }

    //pre: arr is sorted
    public static boolean bsearch(int v, int[] arr, int lo, int hi) {
        if(lo >= hi || arr.length == 0 || arr == null) return false;

        int mid = lo + (hi - lo) / 2;
        if(arr[mid]==v) {
            return true;
        }else if( v < arr[mid]) {
            return bsearch(v,arr,lo,mid);
        }else {
            return bsearch(v,arr,mid+1,hi);
        }

    }

}
