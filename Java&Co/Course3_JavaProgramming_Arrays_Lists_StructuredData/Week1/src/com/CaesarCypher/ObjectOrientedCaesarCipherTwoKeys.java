package com.CaesarCypher;

public class ObjectOrientedCaesarCipherTwoKeys {
    private String alphabet;
    private String ALPHA;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;

    public ObjectOrientedCaesarCipherTwoKeys(int key1, int key2) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        ALPHA = alphabet.toUpperCase();
        shiftedAlphabet1 = alphabet.substring(key1) +  alphabet.substring(0,key1);
        shiftedAlphabet2 =  alphabet.substring(key2) +  alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;

    }

    public String encrypt(String msg){

        String shift_alpha, SHIFT_ALPHA;
        StringBuilder new_msg = new StringBuilder(msg);

        for(int i=0;i<new_msg.length();i++){

            if(i%2==0){
                shift_alpha = shiftedAlphabet1;
                SHIFT_ALPHA = shiftedAlphabet1.toUpperCase();
            }else{
                shift_alpha = shiftedAlphabet2;
                SHIFT_ALPHA = shiftedAlphabet2.toUpperCase();

            }

            char curr_char = new_msg.charAt(i);
            int idx = alphabet.indexOf(curr_char);
            if(idx!=-1){
                char new_char = shift_alpha.charAt(idx);
                new_msg.setCharAt(i,new_char);
            }else{
                int idx_upp = ALPHA.indexOf(curr_char);
                if(idx_upp!=-1){
                    char new_char = SHIFT_ALPHA.charAt(idx_upp);
                    new_msg.setCharAt(i,new_char);
                }
            }
        }

        String ret_msg = new String(new_msg);
        return ret_msg;

    }

    public String decrypt(String msg){
        ObjectOrientedCaesarCipherTwoKeys cc2 = new ObjectOrientedCaesarCipherTwoKeys(26-mainKey1,26-mainKey2);
        String dec_msg = cc2.encrypt(msg);
        return dec_msg;

    }



}
