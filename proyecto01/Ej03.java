import java.util.Scanner;

public class Ej03 {
    public static void main(String[] args) {
        System.out.println("Programa que calcula el radio de una circunferencia inscrita en un triangulo, dadas las dimensiones de todos sus lados");
        System.out.println("Ingresa las medidas de sus lados en el siguiente orden(Hipotenusa,cateto,cateto): ");
        Scanner lados = new Scanner(System.in);
        var ladoHipotenusa = lados.nextFloat();
        var ladoCateto01 = lados.nextFloat();
        var ladoCateto02 = lados.nextFloat();
        var mitad = ladoHipotenusa/2;
        var altura = Math.sqrt((Math.pow(ladoCateto01, 2))-(Math.pow(mitad, 2)));
        var area = (ladoHipotenusa*altura)/2;
        var perimetro = ladoCateto01 + ladoCateto02 +ladoHipotenusa;
        var resultadoRadio = ((2*area)/ perimetro);
        System.out.println("El radio de la circunferencia inscrita es: " + resultadoRadio);
    }
}
