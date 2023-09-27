import java.util.Random;

public class PoligonoIrreg {
    private Coordenada[] vertices;
    private int numVertices;
    public PoligonoIrreg(int capacidad) {
        vertices = new Coordenada[capacidad];
        numVertices = 0;
    }
    public void anadeVertice(Coordenada vertice) {
        if (numVertices < vertices.length) {
            vertices[numVertices] = vertice;
            numVertices++;
        } else {
            System.out.println("No se pueden agregar más vértices. Capacidad máxima alcanzada.");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vértices del polígono irregular:\n");
        for (int i = 0; i < numVertices; i++) {
            sb.append(vertices[i].toString()).append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        PoligonoIrreg poligono = new PoligonoIrreg(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            double x = random.nextDouble() * 20 - 10; // Coordenadas aleatorias en el rango [-10, 10]
            double y = random.nextDouble() * 20 - 10;
            Coordenada vertice = new Coordenada(x, y);
            poligono.anadeVertice(vertice);
            System.out.println("Vértice " + (i + 1) + ": " + vertice.toString());
        }
        System.out.println("\n" + poligono.toString());
    }
}
