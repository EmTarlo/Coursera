package com.Week4;

import java.io.File;
import java.util.*;
import edu.duke.*;
import org.jetbrains.annotations.NotNull;

public class VigenereBreaker {

    public void print_array(int[] array){
        System.out.print("\n[ ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("]\n");
    }

    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder ret_str = new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            char ch = message.charAt(i);
            ret_str.append(ch);
        }
        return ret_str.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker ccr = new CaesarCracker();

        for(int i=0;i<klength;i++){
            String slice = sliceString(encrypted,i,klength);
            int curr_key = ccr.getKey(slice);
            key[i] = curr_key;
        }
        return key;
    }


    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dict = new HashSet<>();
        for (String line:fr.lines()) {
            String lw = line.toLowerCase();
            dict.add(lw);
        }
        return dict;
    }

    public int countWords(@NotNull String message, HashSet<String> dictionary) {
        int valid_words_count=0;
        String[] split_msg = message.split("\\W+");
        for (String word:split_msg) {
            String low_case_word = word.toLowerCase();
            if(dictionary.contains(low_case_word)){
                valid_words_count++;
            }
        }
        return valid_words_count;
    }

    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
        String decrypted = new String();
        int how_many_real_words = 0;
        int[] correct_key_set = null;

        for(int i=1;i<=100;i++){
            int[] curr_key_set = tryKeyLength(encrypted,i,'e');
            VigenereCipher vc = new VigenereCipher(curr_key_set);
            String curr_decrypted = vc.decrypt(encrypted);
            int curr_count_real_words = countWords(curr_decrypted,dictionary);
            if(curr_count_real_words>how_many_real_words){
                how_many_real_words = curr_count_real_words;
                decrypted = curr_decrypted;
                correct_key_set = curr_key_set;
            }
        }
        System.out.println("\nNumber of valid words found: "+how_many_real_words);
        return decrypted;
    }


    public void breakVigenere () {
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        fr = new FileResource();
        HashSet<String> dictionary = readDictionary(fr);
        String decrypted_msg = breakForLanguage(encrypted,dictionary);
        System.out.println(decrypted_msg);
    }
    
}
