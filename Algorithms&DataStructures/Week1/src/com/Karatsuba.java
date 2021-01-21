
//code for the implementation of Karatsuba multiplication, one version for int numbers, the other for BigDecimals

package com;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Karatsuba {


    public int nDetermine(int num1, int num2) {
        int n;
        int n1 = String.valueOf(num1).length();
        int n2 = String.valueOf(num2).length();

        if (n1 == n2) {
            if (n1 % 2 == 0) {
                n = n1;
            } else {
                n = n1 + 1;
            }

        } else {
            int max = Math.max(n1, n2);
            if (max % 2 == 0) {
                n = max;
            } else {
                n = max + 1;
            }
        }

        return n;

    }

    public int kmult(int num1, int num2) {

        int result = 0;
        int n = nDetermine(num1, num2);


        if (n == 2) {


            int a = (int) Math.floor(num1 / (Math.pow(10, n / 2)));
            int c = (int) Math.floor(num2 / (Math.pow(10, n / 2)));
            double bb = num1 % Math.pow(10, n / 2);
            int b = (int) bb;
            double dd = num2 % Math.pow(10, n / 2);
            int d = (int) dd;
            int s1 = a * c;
            int s2 = b * d;
            int s3 = (a + b) * (c + d);
            int s4 = s3 - s2 - s1;
            double intermediateResult = Math.pow(10, n) * s1 + Math.pow(10, n / 2) * s4 + s2;
            result = (int) intermediateResult;

        } else if (n > 2) {

            int a = (int) Math.floor(num1 / (Math.pow(10, n / 2)));
            int c = (int) Math.floor(num2 / (Math.pow(10, n / 2)));
            double bb = num1 % Math.pow(10, n / 2);
            int b = (int) bb;
            double dd = num2 % Math.pow(10, n / 2);
            int d = (int) dd;
            int s1 = kmult(a, c);
            int s2 = kmult(b, d);
            int s3 = kmult(a + b, c + d);
            int s4 = s3 - s2 - s1;
            double intermediateResult = Math.pow(10, n) * s1 + Math.pow(10, n / 2) * s4 + s2;
            result = (int) intermediateResult;


        }

        return result;
    }

    public int nDetermineBigDecimal(String num1, String num2) {

        int n;

        int n1 = String.valueOf(num1).length();
        int n2 = String.valueOf(num2).length();

        if (n1 == n2) {
            if (n1 % 2 == 0) {
                n = n1;
            } else {
                n = n1 + 1;
            }

        } else {
            int max = Math.max(n1, n2);
            if (max % 2 == 0) {
                n = max;
            } else {
                n = max + 1;
            }
        }

        return n;

    }


    public BigDecimal kmultBigDecimal(String number1, String number2) {

        BigDecimal result = BigDecimal.valueOf(0);
        int n = nDetermineBigDecimal(number1, number2);
        BigDecimal num1 = new BigDecimal(number1);
        BigDecimal num2 = new BigDecimal(number2);
        int pow_of_ten_n_halfed_int = (int) Math.pow(10, n / 2);
        int pow_of_ten_n_int = (int) Math.pow(10, n);
        BigDecimal pow_of_ten_n_halfed = BigDecimal.valueOf(pow_of_ten_n_halfed_int);
        BigDecimal pow_of_ten_n = BigDecimal.valueOf(pow_of_ten_n_int);


        if (n == 2) {

            BigDecimal a = num1.divide(pow_of_ten_n_halfed, RoundingMode.FLOOR);
            BigDecimal c = num2.divide(pow_of_ten_n_halfed, RoundingMode.FLOOR);
            BigDecimal b = num1.remainder(pow_of_ten_n_halfed);
            BigDecimal d = num2.remainder(pow_of_ten_n_halfed);
            BigDecimal s1 = a.multiply(c);
            BigDecimal s2 = b.multiply(d);
            BigDecimal a_b = a.add(b);
            BigDecimal c_d = c.add(d);
            BigDecimal s3 = a_b.multiply(c_d);
            BigDecimal s2_plus_s1 = s2.add(s1);
            BigDecimal s4 = s3.subtract(s2_plus_s1);

            BigDecimal intermediateResult = s1.multiply(pow_of_ten_n);
            intermediateResult = intermediateResult.add(s4.multiply(pow_of_ten_n_halfed));
            result = intermediateResult.add(s2);

        }else if (n > 2){

            BigDecimal a = num1.divide(pow_of_ten_n_halfed, RoundingMode.FLOOR);
            BigDecimal c = num2.divide(pow_of_ten_n_halfed, RoundingMode.FLOOR);
            BigDecimal b = num1.remainder(pow_of_ten_n_halfed);
            BigDecimal d = num2.remainder(pow_of_ten_n_halfed);
            BigDecimal s1 = kmultBigDecimal(String.valueOf(a),String.valueOf(c));
            BigDecimal s2 = kmultBigDecimal(String.valueOf(b),String.valueOf(d));
            BigDecimal a_b = a.add(b);
            BigDecimal c_d = c.add(d);
            BigDecimal s3 = kmultBigDecimal(String.valueOf(a_b),String.valueOf(c_d));
            BigDecimal s2_plus_s1 = s2.add(s1);
            BigDecimal s4 = s3.subtract(s2_plus_s1);

            BigDecimal intermediateResult = s1.multiply(pow_of_ten_n);
            intermediateResult = intermediateResult.add(s4.multiply(pow_of_ten_n_halfed));
            result = intermediateResult.add(s2);

        }
        return result;
    }
}



