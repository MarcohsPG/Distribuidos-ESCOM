//Es necesario importar algunas librerias extra
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemoLambda {

    public static void main(String[] args) {

        //Creación de la lista 
        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno(1, "1717213183", "Javier Ignacio", "Molina Cano", "Java8", 7, 28));
        listaAlumnos.add(new Alumno(2, "1717456218", "Lillian Eugenia", "Gómez Álvarez", "Java8", 10, 33));
        listaAlumnos.add(new Alumno(3, "1717328901", "Sixto Naranjoe", "Marín", "Java 8", 8.6, 15));
        listaAlumnos.add(new Alumno(4, "1717567128", "Gerardo Emilio", "Duque Gutiérrez", "Java8", 10, 13));
        listaAlumnos.add(new Alumno(5, "1717902145", "Jhony Alberto", "Sáenz Hurtado", "Java8", 9.5, 15));
        listaAlumnos.add(new Alumno(6, "1717678456", "Germán Antonio", "Lotero Upegui", "Java8", 8, 34));
        listaAlumnos.add(new Alumno(7, "1102156732", "Oscar Darío", "Murillo González", "Java8", 8, 32));
        listaAlumnos.add(new Alumno(8, "1103421907", "Augusto Osorno", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Alumno(9, "1717297015", "César Oswaldo", "Alzate Agudelo", "Java8", 8, 26));
        listaAlumnos.add(new Alumno(10, "1717912056", "Gloria Amparo", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Alumno(11, "1717912058", "Jorge León", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Alumno(12, "1717912985", "John Jairo", "Duque García", "JavaScript", 9.4, 32));
        listaAlumnos.add(new Alumno(13, "1717913851", "Julio Cesar", "González Castaño", "CSharp", 10, 22));
        listaAlumnos.add(new Alumno(14, "1717986531", "Gloria Amparo", "Rodas Monsalve", "Ruby", 7, 18));
        listaAlumnos.add(new Alumno(15, "1717975232", "Gabriel Jaime", "Jiménez Gómez", "JavaScript", 10, 18));
        
        
        System.out.println("*** Lista de Alumnos ***");
        listaAlumnos.stream().forEach(a -> System.out.println(a));//Se recorre toda la lista con el foreach
        listaAlumnos.stream().filter(a -> true).forEach(a -> System.out.println(a));//Aqui se aplica un filtrado pero como la expresion devuelve true siempre se imprimen todoso los elementos
        
        System.out.println("\n*** Alumnos cuyo Apellido empiezan con el caracter L u G ***");
        listaAlumnos.stream().filter(c -> c.getApellidos().charAt(0) == 'L' || c.getApellidos().charAt(0) == 'G')
                .forEach(c -> System.out.println(c));
        
                System.out.println("\n**** Número de Alumnos ***");
        // número de elementos en la lista
        System.out.println(listaAlumnos.stream().count());//count cuenta los elementos del stream
        
        System.out.println("\n**** Alumnos con nota mayor a 9 y que sean del curso PHP ***");
        // alumnos con notas mayores a 9
        listaAlumnos.stream().filter(a -> a.getNota() > 9 && a.getNombreCurso().equals("PHP"))
                .forEach(p -> System.out.println(p));
        
        System.out.println("\n**** Imprimir los 2 primeros Alumnos de la lista ***");
        listaAlumnos.stream().limit(2).forEach(a -> System.out.println(a));
        
        System.out.println("\n**** Imprimir el alumno con menor edad ***");
        // minimo por edad
        System.out.println(listaAlumnos.stream().min((a1, a2) -> a1.getEdad() - a2.getEdad()));
        
        System.out.println("\n**** Imprimir el alumno con mayor edad ***");
        // maximo por edad
        System.out.println(listaAlumnos.stream().max((a1, a2) -> a1.getEdad() - a2.getEdad()));
        
        System.out.println("\n**** Encontrar el primer Alumno***");
        // encontrar el primer registro
        System.out.println(listaAlumnos.stream().findFirst());
        
        System.out.println("\n**** Alumnos en los que los nombres de los cursos (lenguajes) que terminan en t ***");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().endsWith("t")).forEach(System.out::println);
        
        System.out.println("\n**** Alumnos que tienen un curso en el que el nombre contienen la A ***");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a")).forEach(System.out::println);
        
        System.out.println("\n**** Alumnos en que su tamaño de su nombre es mayor a 10 caracteres***");
        listaAlumnos.stream().filter(a -> a.getNombres().length() > 10).forEach(System.out::println);
        // combinar predicados
        
        System.out.println("\n**** Combinación de predicados ***");
        Predicate<Alumno> empiezaConJ = a -> a.getNombreCurso().startsWith("P");
        Predicate<Alumno> longitud = a -> a.getNombreCurso().length() <= 6;


        // Obtiene los alumnos en los cuales el nombre del curso empieza con el
        // caracter 'P' y la longitud sea <= a 6
        listaAlumnos.stream().filter(empiezaConJ.and(longitud)).forEach(System.out::println);

        List<Alumno> nuevaLista = listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a"))
                .collect(Collectors.toList());
        nuevaLista.forEach(System.out::println);
    }
}
