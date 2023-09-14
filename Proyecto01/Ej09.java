import java.util.Scanner;

public class Ej09 {
    public static void main(String[] args) {
        Scanner leerDatos = new Scanner(System.in);
        System.out.println("PROGRAMA QUE DETERMINA SI UN NUMERO ES CAPICUO\n Proporcioname el numero: ");
        var numero = leerDatos.nextLine();
        char[] numArray = numero.toCharArray();
        if(numArray.length==1){
            System.out.println("Es numero capicuo");
        }else if(numArray.length==2){
            if(numArray[0]%numArray[1]==0){
                System.out.println("Es numero capicuo");
            }else{
                System.out.println("NO es numero capicuo");
            }
        }else if(numArray.length==3){
            if(numArray[0]%numArray[2]==0){
                System.out.println("Es numero capicuo");
            }else{
                System.out.println("NO es numero capicuo");
            }
        }else if(numArray.length==4){
            if((numArray[0]%numArray[3]==0)&&(numArray[1]%numArray[2]==0)){
                System.out.println("Es numero capicuo");
            }else{
                System.out.println("NO es numero capicuo");
            }
        }else{
            System.out.println("No es numero capicuo");
        }
    }
}
