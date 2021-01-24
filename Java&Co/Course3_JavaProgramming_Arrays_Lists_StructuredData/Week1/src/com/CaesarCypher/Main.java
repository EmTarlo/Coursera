package com.CaesarCypher;

public class Main {

    public static void main(String[] args) {
        com.CaesarCypher.Encryption_Methods em = new com.CaesarCypher.Encryption_Methods();
        String result = em.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21);
        System.out.println("\n"+result);
    }
}
