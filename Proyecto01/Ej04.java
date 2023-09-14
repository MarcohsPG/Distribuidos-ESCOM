import java.util.Scanner;

public class Ej04 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("PROGRAMA QUE ASIGNA DORMITORIOS DE ACUERDO AL SEXO Y EDAD");
        System.out.println("Ingrese sexo Hombre/Mujer: ");    
        var sexo = leer.nextLine();
        if(sexo.equals("Hombre")){
            System.out.println("Ingrese edad: ");    
            var edad = leer.nextInt();
            if (edad == 18) {
                System.out.println(sexo+","+edad+" años = Edificio A");
            }else if(edad > 18 && edad <23){
                System.out.println(sexo+","+edad+" años = Edificio C");
            }else if(edad>23){
                System.out.println(sexo+","+edad+" años = Edificio E1");
            }else{
                System.out.println("Menor de edad");
            }
        }
        else if(sexo.equals("Mujer")){
            System.out.println("Ingrese edad: ");    
            var edad = leer.nextInt();
            if (edad == 18) {
                System.out.println(sexo+","+edad+" años = Edificio B");
            }else if(edad > 18 && edad <23){
                System.out.println(sexo+","+edad+" años = Edificio D");
            }else if(edad > 23){
                System.out.println(sexo+","+edad+" años = Edificio E2");
            }else{
                System.out.println("Menor de edad");
            }
        }else{
            System.out.println("Error al ingresar sexo");
        }
    }
}
