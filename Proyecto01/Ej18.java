import java.util.Scanner;

public class Ej18 {
    public static void main(String[] args) {
        Scanner leerDatos=new Scanner(System.in);
        String[] ciudades = new String[10];
        System.out.println("PROGRAMA QUE DETERMINA EL NOMBRE DE LA CIUDAD MAS LARGO");
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el nombre de la ciudad #" + (i + 1) + ": ");
            ciudades[i] = leerDatos.nextLine(); 
        }
        String ciudadMasLarga = ciudades[0];
        for (int i = 1; i < 10; i++) {
            if (ciudades[i].length() > ciudadMasLarga.length()) {
                ciudadMasLarga = ciudades[i];
            }
        }
        System.out.println("La ciudad con el nombre más largo es: " + ciudadMasLarga);
    }
}
