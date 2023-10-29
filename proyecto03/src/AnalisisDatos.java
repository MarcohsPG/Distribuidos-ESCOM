import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalisisDatos {
    public static void main(String[] args) {

        /*
         * ArrayList<Integer> estadosArray = Entidades();
         * for (int elemento : estadosArray) {
         * System.out.println(elemento);
         * }
         */
        System.out.println(ClasificarPreescolar());

    }

    public static int ObtenerTotal() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        int count = 0;
        int total = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(","); // Suponiendo que los strings están separados por comas

                for (String str : strings) {
                    count++;
                }
            }

            reader.close();
            total = count / 3;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total;
    }

    public static int ClasificarPreescolar() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        String keywordToClassify = "PREESCOLAR"; // Palabra clave por la que deseas clasificar
        int total = 0;
        int countPreescolarMujeres = 0;
        int countPreescolarHombres = 0;
        Map<String, StringBuilder> classifiedLines = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(",");
                String genero = keywords[0].length() >= 12 ? Character.toString(keywords[0].charAt(10)) : "";
                for (String keyword : keywords) {
                    if (keyword.equals(keywordToClassify)&&genero.equalsIgnoreCase("M")) {
                        if (!classifiedLines.containsKey(keywordToClassify)) {
                            total++;
                        }else if (!classifiedLines.containsKey(keywordToClassify) && genero.equalsIgnoreCase("H")) {
                            total++;
                            countPreescolarHombres++;
                        }
                        
                    }
                    break;
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int ClasificarPrimaria() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        String keywordToClassify = "PRIMARIA"; // Palabra clave por la que deseas clasificar
        int total = 0;
        Map<String, StringBuilder> classifiedLines = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(",");

                for (String keyword : keywords) {
                    if (keyword.equals(keywordToClassify)) {
                        if (!classifiedLines.containsKey(keywordToClassify)) {
                            total++;
                        }
                        break;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int ClasificarSecundaria() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        String keywordToClassify = "SECUNDARIA"; // Palabra clave por la que deseas clasificar
        int total = 0;
        Map<String, StringBuilder> classifiedLines = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(",");

                for (String keyword : keywords) {
                    if (keyword.equals(keywordToClassify)) {
                        if (!classifiedLines.containsKey(keywordToClassify)) {
                            total++;
                        }
                        break;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int ClasificarPrepa() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        String keywordToClassify = "PREPARATORIA"; // Palabra clave por la que deseas clasificar
        int total = 0;
        Map<String, StringBuilder> classifiedLines = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(",");

                for (String keyword : keywords) {
                    if (keyword.equals(keywordToClassify)) {
                        if (!classifiedLines.containsKey(keywordToClassify)) {
                            total++;
                        }
                        break;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int ClasificarUni() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        String keywordToClassify = "UNIVERSIDAD"; // Palabra clave por la que deseas clasificar
        int total = 0;
        Map<String, StringBuilder> classifiedLines = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(",");

                for (String keyword : keywords) {
                    if (keyword.equals(keywordToClassify)) {
                        if (!classifiedLines.containsKey(keywordToClassify)) {
                            total++;
                        }
                        break;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int ClasificarMaestria() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        String keywordToClassify = "MAESTRIA"; // Palabra clave por la que deseas clasificar
        int total = 0;
        Map<String, StringBuilder> classifiedLines = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(",");

                for (String keyword : keywords) {
                    if (keyword.equals(keywordToClassify)) {
                        if (!classifiedLines.containsKey(keywordToClassify)) {
                            total++;
                        }
                        break;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int ClasificarDoctorado() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        String keywordToClassify = "DOCTORADO"; // Palabra clave por la que deseas clasificar
        int total = 0;
        Map<String, StringBuilder> classifiedLines = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keywords = line.split(",");

                for (String keyword : keywords) {
                    if (keyword.equals(keywordToClassify)) {
                        if (!classifiedLines.containsKey(keywordToClassify)) {
                            total++;
                        }
                        break;
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int TotalMujeres() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        int countMujeres = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length >= 3) {
                    String genero = datos[0].length() >= 12 ? Character.toString(datos[0].charAt(10)) : "";
                    if (genero.equalsIgnoreCase("M")) {
                        countMujeres++;
                    }
                }
            }

            reader.close();
            System.out.println("Total de Mujeres: " + countMujeres);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countMujeres;

    }

    public static int TotalHombres() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        int countHombres = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length >= 3) {
                    String genero = datos[0].length() >= 12 ? Character.toString(datos[0].charAt(10)) : "";
                    if (genero.equalsIgnoreCase("H")) {
                        countHombres++;
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countHombres;

    }

    public static ArrayList<Integer> Entidades() {
        String filePath = "Registros.txt"; // Reemplaza con la ruta de tu archivo
        ArrayList<Integer> estados = new ArrayList<>();
        int aguascalientes = 0;
        int bajaCalifornia = 0;
        int bajaCaliforniaSur = 0;
        int campeche = 0;
        int chiapas = 0;
        int chihuahua = 0;
        int ciudadDeMexico = 0;
        int coahuila = 0;
        int colima = 0;
        int durango = 0;
        int guanajuato = 0;
        int guerrero = 0;
        int hidalgo = 0;
        int jalisco = 0;
        int mexico = 0;
        int michoacan = 0;
        int morelos = 0;
        int nayarit = 0;
        int nuevoLeon = 0;
        int oaxaca = 0;
        int puebla = 0;
        int queretaro = 0;
        int quintanaRoo = 0;
        int sanLuisPotosi = 0;
        int sinaloa = 0;
        int sonora = 0;
        int tabasco = 0;
        int tamaulipas = 0;
        int tlaxcala = 0;
        int veracruz = 0;
        int yucatan = 0;
        int zacatecas = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length >= 3) {
                    String entidad1 = datos[0].length() >= 12 ? Character.toString(datos[0].charAt(11)) : "";
                    String entidad2 = datos[0].length() >= 12 ? Character.toString(datos[0].charAt(12)) : "";
                    if (entidad1.equalsIgnoreCase("A") && entidad2.equalsIgnoreCase("S")) {
                        aguascalientes++;
                    } else if (entidad1.equalsIgnoreCase("B") && entidad2.equalsIgnoreCase("C")) {
                        bajaCalifornia++;
                    } else if (entidad1.equalsIgnoreCase("B") && entidad2.equalsIgnoreCase("S")) {
                        bajaCaliforniaSur++;
                    } else if (entidad1.equalsIgnoreCase("C") && entidad2.equalsIgnoreCase("C")) {
                        campeche++;
                    } else if (entidad1.equalsIgnoreCase("C") && entidad2.equalsIgnoreCase("S")) {
                        chiapas++;
                    } else if (entidad1.equalsIgnoreCase("C") && entidad2.equalsIgnoreCase("H")) {
                        chihuahua++;
                    } else if (entidad1.equalsIgnoreCase("C") && entidad2.equalsIgnoreCase("L")) {
                        coahuila++;
                    } else if (entidad1.equalsIgnoreCase("C") && entidad2.equalsIgnoreCase("M")) {
                        colima++;
                    } else if (entidad1.equalsIgnoreCase("D") && entidad2.equalsIgnoreCase("F")) {
                        ciudadDeMexico++;
                    } else if (entidad1.equalsIgnoreCase("D") && entidad2.equalsIgnoreCase("G")) {
                        durango++;
                    } else if (entidad1.equalsIgnoreCase("G") && entidad2.equalsIgnoreCase("T")) {
                        guanajuato++;
                    } else if (entidad1.equalsIgnoreCase("G") && entidad2.equalsIgnoreCase("R")) {
                        guerrero++;
                    } else if (entidad1.equalsIgnoreCase("H") && entidad2.equalsIgnoreCase("G")) {
                        hidalgo++;
                    } else if (entidad1.equalsIgnoreCase("J") && entidad2.equalsIgnoreCase("C")) {
                        jalisco++;
                    } else if (entidad1.equalsIgnoreCase("M") && entidad2.equalsIgnoreCase("C")) {
                        mexico++;
                    } else if (entidad1.equalsIgnoreCase("M") && entidad2.equalsIgnoreCase("N")) {
                        michoacan++;
                    } else if (entidad1.equalsIgnoreCase("M") && entidad2.equalsIgnoreCase("S")) {
                        morelos++;
                    } else if (entidad1.equalsIgnoreCase("N") && entidad2.equalsIgnoreCase("T")) {
                        nayarit++;
                    } else if (entidad1.equalsIgnoreCase("N") && entidad2.equalsIgnoreCase("L")) {
                        nuevoLeon++;
                    } else if (entidad1.equalsIgnoreCase("O") && entidad2.equalsIgnoreCase("C")) {
                        oaxaca++;
                    } else if (entidad1.equalsIgnoreCase("P") && entidad2.equalsIgnoreCase("L")) {
                        puebla++;
                    } else if (entidad1.equalsIgnoreCase("Q") && entidad2.equalsIgnoreCase("T")) {
                        queretaro++;
                    } else if (entidad1.equalsIgnoreCase("Q") && entidad2.equalsIgnoreCase("R")) {
                        quintanaRoo++;
                    } else if (entidad1.equalsIgnoreCase("S") && entidad2.equalsIgnoreCase("P")) {
                        sanLuisPotosi++;
                    } else if (entidad1.equalsIgnoreCase("S") && entidad2.equalsIgnoreCase("L")) {
                        sinaloa++;
                    } else if (entidad1.equalsIgnoreCase("S") && entidad2.equalsIgnoreCase("R")) {
                        sonora++;
                    } else if (entidad1.equalsIgnoreCase("T") && entidad2.equalsIgnoreCase("C")) {
                        tabasco++;
                    } else if (entidad1.equalsIgnoreCase("T") && entidad2.equalsIgnoreCase("L")) {
                        tlaxcala++;
                    } else if (entidad1.equalsIgnoreCase("T") && entidad2.equalsIgnoreCase("S")) {
                        tamaulipas++;
                    } else if (entidad1.equalsIgnoreCase("V") && entidad2.equalsIgnoreCase("Z")) {
                        veracruz++;
                    } else if (entidad1.equalsIgnoreCase("Y") && entidad2.equalsIgnoreCase("N")) {
                        yucatan++;
                    } else if (entidad1.equalsIgnoreCase("Z") && entidad2.equalsIgnoreCase("S")) {
                        zacatecas++;
                    }
                }
            }

            estados.add(aguascalientes);
            estados.add(bajaCalifornia);
            estados.add(bajaCaliforniaSur);
            estados.add(campeche);
            estados.add(chiapas);
            estados.add(chihuahua);
            estados.add(coahuila);
            estados.add(colima);
            estados.add(ciudadDeMexico);
            estados.add(durango);
            estados.add(guanajuato);
            estados.add(guerrero);
            estados.add(hidalgo);
            estados.add(jalisco);
            estados.add(mexico);
            estados.add(michoacan);
            estados.add(morelos);
            estados.add(nayarit);
            estados.add(nuevoLeon);
            estados.add(oaxaca);
            estados.add(puebla);
            estados.add(queretaro);
            estados.add(quintanaRoo);
            estados.add(sanLuisPotosi);
            estados.add(sinaloa);
            estados.add(sonora);
            estados.add(tabasco);
            estados.add(tlaxcala);
            estados.add(tamaulipas);
            estados.add(veracruz);
            estados.add(yucatan);
            estados.add(zacatecas);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return estados;

    }

}
