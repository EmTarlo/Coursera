package com.CaesarCypher;

import edu.duke.FileResource;



public class TestCaesarCipher {

    public static int[] countLetters(String s){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[]values = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = Character.toLowerCase(s.charAt(i));
            int idx = alpha.indexOf(ch);
            if(idx!=-1){
                values[idx]+=1;
            }

        }
        return values;
    }

    public static int  indexOfMax(int[] values){
        int idx_of_max=-1;
        int max=0;

        for(int i=0;i<values.length;i++){
            if(values[i]>max){
                max = values[i];
                idx_of_max = i;
            }
        }

        return idx_of_max;
    }

    public int getKey(String s){
        int[]values = new int[26];
        values = WordLengths.countLetters(s);
        int idx_max = WordLengths.indexOfMax(values);
        int key = 26-(4-idx_max);
        if (key > 26){
            key = key-26;
        }
        return key;
    }


    public String  breakCaesarCipher(String msg){
        int key = getKey(msg);
        ObjectOrientedCaesarCypher cc = new ObjectOrientedCaesarCypher(key);
        String dec_msg = cc.decrypt(msg);
        return dec_msg;

    }

    public void simpleTests(){
        FileResource fr = new FileResource();
        String str = fr.asString();
        System.out.println("Original message: "+str);
        ObjectOrientedCaesarCypher cc = new ObjectOrientedCaesarCypher(15);
        String enc_str = cc.encrypt(str);
        System.out.println("Encrypted Message: "+enc_str);
        String dec_str = cc.decrypt(enc_str);
        System.out.println("Decrypted Message: "+dec_str);
        String auto_dec_str = breakCaesarCipher(enc_str);
        System.out.println("Auto-Decrypted Message: "+auto_dec_str);

    }



}
