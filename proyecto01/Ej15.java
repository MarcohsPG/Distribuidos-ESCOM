import java.util.Scanner;

public class Ej15 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("ADIVINA EL NUMERO");
        var numeroAleatorio = (int) (Math.random()*100);
        System.out.println("Ya tengo el numero, ¿List@?\n"+numeroAleatorio+"Dame el numero:");
        var numeroUsuario = leerDatos.nextInt();
        while (numeroAleatorio!=numeroUsuario) {
            System.out.println("Fallaste, intentalo de nuevo:");
            numeroUsuario = leerDatos.nextInt();
        }
        System.out.println("ADIVINASTE!!!!");
    }
}
