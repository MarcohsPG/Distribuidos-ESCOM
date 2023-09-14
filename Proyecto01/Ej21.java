import java.util.Scanner;

public class Ej21 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);

        int[][] arregloBidimensional = new int[5][5];

        System.out.println("Ingrese los elementos del arreglo bidimensional (5x5):");
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                System.out.print("Ingrese un valor para [" + fila + "][" + columna + "]: ");
                arregloBidimensional[fila][columna] = leerDatos.nextInt();
            }
        }

        leerDatos.close();

        int sumaTotal = 0;
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                sumaTotal += arregloBidimensional[fila][columna];
            }
        }
        System.out.println("La suma total de los elementos en el arreglo es: " + sumaTotal);
    }
}
