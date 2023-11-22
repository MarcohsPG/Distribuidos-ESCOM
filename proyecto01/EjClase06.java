public class EjClase06 {

    public static void main(String[] args) {
        
        int numero = Integer.parseInt(args[0]);
        StringBuilder cadenota = new StringBuilder();
        for (int i = 0; i < numero*4; i++) {
            if (i%4==0) {
                cadenota.append(' ');
            }
            cadenota.append((char)(Math.random()*(26)+65));
        }
        System.out.println(cadenota);
    }
}