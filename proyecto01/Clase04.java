public class Clase04 {
    public static void main(String[] args) {
        var numeroSig = 0;
        
        for (int i = 0; i <= 20; i++) {
           switch (i) {
            case 0:
                System.out.println(i);
                break;
            case 1:
                System.out.println(i);
                break;
            case 2:
                numeroSig = (i-1) + (i-1);
                System.out.println(i);
                break;    
            default:
                numeroSig = (i)+(i-2)+(i-1);
                System.out.println(numeroSig);
                break;
        } 
        }
    }
}
