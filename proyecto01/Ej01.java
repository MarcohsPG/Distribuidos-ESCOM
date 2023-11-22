import java.util.Scanner;

public class Ej01{
    public static void main(String[] args) {
        var centigrados=0.0;
        var fahrenheit=0.0;
        System.out.println("**Programa que convierte grados Centigrados a Fahrenheit** \nCantidad en grados que quieres convertir: ");
        Scanner numCentigrados = new Scanner(System.in);
        centigrados = Float.parseFloat(numCentigrados.nextLine());
        fahrenheit=(centigrados*9/5)+32;
        System.out.println(centigrados+" grados centigrados equivalen a "+fahrenheit+" grados fahrenheit.");
    }
}