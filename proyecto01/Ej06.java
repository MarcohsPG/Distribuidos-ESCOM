import java.util.Scanner;

public class Ej06 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("PROGRAMA QUE CALCULA EL COBRO DE CASETA\n 1 EJE --> MOTOCICLETA\n2 EJES --> AUTOMOVIL\n3 EJES --> CAMIONETA\n4 a 6 EJES --> CARGA \nMAS DE 6 EJES --> TRAILER");
        System.out.println("Proporcioname el numero de ejes: ");
        var ejes = leerDatos.nextInt();
        switch (ejes) {
            case 1:
                System.out.println("Pago de caseta: $20");
                break;
            case 2:
                System.out.println("Pago de caseta: $40");
                break;
            case 3:
                System.out.println("Pago de caseta: $60");
                break;
            case 4: case 5: case 6:
                System.out.println("Pago de caseta: $250");
                break;
            default:
                System.out.println("Pago de caseta: "+(((ejes-6)*50)+250));
                break;
        }
    }   
}
