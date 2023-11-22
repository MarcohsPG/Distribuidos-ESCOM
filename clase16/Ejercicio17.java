package clase16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio17 {
    public static void main(String[] args) {
        String archivo="./El_viejo_y_el_mar.txtls";
        Map<Character,Integer>mapaCaracteres=new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            int c;
            while ((c=br.read())!=-1) {
                char caracter=(char)c;
                if (Character.isLetterOrDigit(caracter)) {
                    mapaCaracteres.put(caracter, mapaCaracteres.getOrDefault(caracter, 0)+1);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Map.Entry<Character,Integer> entry : mapaCaracteres.entrySet()){
            System.out.println("Caracter: "+entry.getKey()+", Ocurrencias:"+entry.getValue());
        }
    }    
}