package com.Week2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class WordsInFiles {

    private HashMap<String,ArrayList<String>> words_map;

    public WordsInFiles(){
        words_map = new HashMap<>();
    }


    private void addWordsFromFile(String word, String fileName){
        ArrayList<String> arr = new ArrayList<>();

        if(words_map.containsKey(word)){
            arr = words_map.get(word);
            if(!arr.contains(fileName)){
                arr.add(fileName);
            }
        }else{
            arr.add(fileName);
            words_map.put(word,arr);
        }
    }

    private void buildWordsMapFromFile(File f){
        FileResource fr = new FileResource(f);
        String lcase_w;
        for(String w:fr.words()){
            lcase_w = w.toLowerCase();
            addWordsFromFile(w,f.getName());
        }
    }

    private void buildWordsMapFromFiles(){
        words_map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            buildWordsMapFromFile(f);
        }
    }

    private void printFilesIn(String word){
        ArrayList<String> arr = words_map.get(word);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }

    private int maxNumberOfFiles(){
        ArrayList<String> arr;
        int curr_nbr_of_files;

        int max_nbr_of_files = 0;
        for(String word:words_map.keySet()){
            arr = words_map.get(word);
            curr_nbr_of_files = arr.size();
            if(curr_nbr_of_files>max_nbr_of_files){
                max_nbr_of_files = curr_nbr_of_files;
            }
        }
        return max_nbr_of_files;
    }

    private ArrayList<String>  wordsInNumFiles(int nbr){
        ArrayList<String> output_array = new ArrayList<>();
        ArrayList<String> curr_arr = new ArrayList<>();;

        for(String word:words_map.keySet()){
            curr_arr = words_map.get(word);
            if(curr_arr.size()==nbr){
                output_array.add(word);
            }
        }
        return output_array;
    }

    public void tester(){
        buildWordsMapFromFiles();
        /*ArrayList<String> curr_values;
        int count = 0;
        int nbr_of_files = 4;
        for(String w:words_map.keySet()){
            curr_values = words_map.get(w);
            if(curr_values.size()==nbr_of_files){
                count += 1;
            }
        }

        System.out.println(count + " words were in " + nbr_of_files + " files.");*/
        ArrayList<String> files = words_map.get("tree");
        for(int i=0;i<files.size();i++){
            System.out.println(files.get(i));
        }


    }

}
