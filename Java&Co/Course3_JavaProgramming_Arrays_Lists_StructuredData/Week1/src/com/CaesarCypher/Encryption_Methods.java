package com.CaesarCypher;

import edu.duke.FileResource;
import com.CaesarCypher.WordLengths;

public class Encryption_Methods {

    public boolean isVowel(char ch){
        char[] vowels = {'a','e','i','o','u'};
        char character = Character.toLowerCase(ch);

        for(int i=0;i<vowels.length;i++){
            if(vowels[i]==character){
                return true;
            }
        }

        return false;

        }

    public String replaceVowels(String phrase, char ch){
        StringBuilder new_phrase = new StringBuilder(phrase);

        for(int i=0;i<new_phrase.length();i++){
            char curr_char = new_phrase.charAt(i);
            if(isVowel(curr_char)){
                new_phrase.setCharAt(i,ch);
            }
        }
        String end_phrase = new String(new_phrase);
        return end_phrase;
    }

    public String emphasize(String phrase, char ch){
        StringBuilder new_phrase = new StringBuilder(phrase);

        for(int i=0;i<new_phrase.length();i++){
            if(new_phrase.charAt(i)==Character.toLowerCase(ch)||new_phrase.charAt(i)==Character.toUpperCase(ch)){
                if(i%2==0){
                    new_phrase.setCharAt(i,'*');
                }else{
                    new_phrase.setCharAt(i,'+');
                }
            }
        }

        String end_phrase = new String(new_phrase);
        return end_phrase;
    }

    public String encrypt(String msg, int key){

        StringBuilder new_msg = new StringBuilder(msg);
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String ALPHA = alpha.toUpperCase();

        String shift_alpha = alpha.substring(key) + alpha.substring(0,key);
        String SHIFT_ALPHA = shift_alpha.toUpperCase();

        for(int i=0;i<new_msg.length();i++){
            char curr_char = new_msg.charAt(i);
            int idx = alpha.indexOf(curr_char);
            if(idx!=-1){
                char new_char = shift_alpha.charAt(idx);
                new_msg.setCharAt(i,new_char);
            }else{
                 int idx_upp = ALPHA.indexOf(curr_char);
                 if(idx_upp!=-1){
                     char new_char = SHIFT_ALPHA.charAt(idx_upp);
                     new_msg.setCharAt(i,new_char);
                 }


            }
        }

        String ret_msg = new String(new_msg);
        return ret_msg;

    }


    public String encryptTwoKeys(String input, int key1, int key2){
            StringBuilder msg = new StringBuilder(input);
            StringBuilder subMsg1= new StringBuilder();
            StringBuilder subMsg2= new StringBuilder();
            int i=0, j=1;

            while(i<msg.length()){
                char c = msg.charAt(i);
                subMsg1.append(c);
                i += 2;
            }
            while(j<msg.length()) {
                char d = msg.charAt(j);
                subMsg2.append(d);
                j += 2;

            }

            StringBuilder subMsg1enc = new StringBuilder(encrypt(String.valueOf(subMsg1),key1));
            StringBuilder subMsg2enc = new StringBuilder(encrypt(String.valueOf(subMsg2),key2));

            int n=0,m=0;
            StringBuilder enc_msg = new StringBuilder();

            while(n<subMsg1enc.length() && m<subMsg2enc.length()) {
                enc_msg.append(subMsg1enc.charAt(n++));
                enc_msg.append(subMsg2enc.charAt(m++));
            }


            while(n<subMsg1enc.length()){
                enc_msg.append(subMsg1enc.charAt(n++));
            }

            String ret = new String(enc_msg);

            return ret;

    }

    public String decrypt(String msg){
        StringBuilder new_msg = new StringBuilder(msg);
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String ALPHA = alpha.toUpperCase();
        int key = getKey(msg);
        System.out.println("\nKey found is: "+key);
        String shift_alpha = alpha.substring(key) + alpha.substring(0,key);
        String SHIFT_ALPHA = shift_alpha.toUpperCase();

        for(int i=0;i<new_msg.length();i++){
            char curr_char = new_msg.charAt(i);
            int idx = shift_alpha.indexOf(curr_char);
            if(idx!=-1){
                char new_char = alpha.charAt(idx);
                new_msg.setCharAt(i,new_char);
            }else{
                int idx_upp = SHIFT_ALPHA.indexOf(curr_char);
                if(idx_upp!=-1){
                    char new_char = ALPHA.charAt(idx_upp);
                    new_msg.setCharAt(i,new_char);
                }
            }
        }

        String ret_msg = new String(new_msg);
        return ret_msg;

    }

    public String decryptTwoKeys(String input){
        StringBuilder msg = new StringBuilder(input);
        StringBuilder subMsg1= new StringBuilder();
        StringBuilder subMsg2= new StringBuilder();
        int i=0, j=1;

        while(i<msg.length()){
            char c = msg.charAt(i);
            subMsg1.append(c);
            i += 2;
        }
        while(j<msg.length()) {
            char d = msg.charAt(j);
            subMsg2.append(d);
            j += 2;

        }

        StringBuilder subMsg1dec = new StringBuilder(decrypt(String.valueOf(subMsg1)));
        StringBuilder subMsg2dec = new StringBuilder(decrypt(String.valueOf(subMsg2)));

        int n=0,m=0;
        StringBuilder enc_msg = new StringBuilder();

        while(n<subMsg1dec.length() && m<subMsg2dec.length()) {
            enc_msg.append(subMsg1dec.charAt(n++));
            enc_msg.append(subMsg2dec.charAt(m++));
        }


        while(n<subMsg1dec.length()){
            enc_msg.append(subMsg1dec.charAt(n++));
        }

        String ret = new String(enc_msg);

        return ret;

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

    public void testGetKey(){
        String s = "Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu";
        int k = getKey(s);
        System.out.println("\nKey is: "+k);

    }

}