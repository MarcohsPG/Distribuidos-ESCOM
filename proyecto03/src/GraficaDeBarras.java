/*Alumno: PUERTOS GOMEZ MARCOS
 * PROYECTO 03
 * Gupo: 4CM11
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GraficaDeBarras extends JPanel {

    private List<Integer> datos; // Datos para las barras
    private List<String> etiquetas; // Etiquetas para cada dato en el eje X
    private String etiquetaEjeY; // Etiqueta del eje Y
    private int maxAltura; // Valor máximo para escalar las barras

    

    public GraficaDeBarras(List<Integer> datos, List<String> etiquetas, String etiquetaEjeY) {
        this.datos = datos;
        this.etiquetas = etiquetas;
        this.etiquetaEjeY = etiquetaEjeY;
        this.maxAltura = (datos.stream().max(Integer::compare).orElse(0))/5;        

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int anchoBarra = 50; // Ancho de cada barra
        int espacio = 70; // Espacio entre las barras
        int x = espacio + 50; // Posición inicial en X

        for (int i = 0; i < datos.size()-1; i++) {
            int valor = datos.get(i);
            int altoBarra = (int) ((double) valor / maxAltura * (getHeight()-30));
            g.setColor(Color.blue);
            g.fillRect(x, getHeight() - 30 - altoBarra, anchoBarra, altoBarra);
            g.setColor(Color.black);
            g.drawRect(x, getHeight() - 30 - altoBarra, anchoBarra, altoBarra);

            // Dibujar etiqueta en el eje X
            g.setColor(Color.black);
            g.drawString(etiquetas.get(i), x, getHeight() - 15); // Ajustar la posición de la etiqueta

            // Dibujar número en la parte superior de la barra
            g.drawString(Integer.toString(valor), x + anchoBarra / 2 - 10, getHeight() - altoBarra - 35);

            x += anchoBarra + espacio; // Actualizar la posición en X
            
        }   
        // Etiqueta del eje Y
            g.setColor(Color.black);
            g.drawString(etiquetaEjeY, 5, getHeight() / 2);     
    }

    public void Ejey(){
        etiquetaEjeY=datos.get(7).toString();
    }
    public void actualizarGrafica(){
        datos.clear();
                        datos.add(AnalisisDatos.ClasificarPreescolar());
                        datos.add(AnalisisDatos.ClasificarPrimaria());
                        datos.add(AnalisisDatos.ClasificarSecundaria());
                        datos.add(AnalisisDatos.ClasificarPrepa());
                        datos.add(AnalisisDatos.ClasificarUni());
                        datos.add(AnalisisDatos.ClasificarMaestria());
                        datos.add(AnalisisDatos.ClasificarDoctorado());
                        datos.add(AnalisisDatos.ObtenerTotal());
                        maxAltura=(datos.stream().max(Integer::compare).orElse(0))/5;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("ESTADISTICA DE NIVEL EDUCATIVO");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1000, 500);

                List<Integer> datos = new ArrayList<>();
                datos.add(AnalisisDatos.ClasificarPreescolar());
                datos.add(AnalisisDatos.ClasificarPrimaria());
                datos.add(AnalisisDatos.ClasificarSecundaria());
                datos.add(AnalisisDatos.ClasificarPrepa());
                datos.add(AnalisisDatos.ClasificarUni());
                datos.add(AnalisisDatos.ClasificarMaestria());
                datos.add(AnalisisDatos.ClasificarDoctorado());
                datos.add(AnalisisDatos.ObtenerTotal());


                List<String> etiquetas = new ArrayList<>();
                etiquetas.add("PREESCOLAR");
                etiquetas.add("PRIMARIA");
                etiquetas.add("SECUNDARIA");
                etiquetas.add("PREPARATORIA");
                etiquetas.add("UNIVERSIDAD");
                etiquetas.add("MAESTRIA");
                etiquetas.add("DOCTORADO");

                String etiquetaEjeY = datos.get(7).toString() ;

                GraficaDeBarras grafica = new GraficaDeBarras(datos, etiquetas, etiquetaEjeY);
                frame.add(grafica);

                frame.setVisible(true);

                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        grafica.actualizarGrafica();
                         // Actualizar el valor máximo
                        grafica.Ejey();
                        grafica.repaint();
                    }
                });
                timer.start();
            }
        });
    }
}
