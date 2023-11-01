/*Alumno: PUERTOS GOMEZ MARCOS
 * PROYECTO 03
 * Gupo: 4CM11
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        String nStr = args[0];
        int n = Integer.parseInt(nStr);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("Registros.txt", true);

            while (true) {
                for (int i = 0; i < n; i++) {
                    String curp = getCURP();
                    String numero = getNumero();
                    String estudios= getEstudios();
                    String registro= curp +","+numero+","+estudios;
                    fileWriter.write(registro + "\n");
                }
                fileWriter.flush(); // Forzar la escritura inmediata en el archivo

                // Esperar n segundos
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static String getCURP() {
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String Numero = "0123456789";

        String Sexo = "HM";

        String Entidad[] = { "AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT", "GR", "HG", "JC", "MC",
                "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TL", "TS", "VZ", "YN", "ZS" };
        int indice;
        // Asigna las primeras 5 letras
        StringBuilder sb = new StringBuilder(18);
        for (int i = 1; i < 5; i++) {
            indice = (int) (Letra.length() * Math.random());
            sb.append(Letra.charAt(indice));
        }
        // Asigna fecha de nacimiento
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


static String getNumero(){
    Random random = new Random();
        StringBuilder numeroAleatorio = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int digito = random.nextInt(10); // Genera un dígito aleatorio entre 0 y 9
            numeroAleatorio.append(digito);
        }

        String numeroAleatorioStr = numeroAleatorio.toString();        
        return numeroAleatorioStr;
    }


static String getEstudios(){
    Random random = new Random();
        
        // Definir un array con los 5 valores distintos
        String[] valores = {"PREESCOLAR", "PRIMARIA", "SECUNDARIA", "PREPARATORIA", "UNIVERSIDAD","MAESTRIA","DOCTORADO"};

        // Generar un número aleatorio entre 0 y 4 (inclusivo)
        int indiceAleatorio = random.nextInt(7);

        // Asignar el valor aleatorio
        String valorAleatorio = valores[indiceAleatorio];
        return valorAleatorio;
    }
}