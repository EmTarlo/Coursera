package com.Week2;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String,Integer> cod_map;

    public CodonCount(){
        cod_map = new HashMap<>();
    }


    private void addToMap(String s){
        int curr_value;

        if(cod_map.containsKey(s)){
            curr_value = cod_map.get(s);
            cod_map.put(s,curr_value+1);
        }else{
            cod_map.put(s,1);
        }


    }

    private void buildCodonMap(int start, String dna){
        String s;
        int beg, end;
        while(true){
            beg = start;
            end = start + 2;
            if((end+1)>dna.length()){
                break;
            }else{
                s = dna.substring(beg,end+1);
                addToMap(s);
                start = end+1;
            }
       }
    }


    private String getMostCommonCodon(){
        int comm_cod_counts = 0;
        String comm_cod = " ";
        for(String s:cod_map.keySet()){
            if(cod_map.get(s)>comm_cod_counts){
                comm_cod_counts = cod_map.get(s);
                comm_cod = s;

            }
        }
        return comm_cod;
    }


    private void print_codon_counts(){
        for(String s:cod_map.keySet()){
            System.out.println(s+" "+cod_map.get(s));
        }
    }


    private void print_codon_counts_between(int a, int b) {
        for (String s : cod_map.keySet()) {
            if (cod_map.get(s) >= a && cod_map.get(s) <= b) {
                System.out.println(s + " " + cod_map.get(s));
            }
        }
    }


    public void tester(){
        cod_map.clear();
        String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
        buildCodonMap(0,dna);
        print_codon_counts();
        System.out.println("\n" + cod_map.size()+" unique codons were found.");
        System.out.println("\nMost common codon: "+getMostCommonCodon());

    }
}
