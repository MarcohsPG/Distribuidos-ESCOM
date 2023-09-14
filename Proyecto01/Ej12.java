public class Ej12 {
    public static void main(String[] args) {
        System.out.println("PROGRAMA QUE DETECTA LOS NUMEROS PERFECTOS ENTRE 1-10,000");
        System.out.println("Números perfectos entre 1 y 10,000:");
        for (int i = 1; i <= 10000; i++) {
            if (numeroPerfecto(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean numeroPerfecto(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    
    }
}
