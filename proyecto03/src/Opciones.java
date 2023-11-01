/*Alumno: PUERTOS GOMEZ MARCOS
 * PROYECTO 03
 * Gupo: 4CM11
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Opciones {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        while (!salir) {
            System.out.println(
                    "OPCIONES PARA EL ANALISIS: \n 1) Mensajes totales por sexo hasta el momento \n 2) Mensajes por entidad federativa \n 3) Numero de ciudadanos por nivel educativo y sexo\n 4)SALIR");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Hombres: " + AnalisisDatos.TotalHombres());
                    System.out.println("Mujeres: " + AnalisisDatos.TotalMujeres());
                    break;
                case 2:
                    ArrayList<Integer> entidadesfinal = AnalisisDatos.Entidades();
                    System.out.println("AGUASCALIENTES  ---> " + entidadesfinal.get(0));
                    System.out.println("BAJA CALIFORNIA ---> " + entidadesfinal.get(1));
                    System.out.println("BAJA C. SUR     ---> " + entidadesfinal.get(2));
                    System.out.println("CAMPECHE        ---> " + entidadesfinal.get(3));
                    System.out.println("CHIAPAS         ---> " + entidadesfinal.get(4));
                    System.out.println("CHIHUAHUA       ---> " + entidadesfinal.get(5));
                    System.out.println("COAHUILA        ---> " + entidadesfinal.get(6));
                    System.out.println("COLIMA          ---> " + entidadesfinal.get(7));
                    System.out.println("CDMX            ---> " + entidadesfinal.get(8));
                    System.out.println("DURANGO         ---> " + entidadesfinal.get(9));
                    System.out.println("GUANAJUATO      ---> " + entidadesfinal.get(10));
                    System.out.println("GUERRERO        ---> " + entidadesfinal.get(11));
                    System.out.println("HIDALGO         ---> " + entidadesfinal.get(12));
                    System.out.println("JALISCO         ---> " + entidadesfinal.get(13));
                    System.out.println("MEXICO          ---> " + entidadesfinal.get(14));
                    System.out.println("MICHOACAN       ---> " + entidadesfinal.get(15));
                    System.out.println("MORELOS         ---> " + entidadesfinal.get(16));
                    System.out.println("NAYARIT         ---> " + entidadesfinal.get(17));
                    System.out.println("NUEVO LEON      ---> " + entidadesfinal.get(18));
                    System.out.println("OAXACA          ---> " + entidadesfinal.get(19));
                    System.out.println("PUEBLA          ---> " + entidadesfinal.get(20));
                    System.out.println("QUERETARO       ---> " + entidadesfinal.get(21));
                    System.out.println("QUINTANAROO     ---> " + entidadesfinal.get(22));
                    System.out.println("SAN LUIS POTOSI ---> " + entidadesfinal.get(23));
                    System.out.println("SINALOA         ---> " + entidadesfinal.get(24));
                    System.out.println("SONORA          ---> " + entidadesfinal.get(25));
                    System.out.println("TABASCO         ---> " + entidadesfinal.get(26));
                    System.out.println("TLAXCALA        ---> " + entidadesfinal.get(27));
                    System.out.println("TAMAULIPAS      ---> " + entidadesfinal.get(28));
                    System.out.println("VERACRUZ        ---> " + entidadesfinal.get(29));
                    System.out.println("YUCATAN         ---> " + entidadesfinal.get(30));
                    System.out.println("ZACATECAS       ---> " + entidadesfinal.get(31));

                    break;
                case 3:
                    System.out.println("¿QUE NIVEL EDUCATIVO DESEAS CONSULTAR?");
                    System.out.println(
                            "1)Preescolar\n2)Primaria\n3)Secundaria\n4)Preparatoria\n5)Universidad\n6)Maestria\n7)Doctorado");
                    int nivel = sc.nextInt();
                    if (nivel == 1) {
                        ArrayList<Integer> listPreescolar = AnalisisDatos.ClasificarPreescolarYSexo();
                        System.out.println("Total de ciudadanos con preescolar: " + listPreescolar.get(0));
                        System.out.println("Hombres con preescolar: " + listPreescolar.get(1));
                        System.out.println("Mujeres con preescolar: " + listPreescolar.get(2));
                    } else if (nivel == 2) {
                        ArrayList<Integer> listPrimaria = AnalisisDatos.ClasificarPrimariaYSexo();
                        System.out.println("Total de ciudadanos con primaria: " + listPrimaria.get(0));
                        System.out.println("Hombres con primaria: " + listPrimaria.get(1));
                        System.out.println("Mujeres con primaria: " + listPrimaria.get(2));
                    } else if (nivel == 3) {
                        ArrayList<Integer> listSecundaria = AnalisisDatos.ClasificarSecundariaYSexo();
                        System.out.println("Total de ciudadanos con secundaria: " + listSecundaria.get(0));
                        System.out.println("Hombres con secundaria: " + listSecundaria.get(1));
                        System.out.println("Mujeres con secundaria: " + listSecundaria.get(2));
                    } else if (nivel == 4) {
                        ArrayList<Integer> listPrepa = AnalisisDatos.ClasificarPrepaYSexo();
                        System.out.println("Total de ciudadanos con preparatoria: " + listPrepa.get(0));
                        System.out.println("Hombres con preparatoria: " + listPrepa.get(1));
                        System.out.println("Mujeres con preparatoria: " + listPrepa.get(2));
                    } else if (nivel == 5) {
                        ArrayList<Integer> listUni = AnalisisDatos.ClasificarUniYSexo();
                        System.out.println("Total de ciudadanos con universidad: " + listUni.get(0));
                        System.out.println("Hombres con universidad: " + listUni.get(1));
                        System.out.println("Mujeres con universidad: " + listUni.get(2));
                    } else if (nivel == 6) {
                        ArrayList<Integer> listMaestria = AnalisisDatos.ClasificarMestriaYSexo();
                        System.out.println("Total de ciudadanos con maestria: " + listMaestria.get(0));
                        System.out.println("Hombres con maestria: " + listMaestria.get(1));
                        System.out.println("Mujeres con maestria: " + listMaestria.get(2));
                    } else if (nivel == 7) {
                        ArrayList<Integer> listDoctorado = AnalisisDatos.ClasificarDoctoradoYSexo();
                        System.out.println("Total de ciudadanos con doctorado: " + listDoctorado.get(0));
                        System.out.println("Hombres con doctorado: " + listDoctorado.get(1));
                        System.out.println("Mujeres con doctorado: " + listDoctorado.get(2));
                    }
                    break;

                case (4):
                    salir=true;
                    break;
                default:
                    break;
            }
        }
    }
}
