package com.who;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) { //     0     1      2     3      4
//                                                -c/-d  key  in.txt  -o   out.name
        try {

            boolean format = true;


            //легальность
            if (args.length != 3 && args.length != 5) {   //3 или 5 аргументов
                format = false;
            } else if (!args[0].equals("-c") && !args[0].equals("-d")) { //первый аргумент -d/-с (шифрация / дешифрация)
                format = false;
            } else if (args[1].length() % 2 == 1) {    //не целое количество байт в ключе
                format = false;
            } else if (args.length == 5 && !args[3].equals("-o")) {      //четвертый аргумент должен быть -o (после него ожидается путь к out файлу)
                format = false;
            }//легальность end
            // !!!дописать regex для key!!!


            String inName = args[2];  //имя входного файла


            //определение имени out файла
            File outName;
            if (args.length == 5 && args[3].equals("-o")) {
                outName = new File(args[4]);
            } else {
                outName = new File(inName + "Out");
            }//определение имени out файла enf


            if (format) {
                if (args[0].equals("-c")) System.out.println("Шифрация файла " + inName + " начата.");
                if (args[0].equals("-d")) System.out.println("Дешифрация файла " + inName + " начата.");

                if (!outName.exists()) //делаю файл out если такого нет
                    outName.createNewFile();


                //создание ключа
                String keyString = args[1];
                int[] keyByte = new int[keyString.length() / 2]; //в байт. виде ключ
                for (int i = 0; i < keyString.length() / 2; i++) {
                    keyByte[i] = (byte) Integer.parseInt(keyString.substring(i * 2, i * 2 + 2), 16);
                }


                System.out.println("Key:  " + keyString + " " + Arrays.toString(keyByte));


                byte[] txtByte = Files.readAllBytes(Paths.get(inName));   //в байт. виде текст
                byte[] txtByteOut = new byte[txtByte.length];

                for (int i = 0; i < txtByte.length; i++) {  //старт кодирования
                    txtByteOut[i] = (byte) (txtByte[i] ^ keyByte[i % keyByte.length]);
                }



                PrintWriter outTxt = new PrintWriter(outName); //тут запишу.
                outTxt.println(new String(txtByteOut));           //записал.
                outTxt.close();                                //закрыл.
                System.out.println("Новый файл находится по следующему адресу: " + outName);

                //следующая проблемма решена, но пока код не доведен до совершенства, отладочный код остается

                //при расшифровке зашифрованного файла (при условии что в ключе есть значения больше чем 7f(16) = 127(10)
                //файл создается в utf-16. Как можно принудительно его записывать в utf-8?
                //
                //если производить шифроку и СРАЗУ дешифровку (без записи в файл), то все проходит успешно



                //дешифровка без записи в файл
                byte[] txtByteOutDecoded = new byte[txtByteOut.length];
                for (int i = 0; i < txtByte.length; i++) {  //старт ДЕкодирования
                    txtByteOutDecoded[i] = (byte) (txtByteOut[i] ^ keyByte[i % keyByte.length]);
                }

                String outNameDecoded = "C:\\o\\outAutoDecoded.txt";
                PrintWriter outTxtDecoded = new PrintWriter(outNameDecoded);        //тут запишу.
                outTxtDecoded.println(new String(txtByteOutDecoded));               //записал.
                outTxtDecoded.close();                                              //закрыл.
                System.out.println("АутоДекодед файл находится по следующему адресу: " + outNameDecoded);


            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }








    }
}





