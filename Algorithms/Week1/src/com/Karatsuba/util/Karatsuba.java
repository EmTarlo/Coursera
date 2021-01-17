package com.Karatsuba.util;

public class Karatsuba {

    public int nDetermine(int num1, int num2){
        int n;
        int n1 = String.valueOf(num1).length();
        int n2 = String.valueOf(num2).length();

        if(n1==n2){
            if(n1%2==0){
                n = n1;
            }else{
                n = n1 + 1;
            }

        }else{
            int max = Math.max(n1,n2);
            if(max%2==0){
                n = max;
            }else{
                n = max + 1;
            }
        }

        return n;

    }

    public int kmult(int num1, int num2){

        int result = 0;
        int n = nDetermine(num1, num2);


        if(n==2){


            int a = (int) Math.floor(num1/(Math.pow(10,n/2)));
            int c = (int) Math.floor(num2/(Math.pow(10,n/2)));
            double bb = num1%Math.pow(10,n/2);
            int b = (int) bb;
            double dd = num2%Math.pow(10,n/2);
            int d = (int) dd;
            int s1 = a*c;
            int s2 = b*d;
            int s3 = (a+b)*(c+d);
            int s4 = s3 - s2 - s1;
            double intermediateResult = Math.pow(10,n)*s1 + Math.pow(10,n/2)*s4+s2;
            result = (int) intermediateResult;

        }else{

            int a = (int) Math.floor(num1/(Math.pow(10,n/2)));
            int c = (int) Math.floor(num2/(Math.pow(10,n/2)));
            double bb = num1%Math.pow(10,n/2);
            int b = (int) bb;
            double dd = num2%Math.pow(10,n/2);
            int d = (int) dd;
            int s1 = kmult(a,c);
            int s2 = kmult(b,d);
            int s3 = kmult(a+b,c+d);
            int s4 = s3 - s2 - s1;
            double intermediateResult = Math.pow(10,n)*s1 + Math.pow(10,n/2)*s4+s2;
            result = (int) intermediateResult;


        }

        return result;
    }





}



