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
        CaesarCracker ccr = new CaesarCracker(mostCommon);

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

    public String breakForLanguage(String encrypted,HashSet<String> dictionary, char mostCommon){
        String decrypted = new String();
        int how_many_real_words = 0;
        int[] correct_key_set = null;

        for(int i=1;i<=100;i++){
            int[] curr_key_set = tryKeyLength(encrypted,i,mostCommon);
            VigenereCipher vc = new VigenereCipher(curr_key_set);
            String curr_decrypted = vc.decrypt(encrypted);
            int curr_count_real_words = countWords(curr_decrypted,dictionary);
            if(curr_count_real_words>how_many_real_words){
                how_many_real_words = curr_count_real_words;
                decrypted = curr_decrypted;
                correct_key_set = curr_key_set;
            }
        }
        return decrypted;
    }

    public Character mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character,Integer> characters = new HashMap<>();
        for (String word:dictionary) {
            for(int i=0;i<word.length();i++){
                Character c = word.charAt(i);
                if(!characters.containsKey(c)){
                    characters.put(c,1);
                }else{
                    int curr_count = characters.get(c);
                    characters.put(c,++curr_count);
                }
            }
        }
        int max_count = 0;
        Character max_c = null;
        for (Character c:characters.keySet()) {
            if(characters.get(c)>max_count){
                max_count = characters.get(c);
                max_c = c;
            }
        }
        return max_c;
    }


    public void  breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> language_to_dict){
            int max_real_words_count = 0;
            String final_decrypted = new String();
            String final_language = new String();
            char final_most_common = ' ';

        for(String language:language_to_dict.keySet()){
            HashSet<String> curr_dict = language_to_dict.get(language);
            char mostCommonCharInLanguage = (char) mostCommonCharIn(curr_dict);
            String decrypted = breakForLanguage(encrypted,curr_dict,mostCommonCharInLanguage);
            int curr_real_words_count = countWords(decrypted,curr_dict);
            if(curr_real_words_count>max_real_words_count){
                max_real_words_count = curr_real_words_count;
                final_decrypted = decrypted;
                final_language = language;
                final_most_common = mostCommonCharInLanguage;
            }
        }
        System.out.println("\n------------------------------------------------------------");
        System.out.println("\nThe language used for decryption was: "+final_language);
        System.out.println("\nThe most common character in this language is: "+final_most_common);
        System.out.println("\nThe count of real words in the decrypted message was: "+max_real_words_count);
        System.out.println("\nHere below the decrypted message: ");
        System.out.println("\n\n"+final_decrypted);
    }

    public void breakVigenere() {
        HashMap<String,HashSet<String>> language_to_dict = new HashMap<>();
        System.out.println("\nPlease select all the dictionaries you would like to use:");
        DirectoryResource dr = new DirectoryResource();
        for (File f:dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String curr_language = f.getName();
            HashSet<String> curr_dict = readDictionary(fr);
            language_to_dict.put(curr_language,curr_dict);
            System.out.println("\n"+curr_language + " has been added to language_to_dict.");
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.println("\nPlease select the message to be decrypted: ");
        FileResource fileRes = new FileResource();
        String encrypted = fileRes.asString();
        breakForAllLangs(encrypted,language_to_dict);

    }
    
}
