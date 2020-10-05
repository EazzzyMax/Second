package com.who;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            File inName = new File(args[0]);  //вход
            System.out.println("in:    " + inName);
            String keyString = args[1];
            System.out.println("key:   " + keyString);
            File outName = new File(args[2]); //выход
            System.out.println("out:   " + outName);
            System.out.println("");


            if (!outName.exists()) //если выход не сделан то делаю
                outName.createNewFile();

            Scanner inScan = new Scanner(inName);
            String inTxt = "";

            while (inScan.hasNext()) { //весь текст в строчку
                inTxt += inScan.nextLine();
                if (inScan.hasNext()) inTxt += "\r\n";
            }

            System.out.println(inTxt);


            PrintWriter outTxt = new PrintWriter(outName); //тут буду писать

            byte[] txtByte = inTxt.getBytes();
            byte[] keyByte = keyString.getBytes();

            for (int i = 0; i < txtByte.length; i++) {
                txtByte[i] ^= keyByte[i % keyByte.length];
                System.out.println(new String(txtByte));
                System.out.println("___________");
            }
            outTxt.println(new String(txtByte));
            outTxt.close();


            System.out.println("");
            System.out.println("______________________________________________________");
            System.out.println("");


        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        if (args.length>3) {
            try {

                File inName = new File(args[2]);  //вход
                System.out.println("in:    " + inName);
                String keyString = args[1];
                System.out.println("key:   " + keyString);
                File outName = new File(args[3]); //выход
                System.out.println("out:   " + outName);
                System.out.println("");


                if (!outName.exists()) //если выход не сделан то делаю
                    outName.createNewFile();

                Scanner inScan = new Scanner(inName);
                String inTxt = "";

                while (inScan.hasNext()) { //весь текст в строчку
                    inTxt += inScan.nextLine();
                    if (inScan.hasNext()) inTxt += "\r\n";
                }

                System.out.println(inTxt);


                PrintWriter outTxt = new PrintWriter(outName); //тут буду писать

                byte[] txtByte = inTxt.getBytes();
                byte[] keyByte = keyString.getBytes();

                for (int i = 0; i < txtByte.length; i++) {
                    txtByte[i] ^= keyByte[i % keyByte.length];
                    System.out.println(new String(txtByte));
                    System.out.println("___________");
                }
                outTxt.println(new String(txtByte));
                outTxt.close();


                System.out.println("");
                System.out.println("______________________________________________________");
                System.out.println("");


            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("!!!!!!!!!!!!");

        System.out.println("end");
    }
}









