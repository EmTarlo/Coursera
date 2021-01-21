package com;


public class Main {



    public static void main(String[] args) {
        /*Logger logger = Logger.getLogger();

        Karatsuba m = new Karatsuba();

        BigDecimal result = m.kmultBigDecimal("434343","4545454");
        //BigDecimal result = m.kmultBigDecimal("3141592653589793238462643383279502884197169399375105820974944592","2718281828459045235360287471352662497757247093699959574966967627");
        System.out.println("\n"+result);*/
        MergeSort ms = new MergeSort();

        int[] array1 = {1,20,31,99};
        int[] array2 = {2,10,45,82};
        int[] out_array = ms.merge(array1,array2);

        int size = out_array.length;
        int m = 0;

        while(m<=(size-1)){
            int a = out_array[m++];
            System.out.println("\n"+a);
        }

    }
}
