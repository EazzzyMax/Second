package com.who;

public class Main {
    public static void main(String[] args) {
        System.out.println("!!!!!!!!!!!!");
        String txt = args[0];
        String key = args[1];

        byte[] txtByte = txt.getBytes();
        byte[] keyByte = key.getBytes();

        for (int i =0; i<txt.length(); i++) {
            txtByte[i] ^= keyByte[i%key.length()];
            System.out.println(new String(txtByte));
        }
        System.out.println("__________");

        for (int i =0; i<txt.length(); i++) {
            txtByte[i] ^= keyByte[i%key.length()];
            System.out.println(new String(txtByte));
        }

    }
}
