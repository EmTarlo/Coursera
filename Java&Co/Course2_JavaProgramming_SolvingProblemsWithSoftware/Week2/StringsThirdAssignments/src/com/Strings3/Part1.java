package com.Strings3;

import edu.duke.FileResource;
import edu.duke.StorageResource;

import java.util.Locale;

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

        String gene = "Not a gene";

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
                if(temp!="Not a gene"){
                    count++;
                }
                System.out.println(temp);
                startIdx = dna.indexOf("ATG",startIdx+3);

            }
        }

        System.out.println("\n"+count+" genes were found.");

    }

    public StorageResource getAllGenes(String dna){

        StorageResource sr = new StorageResource();

        int startIdx = dna.indexOf("ATG");
        String temp;
        int idx=0;
        int count=0;

        while(true) {

            if (startIdx == -1) {
                break;
            }else{
                temp = findGene(dna,startIdx);
                if(temp!="Not a gene"){
                    sr.add(temp);
                    count++;
                }
                startIdx = dna.indexOf("ATG",startIdx+3);

            }
        }

        /*System.out.println("\n"+count+" genes were found:");

        for(String s:sr.data()){
            System.out.println("\n"+s);
        }*/
        return sr;
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


    public float cgRatio(String dnaOrGene){

        int c = howMany("C",dnaOrGene);
        int g = howMany("G",dnaOrGene);
        int cg = c + g;
        float ratio = (float) cg/dnaOrGene.length();
        return ratio;

    }

    public int countCTG(String dnaOrGene){

        int hm = howMany("CTG",dnaOrGene);
        return hm;

    }

    public void processGenes(StorageResource sr){

        int ltnine=0;
        int cgratioht=0;
        int longGeneLength=0;
        int countGenes = 0;

        for(String s : sr.data()){

            countGenes++;

            if(s.length()>60){
                ltnine++;
            }

            if(cgRatio(s)>0.35){
                cgratioht++;
            }

            if(s.length()>longGeneLength){
                longGeneLength=s.length();
            }
        }

        System.out.println("\n"+countGenes+" genes were found in total.");
        System.out.println("\n"+ltnine+" strings were found with length > 60. ");

        for(String s : sr.data()) {
            if (s.length() > 60) {
                System.out.println("\n" + s);
                ;
            }
        }

        System.out.println("\n"+cgratioht+" strings were found with cg ratio > 0.35. ");

        for(String s : sr.data()) {
            if (cgRatio(s) > 0.35) {
                System.out.println("\n" + s);
            }
        }

        System.out.println("\nThe longest gene found was " + longGeneLength + " characters long.");


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

        FileResource fr = new FileResource("C:\\Users\\Francesco\\Desktop\\Coursera\\StringsThirdAssignments\\src\\com\\Strings3\\DNA_Example.txt");
        String dna = fr.asString();
        int hm = howMany("CTG",dna);
        System.out.println("\n"+hm);


    }

    public void testGetAllGenes(){

        //            012345678901234567890123456789  lenght=30
        //String dna = "GCAATGCCCGCATAAATGTGAGACTAGATGGAC";
        //               V        V  V  V        V
        //1st gene: ATGCCCGCATAA
        //2nd gene: ATGTGA

        FileResource fr = new FileResource("C:\\Users\\Francesco\\Desktop\\Coursera\\StringsThirdAssignments\\src\\com\\Strings3\\DNA_Example.txt");
        String dna = fr.asString();
        StorageResource sr = getAllGenes(dna);

        System.out.println("\nFollowing genes were found:");

        for(String s:sr.data()){
            System.out.println("\n"+s);
        }

    }

    public void testCGratio(){
        String t1 = "CGCG";
        float r = cgRatio(t1);
        System.out.println(r);
    }

    public void testProcessGenes(){
        FileResource fr = new FileResource("C:\\Users\\Francesco\\Desktop\\Coursera\\StringsThirdAssignments\\src\\com\\Strings3\\GRch38dnapart.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        processGenes(getAllGenes(dna));

    }

}
