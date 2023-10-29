package clase13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Main
{
    static int num = 10;
    public static void main(String[] args)
    {
        ArrayList<String> curps = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Almacenar CURPs en el ArrayList
        for (int i = 0; i < num; i++) {
            String curp = getCURP();
            curps.add(curp);
        }

        // Mostrar todas las CURPs ingresadas
        System.out.println("Todas las CURPs ingresadas:");
        for (String c : curps) {
            System.out.println(c);
        }

        // Pedir al usuario que especifique el género a eliminar (Hombre o Mujer)
        System.out.print("Especifique el género a eliminar (H para hombre, M para mujer): ");
        char genero = scanner.next().charAt(0);

        // Utilizar un Iterator para eliminar CURPs según el género especificado
        Iterator<String> iterator = curps.iterator();
        while (iterator.hasNext()) {
            String curpActual = iterator.next();
            char generoActual = curpActual.charAt(10); 
            // La posición 11 contiene el género (H o M)
            if ((genero == 'H' && generoActual == 'H') || (genero == 'M' && generoActual == 'M')) {
                iterator.remove();
            }
        }

        // Mostrar el ArrayList filtrado
        System.out.println("CURPs después del filtrado:");
        for (String c : curps) {
            System.out.println(c);
        }

        scanner.close();
    }

    static String getCURP()
    {
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String Numero = "0123456789";

        String Sexo = "HM";

        String Entidad[] = { "AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC",
                "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS" };
        int indice;
        //Asigna las primeras 5 letras
        StringBuilder sb = new StringBuilder(18);
        for (int i = 1; i < 5; i++) {
            indice = (int) (Letra.length() * Math.random());
            sb.append(Letra.charAt(indice));
        }
        //Asigna fecha de nacimiento
        for (int i = 5; i < 11; i++) {
            indice = (int) (Numero.length() * Math.random());
            sb.append(Numero.charAt(indice));
        }

        indice = (int) (Sexo.length() * Math.random());
        sb.append(Sexo.charAt(indice));
        sb.append(Entidad[(int) (Math.random() * 32)]);
        for (int i = 14; i < 17; i++) {
            indice = (int) (Letra.length() * Math.random());
            sb.append(Letra.charAt(indice));
        }

        for (int i = 17; i < 19; i++) {
            indice = (int) (Numero.length() * Math.random());
            sb.append(Numero.charAt(indice));
        }

        return sb.toString();
    }
}
