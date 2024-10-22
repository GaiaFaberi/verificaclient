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

        String scelta;

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        String stringaInviata;

        Scanner scanner = new Scanner(System.in);

        String stringaRicevuta;

        do{
            System.out.println("Inserisci un numero \n");
            scelta = scanner.nextLine();
            stringaRicevuta = in.readLine();
            switch(scelta){
                 
                

                case ">": 
                    System.out.println("numero troppo grande digitare di nuovo");
                    break;

                
                    case "<": 
                        System.out.println("numero troppo piccolo digitare di nuovo");
                        break;
                    
                        case "=": 

                            System.out.println("Digita la frase: ");
                            stringaInviata = scanner.nextLine();
                            out.writeBytes("R" + "\n");
                            if(in.readLine().equals("frase?")){
                                out.writeBytes(stringaInviata + "\n");
                                

                            }
                            break;
                        case "0":
                            out.writeBytes("!" + '\n');
                            break;
                        
                        default:
                           out.writeBytes(scelta + '\n'); 
                           if(in.readLine().equals("!!")){
                            System.out.println("Crisi di governo: Marracash ha fatto la piadina \n");
                           }
            }

        }while(!scelta.equals("0"));
    }
}