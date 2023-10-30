public class Rectangulo {

    private Coordenada superiorIzq;// se crea objeto de tipo Coordenada
    private Coordenada inferiorDer;// se crea objeto de tipo Coordenada

    //constructores

    public Rectangulo(double xSupIzq, double ySupIzq, double xInfDer, double yInfDer){

        this.superiorIzq = new Coordenada(xSupIzq, ySupIzq);

        this.inferiorDer = new Coordenada(xInfDer, yInfDer);        

    }

    public Rectangulo(Coordenada c1, Coordenada c2){
        this.superiorIzq=c1;
        this.inferiorDer=c2;
    }
    
    //Metodo getter de la coordenada superior izquierda

    public Coordenada superiorIzquierda( ) { return superiorIzq; }

 

    //Metodo getter de la coordenada inferior derecha

    public Coordenada inferiorDerecha( ) { return inferiorDer; }

    

    //Sobreescritura del método de la superclase objeto para imprimir con System.out.println( )

    @Override

    public String toString( ) {

        return "Esquina superior izquierda: " + superiorIzq + "\tEsquina superior derecha:" + inferiorDer + "\n";

    }

}
