package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;
import java.util.Scanner;

public class Exercise32 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce texto y pulsa enter.");
        printToFile(generateStringToSave(""));
    }

    public static String generateStringToSave(String string) {
        if(string== null || string.isEmpty()){
            return generateUserInputToSave();
        } else return string;
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        File path = new File("src/main/resources/data.txt");
        try{
            FileWriter fr = new FileWriter(path, false);
            BufferedWriter bw = new BufferedWriter(fr);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(string);
            pw.close();

        } catch (IOException e ) {
            throw new RuntimeException(e);
        }
    }


}
