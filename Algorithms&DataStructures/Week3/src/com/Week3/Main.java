package com.Week3;

public class Main {

    public static void main(String[] args) {
        int[] array = {4,3,8,7,1,2,6,5};
        QuickSort qs = new QuickSort();
        System.out.println("\nOriginal array:");
        qs.print_array(array);
        qs.quickSort(array,0,array.length-1);
        System.out.println("\nSorted array:");
        qs.print_array(array);
    }
}
