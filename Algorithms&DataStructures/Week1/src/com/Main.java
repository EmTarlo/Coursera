package com;


public class Main {



    public static void main(String[] args) {

        com.MergeSort ms = new com.MergeSort();

        int[] array = {7,4,5,1,2,6,3};
        int m = 0;
        int size = array.length;
        int[] out_array = new int[size];
        out_array = ms.mergeSort(array);

        while(m<=(size-1)){
            int a = out_array[m++];
            System.out.println("\n"+a);
        }


    }
}
