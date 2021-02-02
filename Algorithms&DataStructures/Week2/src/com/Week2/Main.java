package com.Week2;

import edu.duke.FileResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

    /*
    	// initializing the input array
			//int[] arr = {6,5,4,3,2,1};


			FileResource fr = new FileResource("C:\\Users\\Francesco\\Desktop\\Coursera\\Algorithms&DataStructures\\Week2\\src\\Input_Files\\IntegerArray.txt");
			int[] arr = new int[100_000];
			int i=0;
			for(String line:fr.lines()){
				arr[i++]=Integer.valueOf(line);
			}

		int print_length = 100;

		// printing the input array
			System.out.print("\nInput array: [ ");

			for(int k=0;k<print_length;k++){
				System.out.print(arr[k]+" ");
			}

			System.out.print("]\n");

		// calling sortAndCount to populate output array
			com.Week2.InversionsInArray ia = new com.Week2.InversionsInArray();
			int[] output = ia.sortAndCount(arr);

		// printing the output array
			System.out.print("\nOutput array: [ ");

			for(int k=0;k<print_length;k++){
				System.out.print(output[k]+" ");
			}

			System.out.print("]\n");

		//printing the number of inversions found
			System.out.println("\nTotal number of inversions: "+ia.count);

	}*/

		com.Week2.FastPower fp = new com.Week2.FastPower();
		int result = fp.fastPower(3,4);
		System.out.println("\n"+result);

}
	}
