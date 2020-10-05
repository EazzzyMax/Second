package com.who;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

import java.nio.file.Files;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        try {

            File in = new File(args[0]);  //вход
            System.out.println("in:    " + in);
            String key = args[1];
            System.out.println("key:   " + key);
            File out = new File(args[2]); //выход
            System.out.println("out:   " + out);
            System.out.println("");




            if (!out.exists()) //если выход не сделан то делаю
                out.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(in)); //отсюда буду читать
            PrintWriter outTxt = new PrintWriter(out); //тут буду писать

            String line;
            byte[] txtByte;
            byte[] keyByte;

            System.out.println(br.read());
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                txtByte = line.getBytes();
                keyByte = key.getBytes();

                for (int i = 0; i < line.length(); i++) {
                    txtByte[i] ^= keyByte[i % key.length()];
                    System.out.println(new String(txtByte));
                    System.out.println(txtByte[i]);
                    System.out.println(".");

                }
                System.out.println("___________");
                outTxt.println(new String(txtByte));


            }
            outTxt.close();


        } catch (IOException e) {
            System.out.println("Error: " + e);
        }


        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("!!!!!!!!!!!!");
//        if (false) {
//            String txt = args[0];
//            String key = args[1];
//
//            byte[] txtByte = txt.getBytes();
//            byte[] keyByte = key.getBytes();
//
//            for (int i = 0; i < txt.length(); i++) {
//                txtByte[i] ^= keyByte[i % key.length()];
//                System.out.println(new String(txtByte));
//            }
//            System.out.println("__________");
//
//            for (int i = 0; i < txt.length(); i++) {
//                txtByte[i] ^= keyByte[i % key.length()];
//                System.out.println(new String(txtByte));
//            }
//
//        } else System.out.println("пососи");

        System.out.println("end");
    }
}









