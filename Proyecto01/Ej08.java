import java.util.Scanner;

public class Ej08 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("PROGRAMA QUE ORDENA 3 NUMEROS DE MAYOR A MENOR\n Proporcioname el primer numero: ");
        var numA = leerDatos.nextInt();
        System.out.println("Proporcioname el segundo numero: ");
        var numB = leerDatos.nextInt();
        System.out.println("Proporcioname el tercer numero: ");
        var numC = leerDatos.nextInt();
        if (numA > numB && numB > numC){
            System.out.println("El orden de mayor a menor es: "+numA+" "+numB+" "+numC);
        }else if(numA > numB && numB < numC && numC < numA){
            System.out.println("El orden de mayor a menor es: "+numA+" "+numC+" "+numB);
        }else if(numA < numB && numB > numC && numC > numA){
            System.out.println("El orden de mayor a menor es: "+numB+" "+numC+" "+numA);
        }else if(numA < numB && numB > numC && numA > numC){
            System.out.println("El orden de mayor a menor es: "+numB+" "+numA+" "+numC);
        }else if(numC > numB && numC > numA && numA > numB){
            System.out.println("El orden de mayor a menor es: "+numC+" "+numA+" "+numB);
        }else if(numC > numB && numC > numA && numA < numB){
            System.out.println("El orden de mayor a menor es: "+numC+" "+numB+" "+numA);
        }
    }
}
