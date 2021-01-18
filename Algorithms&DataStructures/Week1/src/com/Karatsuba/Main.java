package com.Karatsuba;


import com.Karatsuba.util.Karatsuba;

public class Main {



    public static void main(String[] args) {
        //Logger logger = Logger.getLogger()

        Karatsuba m = new Karatsuba();
        int n = m.nDetermine(2,3);
        System.out.println("\n"+n);


        /*com.com.Karatsuba.util.Karatsuba.Main m = new com.com.Karatsuba.util.Karatsuba.Main();
        int num1=2;
        int num2=3;
        int tresult = num1*num2;
        int kresult = m.kmult(num1,num2);
        System.out.println("\nResult with 'traditional' multiplication is: " + tresult +
                "\nResult with com.Karatsuba.util.Karatsuba multiplication is: " + kresult );*/

    }
}
