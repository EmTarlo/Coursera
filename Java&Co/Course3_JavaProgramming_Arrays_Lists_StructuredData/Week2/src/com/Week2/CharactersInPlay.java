package com.Week2;

import edu.duke.FileResource;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class CharactersInPlay {

    private ArrayList<String> Characters;
    private ArrayList<Integer> Char_Count;

    public CharactersInPlay(){
        Characters = new ArrayList<>();
        Char_Count = new ArrayList<>();
    }


    private void update(String person){
        int idx;
        Integer curr_c;

        if(Characters.size()==0){
            Characters.add(person);
            Char_Count.add(1);
        }else{
            if(Characters.contains(person)){
                idx = Characters.indexOf(person);
                curr_c = Char_Count.get(idx);
                Char_Count.set(idx,curr_c+1);

            }else{
                Characters.add(person);
                Char_Count.add(1);
            }
        }
    }

    public void findAllCharacters(){
        int idx_of_dot;
        String person;

        Characters.clear();
        Char_Count.clear();

        FileResource fr = new FileResource();
        for(String line:fr.lines()){
            if(line.contains(".")){
                idx_of_dot = line.indexOf(".");
                person = line.substring(0,idx_of_dot);
                update(person);
            }
        }
    }

    public void charactersWithNumParts(int num1, int num2){
        String ch;
        Integer count;

        for(int i=0;i<Characters.size();i++){
            ch = Characters.get(i);
            count = Char_Count.get(i);
            if(count>=num1 && count<=num2){
                System.out.println(ch+" "+count);
            }
        }

    }

    public void tester(){

        String ch;
        Integer count;

        findAllCharacters();


        for(int i=0;i<Characters.size();i++){
            ch = Characters.get(i);
            count = Char_Count.get(i);
            if(count>30){
                System.out.println(ch+" "+count);
            }
        }

        System.out.println(" ");
        System.out.println("Testing charactersWithNumParts: ");
        charactersWithNumParts(10,15);
    }
}
