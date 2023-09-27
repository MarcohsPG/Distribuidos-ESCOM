package clase07;
public class EjClase06{

    public static void main(String[] args) {
        
        int numero = Integer.parseInt(args[0]);
        StringBuilder cadenota = new StringBuilder();
        for (int i = 0; i < numero*4; i++) {
            if (i%4==0) {
                cadenota.append(' ');
            }else{
                cadenota.append((char)(Math.random()*(26)+65));
            }
        }
        int contador = 0;
        int indice = cadenota.indexOf("IPN");
        while (indice!=-1) {
            contador++;
            indice = cadenota.indexOf("IPN", indice + 1);
            }
        
        System.out.println("Se encontró "+contador+" veces");
    }   
}
