import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner leeDatos = new Scanner(System.in);

        int[] numeros = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese un número: ");
            numeros[i] = leeDatos.nextInt();
        }

        boolean ordenadosDescendente = true;
        for (int i = 1; i < 10; i++) {
            if (numeros[i] > numeros[i - 1]) {
                ordenadosDescendente = false;
                break; 
            }
        }
        if (ordenadosDescendente) {
            System.out.println("Los números están ordenados en forma descendente.");
        } else {
            System.out.println("Los números no están ordenados en forma descendente.");
        }
    }
}
