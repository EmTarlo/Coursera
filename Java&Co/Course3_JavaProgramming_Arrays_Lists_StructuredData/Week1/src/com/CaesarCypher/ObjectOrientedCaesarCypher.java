package com.CaesarCypher;

public class ObjectOrientedCaesarCypher {
    private String alpha;
    private String ALPHA;
    private String shift_alpha;
    private String SHIFT_ALPHA;
    private int mainKey;

    public ObjectOrientedCaesarCypher(int key){
        alpha = "abcdefghijklmnopqrstuvwxyz";
        ALPHA = alpha.toUpperCase();
        shift_alpha = alpha.substring(key) + alpha.substring(0,key);
        SHIFT_ALPHA = shift_alpha.toUpperCase();
        mainKey = key;
    }

    public String encrypt(String msg){

        StringBuilder new_msg = new StringBuilder(msg);

        for(int i=0;i<new_msg.length();i++){

            char curr_char = new_msg.charAt(i);
            int idx = alpha.indexOf(curr_char);
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
        ObjectOrientedCaesarCypher cc = new ObjectOrientedCaesarCypher(26-mainKey);
        String dec_msg = cc.encrypt(msg);
        return dec_msg;

    }





}
