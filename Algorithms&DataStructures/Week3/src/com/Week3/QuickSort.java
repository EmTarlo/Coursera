package com.Week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class QuickSort {

    CompareToPivotAndCount cpc = new CompareToPivotAndCount();

    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public int partition(int[] array, int l, int r){
       int pivot = array[l];
       int i = l+1;
       for(int j = l+1;j<=r;j++) {

           if(cpc.compare_to_pivot_and_count(array[j],pivot)){
               swap(array,j,i);
               i++;
           }
       }
       swap(array,l,i-1);

       return i-1;
    }

   public void quickSort(int[] array, int l, int r){
        if(l==r){return;}
        else if(l<r){
            int i = partition(array,l,r);
            quickSort(array,l,i-1);
            quickSort(array,i+1,r);
        }
   }

   public int getNbrOfComparisonsInQuickSort(){return cpc.getNbrOfComparisons();}

}

