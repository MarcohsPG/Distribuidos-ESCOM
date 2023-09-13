package Clase07;

import java.util.Scanner;

public class EjCLase05 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("Programa que encuentra la palabra IPN en una cadena de palabras de 3 letras");
        System.out.println("NUmero de palabras a generar: ");
        var n = leerDatos.nextInt();
        leerDatos.close();

        char[] palabraAleatoria = new char[3];
        int numArrayCadenota = n*4;
        char[] cadenota = new char[numArrayCadenota];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
            int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97); 
            palabraAleatoria [j]= Character.toUpperCase((char)codigoAscii);
            }
            System.out.println(palabraAleatoria);
         }
         for (int k = 0; k < cadenota.length; k++) {
            for(int l = 0; l<3;l++){
                cadenota[k]=palabraAleatoria[l];
            }    
            }
            System.out.println(cadenota);
         //espacio 165

     }
    
}
