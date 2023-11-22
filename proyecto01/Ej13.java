public class Ej13 {
    public static void main(String[] args) {
        System.out.println("PROGRAMA QUE CALCULA AHORRO DE 20 AÑOS");
        var saldo = 0;
        for (int i = 1; i <= 20; i++) {
            var intereses = saldo*0.05;
            saldo += 10000;
            saldo += intereses;
        }
        System.out.println("Los ahorros sumarian la cantidad de: $"+saldo);
    }
}
