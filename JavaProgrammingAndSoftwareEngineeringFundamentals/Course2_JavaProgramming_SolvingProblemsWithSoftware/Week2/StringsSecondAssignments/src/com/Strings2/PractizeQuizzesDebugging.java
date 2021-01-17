package com.Strings2;

public class PractizeQuizzesDebugging {

    public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || (index+4)>input.length()) {
                break;
            }
            //System.out.println("\n Index before updating: "+index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+3);
            //System.out.println("\n Index after updating: "+index);
        }
    }
    public void test() {
        findAbc("abcabcabcabca"); //length 7, indices from 0 to 6
    }



}
