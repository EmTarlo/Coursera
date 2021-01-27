package com.CaesarCypher;

import edu.duke.FileResource;

public class WordLengths {


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

    public static int[] countWordLengths(String s, int[] counts){

        int i=0;

        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                int count=0;
                char ch2 = ch;
                while(Character.isLetter(ch2)||ch2=='\''||ch2=='-'){
                    count++;
                    i++;
                    ch2 = s.charAt(i);
                }
                counts[count]+=1;
            }else{
                i++;
            }
        }
        return counts;
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

    public void testCountWordLengths(){
        int[] in_counts = new int[31];
        int[] out_counts = new int[31];
        FileResource fr = new FileResource();
        String str = fr.asString();
        out_counts = countWordLengths(str,in_counts);

        for(int i=0;i<out_counts.length;i++){
            System.out.println("\n"+out_counts[i]+" words were found of length: "+i);
        }

        int idx_max = indexOfMax(out_counts);
        System.out.println("\nMost common word length: "+idx_max);

    }

    public void testCountLetters(){
            String s = "aaaaaaaaaa";
            int[] output = new int[26];
            output = countLetters(s);

            /*for(int i=0;i<output.length;i++){
                System.out.println("\n"+output[i]);
            }*/

            int idx_max =  indexOfMax(output);
            System.out.println("\n"+idx_max);


    }
}
