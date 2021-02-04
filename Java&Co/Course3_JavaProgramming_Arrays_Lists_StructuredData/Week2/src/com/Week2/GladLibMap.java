package com.Week2;

import edu.duke.FileResource;
import edu.duke.URLResource;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GladLibMap {

        private HashMap<String,ArrayList<String>> myMap;
        private ArrayList<String> wordsUsed;
        private ArrayList<String> categoriesUsed;



        private Random myRandom;

        private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
        private static String dataSourceDirectory = "C:\\Users\\Francesco\\Desktop\\Coursera\\Java&Co\\Course3_JavaProgramming_Arrays_Lists_StructuredData\\Week2\\Input_Files";

        public GladLibMap(){

            myRandom = new Random();
            myMap = new HashMap<>();
            wordsUsed = new ArrayList<>();
            categoriesUsed = new ArrayList<>();
            initializeFromSource(dataSourceDirectory);
        }

        private void initializeFromSource(String source) {

            String[] categories = {"adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
            ArrayList<String> values;
            for(int i=0;i<categories.length;i++){
                String cat = categories[i];
                values = readIt(source+"\\"+cat+".txt");
                myMap.put(cat,values);
            }
        }

        private String randomFrom(ArrayList<String> source){
            int index = myRandom.nextInt(source.size());
            return source.get(index);
        }

        private String getSubstitute(String label) {

            ArrayList<String> values;
            String str_sub;

            if(label.equals("number")){
                return ""+myRandom.nextInt(50)+5;
            }else if(myMap.containsKey(label)){
                    values = myMap.get(label);
                    str_sub = randomFrom(values);
                    if(!categoriesUsed.contains(label)){
                        categoriesUsed.add(label);
                    }
                    return str_sub;
            }else{
                return "**UNKNOWN**";
            }
        }

        private String processWord(String w){
            int first = w.indexOf("<");
            int last = w.indexOf(">",first);
            if (first == -1 || last == -1){
                return w;
            }
            String prefix = w.substring(0,first);
            String suffix = w.substring(last+1);
            String sub;

            while(true){
                sub = getSubstitute(w.substring(first+1,last));
                if(!wordsUsed.contains(sub)){
                    break;
                }
            }

            wordsUsed.add(sub);

            return prefix+sub+suffix;
        }

        private void printOut(String s, int lineWidth){
            int charsWritten = 0;
            for(String w : s.split("\\s+")){
                if (charsWritten + w.length() > lineWidth){
                    System.out.println();
                    charsWritten = 0;
                }
                System.out.print(w+" ");
                charsWritten += w.length() + 1;
            }
        }

        private String fromTemplate(String source){
            String story = "";
            if (source.startsWith("http")) {
                URLResource resource = new URLResource(source);
                for(String word : resource.words()){
                    story = story + processWord(word) + " ";
                }
            }
            else {
                FileResource resource = new FileResource(source);
                for(String word : resource.words()){
                    story = story + processWord(word) + " ";
                }
            }
            return story;
        }

        private ArrayList<String> readIt(String source){
            ArrayList<String> list = new ArrayList<String>();
            if (source.startsWith("http")) {
                URLResource resource = new URLResource(source);
                for(String line : resource.lines()){
                    list.add(line);
                }
            }
            else {
                FileResource resource = new FileResource(source);
                for(String line : resource.lines()){
                    list.add(line);
                }
            }
            return list;
        }

        private int totalWordsInMap(){
            int tot_count = 0;
            ArrayList<String> curr_values;

            for(String key:myMap.keySet()){
                curr_values = myMap.get(key);
                tot_count += curr_values.size();
            }

            return tot_count;
        }


        private int  totalWordsConsidered(){
            int tot_count = 0;
            String curr_cat;
            ArrayList<String> curr_values;

            for(int i=0; i<categoriesUsed.size();i++){
                curr_cat = categoriesUsed.get(i);
                curr_values = myMap.get(curr_cat);
                tot_count += curr_values.size();
            }

            return tot_count;
        }

        public void makeStory(){

            System.out.println("\n");
            String story = fromTemplate(dataSourceDirectory+"\\madtemplate2.txt");
            printOut(story, 60);
            System.out.println("\n\n" + wordsUsed.size() + " words were replaced in total.");
            System.out.println(totalWordsInMap()+" possible substitutes across " + myMap.size() +" categories were considered overall.");
            System.out.println(totalWordsConsidered()+" possible substitutes across "+ categoriesUsed.size() +" categories were actually considered.");


        }
}





