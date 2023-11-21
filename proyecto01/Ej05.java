import java.util.Scanner;

public class Ej05 {
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        System.out.println("PROGRAMA QUE ASIGNA DIAS DE VACACIONES A EMPLEADOS\n Proporcioname tus años de labor:");
        var años = leer.nextInt();
        if(años<=5){
            System.out.println("Dias de vacaciones proporcionados: 5");
        }else if(años>=6 &&años<=10){
            System.out.println("Dias de vacaciones proporcionados: 10");
        }else if(años>=10 && años <=19){
            System.out.println("Dias de vacaciones proporcionados: "+años);
        }else if(años >= 20 && años <= 43){
            System.out.println("Dias de vacaciones proporcionados: "+(años+2));
        }else{
            System.out.println("Dias de vacaciones proporcionados: 45");
        }
    }
}
