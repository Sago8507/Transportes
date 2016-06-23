package com.anncode.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Utilerias {
    
    private static Scanner s = new Scanner(System.in);
    
    public static String leerLinea(){
        String cad = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            cad = br.readLine();
        }catch(IOException ie){
            ie.printStackTrace();
        }
        return cad;
    }
    
    public static String leerCadena(){
        String cad = s.next();
        return cad;
    }
    
    public static int leerEntero(){
        int n = 0;
        boolean correcto = false;
        do{
            try{
                n = Integer.parseInt(s.next());
                correcto = true;
            }catch(NumberFormatException ex){
                System.out.println("Numero invalido, reintente");
            }
        }while (!correcto);
        return n;
    }
    
    public static double leerFlotante(){
        double n = 0;
        boolean correcto = false;
        do{
            try{
                n = Double.parseDouble(s.next()) ;
                correcto = true;
            }catch(NumberFormatException ex){
                System.out.println("Numero invalido, reintente");
            }
        }while (!correcto);
        return n;
    }
    
    
    public static String formatoValor(String valor, int size){
    	StringBuffer sb = new StringBuffer(valor);
    	for ( ; sb.length() < size ; )
    		sb.append(" ");
		return sb.toString();    	
    }
    
    public static String formatoValor(int valor, int size){
    	StringBuffer sb = new StringBuffer(Integer.toString(valor));
    	for ( ; sb.length() < size ; )
    		sb.append(" ");
		return sb.toString();    	
    }
    
    public static String formatoValor(double valor, int size){
    	StringBuffer sb = new StringBuffer(Double.toString(valor));
    	for ( ; sb.length() < size ; )
    		sb.append(" ");
		return sb.toString();    	
    }
}
