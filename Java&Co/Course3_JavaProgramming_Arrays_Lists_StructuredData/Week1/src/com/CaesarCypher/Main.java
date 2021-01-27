package com.CaesarCypher;

import edu.duke.FileResource;

public class Main {

    public static void main(String[] args) {
        /*com.CaesarCypher.WordLengths wl = new com.CaesarCypher.WordLengths();
        wl.testCountWordLengths();*/


        com.CaesarCypher.Encryption_Methods em = new com.CaesarCypher.Encryption_Methods();
        //FileResource fr = new FileResource();
        //String str = fr.asString();

        String dec_msg = em.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",26-2,26-20);
        System.out.println("\n"+dec_msg);

    }
}
