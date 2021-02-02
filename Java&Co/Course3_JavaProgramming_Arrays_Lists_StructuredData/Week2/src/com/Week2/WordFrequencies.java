package com.Week2;

import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }

    public void findUnique(){
        int idx;
        Integer w_count;
        String w_lc;

        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String w:fr.words()){
            w_lc = w.toLowerCase();
            if(myWords.size()==0){
                myWords.add(w_lc);
                myFreqs.add(1);
            }else {
                if (myWords.contains(w_lc)) {
                    idx = myWords.indexOf(w_lc);
                    w_count = myFreqs.get(idx);
                    myFreqs.set(idx, w_count + 1);
                } else {
                    myWords.add(w_lc);
                    myFreqs.add(1);
                }
            }

        }
    }

    public int  findIndexOfMax(){
        int c = myFreqs.get(0);
        int curr_c;
        int idx_max=0;

        for(int i=1;i<myWords.size();i++){
            curr_c = myFreqs.get(i);
            if(curr_c>c){
                c = curr_c;
                idx_max = i;
            }
        }
        return idx_max;
    }


    public void  tester(){
        String word;
        Integer count;
        int idx_of_max;
        findUnique();
        int n_unique = myWords.size();
        idx_of_max = findIndexOfMax();
        String w_max_idx = myWords.get(idx_of_max);
        int max_count = myFreqs.get(idx_of_max);



        System.out.println("Number of unique words: "+n_unique);

        for(int i=0;i<myWords.size();i++){
            word = myWords.get(i);
            count = myFreqs.get(i);
            System.out.println(word+" has been found "+count+" times.");

        }

        System.out.println("The word that occurs most often and its count are: "+w_max_idx+" "+max_count);

    }

}
