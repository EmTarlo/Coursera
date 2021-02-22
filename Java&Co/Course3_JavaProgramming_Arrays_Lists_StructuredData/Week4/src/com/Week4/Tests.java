package com.Week4;

import edu.duke.FileResource;

import java.util.HashSet;

public class Tests {


    //Testing "sliceString" method

    public void testSliceString(){

        VigenereBreaker vb = new VigenereBreaker();

        System.out.println("\n-----------Test1-------------");
        System.out.println("testing: (\"abcdefghijklm\", 0, 3)");
        String ret_str = vb.sliceString("abcdefghijklm", 0, 3);
        if(ret_str.equals("adgjm")){
            System.out.println("Result: "+ret_str);
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        System.out.println("\n-----------Test2-------------");
        System.out.println("testing: (\"abcdefghijklm\", 1, 3)");
        ret_str = vb.sliceString("abcdefghijklm", 1, 3);
        if(ret_str.equals("behk")){
            System.out.println("Result: "+ret_str);
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        System.out.println("\n-----------Test3-------------");
        System.out.println("testing: (\"abcdefghijklm\", 2, 3)");
        ret_str = vb.sliceString("abcdefghijklm", 2, 3);
        if(ret_str.equals("cfil")){
            System.out.println("Result: "+ret_str);
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }


        System.out.println("\n-----------Test4-------------");
        System.out.println("testing: (\"abcdefghijklm\", 0, 4)");
        ret_str = vb.sliceString("abcdefghijklm", 0, 4);
        if(ret_str.equals("aeim")){
            System.out.println("Result: "+ret_str);
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }


        System.out.println("\n-----------Test5-------------");
        System.out.println("testing: (\"abcdefghijklm\", 1, 4)");
        ret_str = vb.sliceString("abcdefghijklm", 1, 4);
        if(ret_str.equals("bfj")){
            System.out.println("Result: "+ret_str);
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }

    public void testMostCommonCharIn(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        HashSet<String> dictionary = vb.readDictionary(fr);
        Character most_common_char_in_dict = vb.mostCommonCharIn(dictionary);
        System.out.println("\nMost common char in language: "+most_common_char_in_dict);
    }
}
