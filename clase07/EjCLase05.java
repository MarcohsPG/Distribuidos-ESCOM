package clase07;

public class EjCLase05 {
    public static void main(String[] args) {
        
        int numero = Integer.parseInt(args[0]);
        char[] cadenota = new char[numero*4];
        int cont = 0;
        // char letra1 = (char)(Math.random()*(26)+65);
        for (int i = 0; i < (numero*4); i+=4) {
            cadenota[ i ] = (char)(Math.random()*(26)+65);
            cadenota[ i+1 ] = (char)(Math.random()*(26)+65);
            cadenota[ i+2 ] = (char)(Math.random()*(26)+65);
            cadenota[ i+3 ] = ' ';
            if( cadenota[ i ] == 'I' ){
                if( cadenota[ i+1 ] == 'P' ){
                    if( cadenota[ i+2 ] == 'N' ) {
                        cont++;
                    }
                }
            }
        }
        System.out.println( "Apariciones de IPN: " + cont );

     }
    
}
