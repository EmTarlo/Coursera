package com.Strings;

public class Part3 {

    public String twoOccurences(String stringa, String stringb){
        String check="false";
        int count=-1,index=0, temp=0;

        while(temp!=-1){
            temp = stringb.indexOf(stringa,index);
            index = temp+1;
            count++;
            }

        if(count>=2){
            check="true";
        }

        System.out.println("\n"+ "'" + stringa + "'" + " is contained " + count + " times in " + "'" + stringb + "'" );
        return check;

        }

        public String lastPart(String stringa, String stringb){
        String lastPart = stringb;
        int startIdx = stringb.indexOf(stringa);
        if(startIdx!=-1) {
            int endIdx = startIdx + stringa.length();
            lastPart = stringb.substring(endIdx);
        }
        return lastPart;

        }

    public void testP3(){

        System.out.println("\n**********Test1************");
        String stringa = "an";
        String stringb = "banana";
        System.out.println("\n" + "The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa,stringb));


        System.out.println("\n**********Test2************");
        stringa = "zoo";
        stringb = "forest";
        System.out.println("\n" + "The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa,stringb));


        System.out.println("\n**********Test3************");
        stringa = "Francesco";
        stringb = "Francesco Burchielli";
        System.out.println("\n" + "The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa,stringb));


    }
}
