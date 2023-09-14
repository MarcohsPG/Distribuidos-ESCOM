import java.util.Scanner;

public class Ej20 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);

        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese un número: ");
            numeros[i] = leerDatos.nextInt();
        }
        leerDatos.close();
        int temp = numeros[9]; 
        for (int i = 9; i > 0; i--) {
            numeros[i] = numeros[i - 1];
        }

        numeros[0] = temp; 
        System.out.println("Arreglo resultante después de mover una posición hacia adelante:");

        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}
