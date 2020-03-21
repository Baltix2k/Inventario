package vista;

import java.util.Scanner;

public class Teclado {
    
    /**
     * Este método lee una entrada en teclado de tipo entero
     * @return int Regresa el numero entero ingresado
     **/
    public int leerEntero(){
        int entero = 0;
        Scanner sc = new Scanner(System.in);
        try{
            entero = sc.nextInt();
        }catch(Exception e){
            System.out.println("Error al leer el dato");
        }
        return entero;
    }
    
    /**
     * Este método lee una entrada en teclado de tipo cadena
     * @return String Regresa la cadena ingresada
     **/
    public String leerCadena(){
        String cadena = "";
        Scanner sc = new Scanner(System.in);
        try{
            cadena = sc.nextLine();
        }catch(Exception e){
            System.out.println("Error al leer el dato");
        }
        return cadena;
    }
    
    
    /**
     * Este método lee una entrada en teclado de tipo flotante
     * @return float Regresa el numero flotante ingresado
     **/
    public float leerFlotante(){
        float flotante = 0;
        Scanner sc = new Scanner(System.in);
        try{
            flotante = sc.nextFloat();
        }catch(Exception e){
            System.out.println("Error al leer el dato");
        }
        return flotante;
    }
    
}
