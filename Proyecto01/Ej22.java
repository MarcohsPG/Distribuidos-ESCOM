import java.util.Scanner;

public class Ej22 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);

        System.out.print("Ingrese el número de filas de la primera matriz: ");
        int filasA = leerDatos.nextInt();

        System.out.print("Ingrese el número de columnas de la primera matriz: ");
        int columnasA = leerDatos.nextInt();

        System.out.print("Ingrese el número de filas de la segunda matriz: ");
        int filasB = leerDatos.nextInt();

        System.out.print("Ingrese el número de columnas de la segunda matriz: ");
        int columnasB = leerDatos.nextInt();

        if (columnasA != filasB) {
            System.out.println("No es posible multiplicar estas matrices. El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz.");
            leerDatos.close();
            return;
        }

        int[][] matrizA = new int[filasA][columnasA];
        int[][] matrizB = new int[filasB][columnasB];

        System.out.println("Ingrese los valores de la primera matriz:");
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasA; j++) {
                System.out.print("Ingrese el valor para [" + i + "][" + j + "]: ");
                matrizA[i][j] = leerDatos.nextInt();
            }
        }

        System.out.println("Ingrese los valores de la segunda matriz:");
        for (int i = 0; i < filasB; i++) {
            for (int j = 0; j < columnasB; j++) {
                System.out.print("Ingrese el valor para [" + i + "][" + j + "]: ");
                matrizB[i][j] = leerDatos.nextInt();
            }
        }

        leerDatos.close();

        int[][] resultado = multiplicarMatrices(matrizA, matrizB);

        System.out.println("Resultado de la multiplicación de matrices:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;

        int[][] resultado = new int[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }
}

