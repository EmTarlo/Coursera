package com.CaesarCypher;

import edu.duke.FileResource;

public class TestCaesarCipherTwo {
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

    public String halfOfString(String str, int start){
        StringBuilder new_str = new StringBuilder();

        for(int i=start;i< str.length();i+=2){
            char ch = str.charAt(i);
            new_str.append(ch);
        }

        String ret_str = new String(new_str);
        return ret_str;
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


    public String breakCaesarCipher(String msg){
        String half1 = halfOfString(msg,0);
        String half2 = halfOfString(msg,1);

        int key1 = getKey(half1);
        System.out.println("Key1 is: "+key1);
        int key2 = getKey(half2);
        System.out.println("Key2 is: "+key2);

        ObjectOrientedCaesarCipherTwoKeys cc2 = new ObjectOrientedCaesarCipherTwoKeys(key1,key2);
        String dec_msg = cc2.decrypt(msg);
        return dec_msg;

    }


    public void simpleTests(){
        FileResource fr = new FileResource();
        String str = fr.asString();
        System.out.println(" ");
        System.out.println("Original message: "+str);
        ObjectOrientedCaesarCipherTwoKeys cc2 = new ObjectOrientedCaesarCipherTwoKeys(14,24);
        //String enc_str = cc2.encrypt(str);
        //System.out.println("Encrypted Message: "+enc_str);
        //String dec_str = cc2.decrypt(str);
        //System.out.println("Decrypted Message: "+dec_str);
        String auto_dec_str = breakCaesarCipher(str);
        System.out.println("Auto-Decrypted Message: "+auto_dec_str);


    }

}
