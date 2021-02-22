package com.Week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Util {

    public int[] arrayList_to_array_int(ArrayList<Integer> arrayL){
        Integer[] temp_array = new Integer[arrayL.size()];
        temp_array = arrayL.toArray(temp_array);
        int[] finalArray = Arrays.stream(temp_array).mapToInt(Integer::intValue).toArray();
        return finalArray;

    }


    public int[] read_int_array(String filePath) throws IOException {
        ArrayList<Integer> arrayL = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        while (line != null){
            arrayL.add(Integer.valueOf(line));
            line = br.readLine();
        }
        int[] finalArray = arrayList_to_array_int(arrayL);
        return finalArray;
    }

    public void print_int_array(int[] array){
        System.out.print("\n[ ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("]\n");
    }
}
