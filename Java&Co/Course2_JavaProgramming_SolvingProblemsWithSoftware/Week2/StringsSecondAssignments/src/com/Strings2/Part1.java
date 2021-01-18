package com.Strings2;

public class Part1 {

    public int findStopCodon(String dna, int startIdx,String stopCod){

    int stopIdx;

    while(true){

        int temp = dna.indexOf(stopCod, startIdx);
        if (temp == -1) {
            stopIdx = -1;
            break;
        }else{
            if ((temp - (startIdx + 3)) % 3 == 0) {
                stopIdx = temp;
                break;
            }else{
                startIdx = temp+3;
            }
        }
    }


    if(stopIdx==-1){
        return dna.length();
    }

    return stopIdx;

    }

    public String findGene(String dna, int startIdx){

        String gene = "No gene";

        int taa_idx = findStopCodon(dna,startIdx,"TAA");
        int tga_idx = findStopCodon(dna,startIdx,"TGA");
        int tag_idx = findStopCodon(dna,startIdx,"TAG");
        int min_idx = Math.min(taa_idx,Math.min(tag_idx,tga_idx));

        if (min_idx!=dna.length()){
            gene = dna.substring(startIdx,min_idx+3);
        }

        return gene;
    }

    public void printAllGenes(){

        //            012345678901234567890123456789  lenght=30
        String dna = "GCAATGCCCGCATAAATGTGAGACTAGATGGAC";
        //               V        V  V  V        V
        //1st gene: ATGCCCGCATAA
        //2nd gene: ATGTGA

        int startIdx = dna.indexOf("ATG");
        String temp;
        int idx=0;
        int count=0;

        while(true) {

            if (startIdx == -1) {
                break;
            }else{
                temp = findGene(dna,startIdx);
                if(temp!="No gene"){
                    count++;
                }
                System.out.println(temp);
                startIdx = dna.indexOf("ATG",startIdx+3);

            }
        }

        System.out.println("\n"+count+" genes were found.");

    }





    public int howMany(String stringa, String stringb){

        int count = 0;
        int idx = 0;
        int len = stringb.length();


        while(idx<len){

            if(stringb.indexOf(stringa,idx)==-1){
                break;
            }else{
                count++;
                idx = stringb.indexOf(stringa,idx)+stringa.length();
            }

        }
    return count;

    }


    public void testFindStopCodon(){

        System.out.println("-------------Test 1----------------");
        //            V     V   V     V
        String dna1 = "ATGGCATAGAATGCAATAA";
        //            0123456789012345678
        System.out.println("\n"+dna1);
        System.out.println("\n"+findStopCodon(dna1,0,"TAG"));


        System.out.println("-------------Test 2----------------");
        String dna2 = "ATGGCATAATAG";
        //             012345678901
        System.out.println("\n"+dna2);
        System.out.println("\n"+findStopCodon(dna2,0,"TGA"));

    }

    public void testFindGene(){

        System.out.println("-------------Test 1----------------");
        //                V   V    V  V
        String dna1 = "AAGATGATAAAGTAGTAA";
        //             0123456789012345678   length = 19
        System.out.println("\n"+dna1);
        //System.out.println("\nGene found: " + findGene(dna1));

    }

    public void testHowMany(){

        System.out.println("\n-------------Test 1----------------");
        String t1 = "BBAAAAABBBB";
        int hmt1 = howMany("BB",t1);
        System.out.println("\nString BB was found " + hmt1 + " times in string "+t1);

        System.out.println("\n-------------Test 2----------------");
        String t2 = "AAAAAAAA";
        int hmt2 = howMany("BB",t2);
        System.out.println("\nString BB was found " + hmt2 + " times in string "+t2);

        System.out.println("\n-------------Test 3----------------");
        String t3 = "AAAABBAAAA";
        int hmt3 = howMany("BB",t3);
        System.out.println("\nString BB was found " + hmt3 + " times in string "+t3);


    }
}
