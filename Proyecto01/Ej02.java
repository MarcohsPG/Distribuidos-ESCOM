import java.util.Scanner;

public class Ej02 {
    public static void main(String[] args) {
        System.out.println("MULTIPLICACION DE FRACCIONES\nSabiendo que la multiplicación de fracciones se representa de la siguiente forma:\n A/B * C/D = A*C / B*D \n");
        System.out.println("Proporcioname el valor de A: ");
        Scanner leerDatos = new Scanner(System.in);
        var numA = leerDatos.nextInt();
        
        System.out.println("Proporcioname el valor de B: ");
        var numB = leerDatos.nextInt();

        System.out.println("Proporcioname el valor de C: ");
        var numC = leerDatos.nextInt();

        System.out.println("Proporcioname el valor de D: ");
        var numD = leerDatos.nextInt();

        var resNumerador = (numA*numC);
        var resDenominador = (numB*numD);
        var resDecimal = resNumerador/resDenominador;

        System.out.println("El resultado de la multiplicación es: " + resNumerador + "/" + resDenominador+"\n En numero decimal es: " + resDecimal);
    }
}
