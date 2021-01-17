package com.Strings;

public class Part1 {
    public String findSimpleGene(String DNA){
        String geneStr="";
        int startIdx = DNA.indexOf("ATG");
        if (startIdx==-1){
            return "Not a valid gene";
        }
        int endIdx = DNA.indexOf("TAA");
        if (endIdx==-1){
            return "Not a valid gene";
        }
        if(endIdx>=(startIdx+3)) {
            int geneCheck = (endIdx - (startIdx + 3)) % 3;
            if (geneCheck == 0) {
                geneStr = DNA.substring(startIdx, endIdx + 3);
            }
        }
        System.out.println("\nATG starts at: " + startIdx + " and TAA starts at: " + endIdx);
        return geneStr;


    }


    public void testSimpleGeneP1(){

        System.out.println("\n**********Test1************");
        String DNA1 = "AATTA";
        System.out.println("\n"+DNA1);
        String test1 = findSimpleGene(DNA1);
        System.out.println("\n"+test1);


        System.out.println("\n**********Test2************");
        String DNA2 = "ATGTTAGAGTAA";
        System.out.println("\n"+DNA2);
        String test2 = findSimpleGene(DNA2);
        System.out.println("\n"+test2);


        System.out.println("\n**********Test3************");
        String DNA3 = "TTATGGGTTAATGA";
        System.out.println("\n"+DNA3);
        String test3 = findSimpleGene(DNA3);
        System.out.println("\n"+test3);


        System.out.println("\n**********Test4************");
        String DNA4 = "AGTATG";
        System.out.println("\n"+DNA4);
        String test4 = findSimpleGene(DNA4);
        System.out.println("\n"+test4);


        System.out.println("\n**********Test5************");
        String DNA5 = "AGTTAAAGT";
        System.out.println("\n"+DNA5);
        String test5 = findSimpleGene(DNA5);
        System.out.println("\n"+test5);

    }

}