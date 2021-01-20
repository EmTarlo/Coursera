package com.Karatsuba;


import com.Karatsuba.util.Karatsuba;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Logger;

public class Main {



    public static void main(String[] args) {
        //Logger logger = Logger.getLogger();

        Karatsuba m = new Karatsuba();

        BigDecimal result = m.kmultBigDecimal("434343","4545454");
        //BigDecimal result = m.kmultBigDecimal("3141592653589793238462643383279502884197169399375105820974944592","2718281828459045235360287471352662497757247093699959574966967627");
        System.out.println("\n"+result);


    }
}
