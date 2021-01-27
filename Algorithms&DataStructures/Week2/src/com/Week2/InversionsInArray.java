package com.Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;


// The purpose of the code below is to efficiently compute the number of inversions in an array.
// The key idea is to leverage recursive calls to the two halves in which the input array can be split,
// in a very similar fashion to merge-sort.

public class InversionsInArray {
        public long count = 0;

        public int[] sortAndCount(int[] array){

            int middle = (array.length/2)-1;
            int low = 0;
            int high = array.length-1;
            int [] left_array = Arrays.copyOfRange(array, low, middle+1);
            int []right_array = Arrays.copyOfRange(array, middle+1, high + 1);

            if(low<high){
                left_array = sortAndCount(left_array);
                right_array = sortAndCount(right_array);
            }

            int[] output = mergeAndCount(left_array,right_array);
            //System.out.println("\nCount running total: "+count);
            return output;

        }


        public int[] mergeAndCount(int[] array1,int[] array2){
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
                        count+=array1.length - i;
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


        public void testSortAndCount() throws FileNotFoundException {
            int i=0;
            int[] input_arr = new int[100000];
            Scanner scanner = new Scanner(new File("C:\\Users\\Francesco\\Desktop\\Coursera\\Algorithms&DataStructures\\Week2\\src\\Input_Files\\IntegerArray.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                input_arr[i++] = Integer.valueOf(line);
            }

            int[] sorted_arr;
            sorted_arr = sortAndCount(input_arr);

            long tot_count = count;
            System.out.println("\nTotal number of inversions in array: "+tot_count);
        }

}














