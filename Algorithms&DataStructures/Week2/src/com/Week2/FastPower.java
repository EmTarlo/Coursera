package com.Week2;

public class FastPower {

    public int fastPower(int a, int b){
        int c,ans;
        if(b==1){
            return a;
        }else{
            c = a*a;
            ans = fastPower(c,b/2);
        }
        if(b%2!=0) {
            return a*ans;
        }else{
            return ans;
        }
    }
}
