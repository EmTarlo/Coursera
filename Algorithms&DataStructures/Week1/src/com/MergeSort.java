package com;


import java.util.Arrays;

public class MergeSort {

    /* The following method is the core implementation of the mergeSort algorithm. It includes:
            1) a recursive call for left half of the input array
            2) recursive call for right half of the input array
            3) call of the merge method defined further below
    */
    public int[] mergeSort(int[] array){
        int middle = (array.length/2)-1;
        int low = 0;
        int high = array.length-1;
        int [] left_array = Arrays.copyOfRange(array, low, middle+1);
        int []right_array = Arrays.copyOfRange(array, middle+1, high + 1);

        if(low<high){
            left_array = mergeSort(left_array);
            right_array = mergeSort(right_array);
        }

        int[] output = merge(left_array,right_array);
        return output;

    }


    // The following method efficiently merges together two sorted arrays. The input arrays don't have to be of the same length.
    public int[] merge(int[] array1,int[] array2){
        int size_ar1 = array1.length;
        int size_ar2 = array2.length;
        int size = size_ar1+size_ar2;
        int[] out_array = new int[size];
        int i=0,j=0,k=0;

        while(k<=(size-1)){
            while(i<=(size_ar1-1) && j<=(size_ar2-1)){
                if(array1[i]<array2[j]) {
                    out_array[k++] = array1[i++];
                }else{
                    out_array[k++] = array2[j++];
                }
            }

            while(i<=(size_ar1-1)){
                out_array[k++] = array1[i++];
            }

            while(j<=(size_ar2-1)){
                out_array[k++] = array2[j++];
            }
        }
        return out_array;
    }
}
