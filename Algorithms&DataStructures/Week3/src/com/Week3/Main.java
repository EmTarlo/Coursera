package com.Week3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        QuickSort qs = new QuickSort();
        Util u = new Util();
        int[] array  = u.read_int_array("C:\\Users\\Francesco\\Desktop\\Coursera\\Algorithms&DataStructures\\Week3\\src\\com\\Week3\\Input_Files\\Array10_10000.txt");

        System.out.println("\nOriginal array:");
        u.print_int_array(array);
        qs.quickSort(array,0,array.length-1);
        System.out.println("\nSorted array:");
        u.print_int_array(array);
        System.out.println("\nTotal number of comparisons: "+qs.getNbrOfComparisonsInQuickSort());


    }
}
