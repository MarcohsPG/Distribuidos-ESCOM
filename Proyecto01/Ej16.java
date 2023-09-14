import java.util.Scanner;

public class Ej16 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("PROGRAMA QUE CALCULA EL PROMEDIO DE TODOS LOS NUMERO INGRESADOS HASTA INGRESAR CERO");
        var numero=0;
        var suma=0;
        var i=0;
        do {
            System.out.println("Dame un numero: ");
            numero=leerDatos.nextInt();
            suma = suma + numero;
            i++;
        } while (numero!=0);
        var promedio = suma/(i-1);
        System.out.println("El promedio de todos los numero leidos es: "+promedio);
    }
}
