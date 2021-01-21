package com;

public class MergeSort {

    public int[] merge(int[] array1,int[] array2){
        int org_size = array1.length;
        int size = org_size*2;
        int[] out_array = new int[size];
        int i=0,j=0,k=0;

        while(k<=(size-1)){
            while(i<=(org_size-1) && j<=(org_size-1)){
                if(array1[i]<array2[j]) {
                    out_array[k++] = array1[i++];
                }else{
                    out_array[k++] = array2[j++];
                }
            }

            while(i<=(org_size-1)){
                out_array[k++] = array1[i++];
            }

            while(j<=(org_size-1)){
                out_array[k++] = array2[j++];
            }
        }
        return out_array;
    }
}
