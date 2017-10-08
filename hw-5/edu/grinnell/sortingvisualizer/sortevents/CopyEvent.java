package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T>{
    private int first_index;
    private int second_index;

    public CopyEvent(int fir, int sec) {
        this.first_index = fir;
        this.second_index = sec;
    }

    public void apply(T[] arr) {
        arr[this.first_index] = arr[this.second_index];
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(this.first_index);
        list.add(this.second_index);
        return list;  
    }

    public boolean isEmphasized() {
        return true;
    }


}
