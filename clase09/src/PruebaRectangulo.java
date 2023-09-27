public class PruebaRectangulo {

    public static void main (String[] args) {

        

        Rectangulo rect1 = new Rectangulo(2,3,5,1);

        double ancho, alto;
        
        Coordenada c1= new Coordenada(2, 3);
        Coordenada c2 = new Coordenada(5, 1);
        
        Rectangulo rect2 = new Rectangulo(c1, c2);
        
        System.out.println("Calculando el área de un rectángulo dadas sus coordenadas en un plano cartesiano:");

        System.out.println(rect1);
    
        alto = rect1.superiorIzquierda().ordenada() - rect1.inferiorDerecha().ordenada();

        ancho = rect1.inferiorDerecha().abcisa() - rect1.superiorIzquierda().abcisa();

        System.out.println("El área del rectángulo es = " + ancho*alto);

        //
        System.out.println("Calculando el área de un rectángulo dadas sus coordenadas en un plano cartesiano:");

        System.out.println(rect1);

        alto = rect1.superiorIzquierda().ordenada() - rect1.inferiorDerecha().ordenada();

        ancho = rect1.inferiorDerecha().abcisa() - rect1.superiorIzquierda().abcisa();

        System.out.println("El área del rectángulo es = " + ancho*alto);

    }

}
