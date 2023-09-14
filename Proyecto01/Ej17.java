import java.util.Scanner;

public class Ej17 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("PROGRAMA QUE INVIERTE EL ORDEN DE 10 NUMEROS INGRESADOS");
        int numeros[] = new int[10];
        for (int i = 9; i >= 0; i--) {
            System.out.println("Ingresa un numero: ");
            numeros[i]=leerDatos.nextInt();
        }
        System.out.println("ORDEN INVERSO");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        
    }
}
