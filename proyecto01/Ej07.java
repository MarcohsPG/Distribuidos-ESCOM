import java.util.Scanner;

public class Ej07 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("Proporcioname el tipo de contrato Hogar/Negocio: ");
        var contrato = leerDatos.nextLine();
        System.out.println("PROGRAMA QUE CALCULA EL COBRO DE LUZ\nProporcioname el numero de kW consumidos: ");
        var kW = leerDatos.nextInt();

        if (contrato.equals("Hogar")) {
            if(kW >= 0 && kW<=250){
                var cobro = kW*0.65;
                System.out.println("Pago por la cantidad de: $"+cobro);
            }
            else if(kW >= 251 && kW<=500){
                var cobro = (250*0.65)+((kW-250)*0.85);
                System.out.println("Pago por la cantidad de: $"+cobro);
            }
            else if(kW >= 501 && kW<=1200){
                var cobro = (250*0.65)+(250*0.85)+((kW-500)*1.50);
                System.out.println("Pago por la cantidad de: $"+cobro);
            }
            else if(kW >= 1201 && kW<=2100){
                var cobro = (250*0.65)+(250*0.85)+(700*1.50)+((kW-1200)*2.50);
                System.out.println("Pago por la cantidad de: $"+cobro);
            }else{
                var cobro = (250*0.65)+(250*0.85)+(700*1.50)+(900*2.50)+((kW-2100)*3.0);
                System.out.println("Pago por la cantidad de: $"+cobro);
            }
        } else if(contrato.equals("Negocio")){
            var cobro = kW * 5.0;
            System.out.println("Pago por la cantidad de: $"+cobro);
        }else{
            System.out.println("Error en el tipo de contrato");
        }
    }
}
