package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        


        System.out.println("client partito");
        Socket s = new Socket("localhost", 3000);

        System.out.println("il client si è collegato \n");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        Scanner scanner = new Scanner(System.in);
        String stringaRicevuta;
       

        do{
            System.out.println("Inserisci un numero \n");
            out.writeBytes(scanner.nextLine() + "\n");
            
            stringaRicevuta = in.readLine();

            switch(stringaRicevuta){
                case "<": 
                    System.out.println("Il numero digitato è troppo piccolo \n");
                    break;
                
                case ">":
                    System.out.println("Il numero digitato è troppo grande \n");
                    break;

                case "=":
                    System.out.println("valore corretto \n");
                    System.out.println("Hai indovinato in " + in.readLine() + " tenativi");
                    break;

                default:
                    System.out.println("Errore, ritentare con un numero minore di 100 e maggiore di 0");
            }
        }while(!stringaRicevuta.equals("="));
    }
}