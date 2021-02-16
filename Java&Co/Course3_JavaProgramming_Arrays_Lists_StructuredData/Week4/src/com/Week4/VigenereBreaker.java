package com.Week4;

import java.util.*;
import edu.duke.*;

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

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String file = fr.asString();
        int[] key = tryKeyLength(file,4,'e');
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted_msg = vc.decrypt(file);
        System.out.println(decrypted_msg);
    }
    
}
