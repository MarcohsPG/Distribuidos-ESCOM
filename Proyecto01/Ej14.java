import java.util.Scanner;

public class Ej14 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("Proporcioname el numero donde inicia la serie: ");
        var numX = leerDatos.nextInt();
        System.out.println("Proporcioname el numero multiplo: ");
        var numY = leerDatos.nextInt();
        while (numX<=200) {
            System.out.println(numX+" ");
            numX=numX+numY;           
        }
    }
}
