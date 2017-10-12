# CSC 207 (Fall 2016) Homework: The Sounds of Sorting

## SortingVisualizer Program
 SortingVisualizer.java: the entry point of the program.
 ArrayPanel.java: the portion of the GUI that renders the note indices to the screen.
 ControlPanel.java: the portion of the GUI that contains widgets to control the program.
 Scale.java: an object that encapsulates a musical scale represented by a collection of MIDI notes.
 NoteIndices.java: an object that encapsulates a collection of indices into a particular Scale object.
 ### SortEvents:
 void apply(arr): applies this sort event to the given list.
 List<Integer> getAffectedIndices(): returns a list containing all of the indices that this event affects.
 boolean isEmphasized(): return true if this event should be emphasized by the visualizer/audibilizer.
 
 ### Sorts
 Selection Sort
 Insertion Sort
 Merge Sort
 Quick Sort
 
[The Sounds of Sorting](http://www.cs.grinnell.edu/~osera/courses/csc207/17sp/homeworks/the-sounds-of-sorting.html)


Authors: Bennett Hunter [hunterbe] and Nannan Ji [jinannan]

This program visually represents five different sorting algorithms and adds sounds for entertainment

Works cited: http://www.cs.grinnell.edu/~osera/courses/csc207/17fa/homework/the-sounds-of-sorting.html
