package com.Week3;

import java.util.Arrays;

public class QuickSort {

    public void print_array(int[] array){
        System.out.print("\n[ ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("]\n");
    }

   private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

   }

   public void quickSort(int[] array, int l, int r){
        if(l<r){
            int pivot = array[l];
            int i = l+1;
            for(int j = l+1;j<=r;j++){
                if(array[j]<pivot){
                    swap(array,j,i);
                    i++;
                }
            }
            swap(array,l,(i-1));


            quickSort(array,0,i-2);
            quickSort(array,i,r);

        }
   }


}

