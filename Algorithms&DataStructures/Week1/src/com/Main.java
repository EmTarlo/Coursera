package com;


public class Main {



    public static void main(String[] args) {

        com.MergeSort ms = new com.MergeSort();

        int[] array = {};
        int m = 0;
        int size = array.length;
        int[] out_array;
        out_array = ms.mergeSort(array);


        while(m<=(size-1)){
            int a = out_array[m++];
            System.out.println("\n"+a);
        }


    }
}
