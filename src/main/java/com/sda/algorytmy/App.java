package com.sda.algorytmy;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        String text;
        String text2;
        int dlugoscStringa =0;
        slownik slownik = new slownik();
        File plik = new File("C:\\Users\\Tomasz Turkiewicz\\kurs java Londyn\\programy\\javalon\\szyfr_Cezara\\src\\main\\java\\com\\sda\\algorytmy\\plik wejściowy.txt");
        try {
            Scanner sc = new Scanner(plik);
            text = sc.nextLine();
            dlugoscStringa=text.length();
            char[]listaWejsciowa = new char[dlugoscStringa];

            for(int i = 0; i<dlugoscStringa;i++){
                listaWejsciowa[i]=text.charAt(i);
            }

            char[]listaWyjsciowa = new char[dlugoscStringa];
                for (int i = 0; i<dlugoscStringa;i++){
                    listaWyjsciowa[i]=szyfrowanie(listaWejsciowa[i],slownik);
                }

            String zakodowany = new String(listaWyjsciowa);

            PrintWriter zapis = new PrintWriter("C:\\Users\\Tomasz Turkiewicz\\kurs java Londyn\\programy\\javalon\\szyfr_Cezara\\src\\main\\java\\com\\sda\\algorytmy\\plik zaszyfrowany.txt");
            zapis.println(zakodowany);
            zapis.close();

            for (int i=0;i<dlugoscStringa;i++){
                System.out.println(listaWyjsciowa[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File plik2 = new File("C:\\Users\\Tomasz Turkiewicz\\kurs java Londyn\\programy\\javalon\\szyfr_Cezara\\src\\main\\java\\com\\sda\\algorytmy\\plik zaszyfrowany.txt");
        try {
            Scanner sc = new Scanner(plik2);
            text2 = sc.nextLine();
            char[]listaWejsciowa2 = new char[dlugoscStringa];

            for(int i = 0; i<dlugoscStringa;i++){
                listaWejsciowa2[i]=text2.charAt(i);
            }

            char[]listaWyjsciowa2 = new char[dlugoscStringa];
            for (int i = 0; i<dlugoscStringa;i++){
                listaWyjsciowa2[i]=deszyfrowanie(listaWejsciowa2[i],slownik);
            }

            String odkodowany = new String(listaWyjsciowa2);

            PrintWriter zapis = new PrintWriter("C:\\Users\\Tomasz Turkiewicz\\kurs java Londyn\\programy\\javalon\\szyfr_Cezara\\src\\main\\java\\com\\sda\\algorytmy\\plik odszyfrowany.txt");
            zapis.println(odkodowany);
            zapis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i=0;i<dlugoscStringa;i++){

        }

    }

    public static char szyfrowanie (char znakWe, slownik slownik){
        int a =0;
        for (int i = 0; i<slownik.tablica.length;i++){
        if (slownik.tablica[i]==znakWe){
            a =((i+3)%85);

        }
        } return slownik.tablica[a];
    }

    public static char deszyfrowanie (char znakWe, slownik slownik){
        int a =0;
        for (int i = 0; i<slownik.tablica.length;i++){
            if (slownik.tablica[i]==znakWe){
               a=((i+82)%85);

            }
        }
        return slownik.tablica[a];
    }




}
