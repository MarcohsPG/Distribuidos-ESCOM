import java.util.Scanner;

public class Ej10 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("PROGRAMA QUE SUMA TODOS LOS NUMERO HASTA LLEGAR AL NUMERO DADO\nProporcioname el numero: ");
        var numero = leerDatos.nextInt();
        var suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma=suma + i;
        }
        System.out.println("La suma de todos los digitos es: "+suma);
    }
}
