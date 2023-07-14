import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
       Scanner consola = new Scanner(System.in);
        // definimos la lista fuera del ciclo while
       List<Persona> personas = new ArrayList<>();

       //Menú
        var salir = false;
        while(!salir){
            mostrarMenu();
            try {
            salir = ejecutarOperacion(consola, personas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }
        private static void mostrarMenu(){
            //Mostramos las opciones
            System.out.println("""
                    **** Listado Personas APP ****
                    1. Agregar
                    2. Listar
                    3. Salir
                    """);
            System.out.print("Proporciona la opcion: ");
        }
        private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
            var opcion = Integer.parseInt(consola.nextLine().trim());
            var salir = false;
            // Revisamos la opcion proporcionada
            switch(opcion){
                case 1 -> { // Agregar persona a la lista
                    System.out.println("Proporciona el nombre: ");
                    var nombre = consola.nextLine().trim();
                    System.out.println("Proporciona el teléfono");
                    var telefono = consola.nextLine().trim();
                    System.out.println("Proporciona el email");
                    var email = consola.nextLine().trim();
                    // Crear el objeto Persona
                    var persona = new Persona(nombre, telefono, email);
                    // Lo agregamos a la lista
                    personas.add(persona);
                    System.out.println("La lista tiene: "+ personas.size() +" elementos" );
                }
                case 2 ->{ //Listar perosnas
                    System.out.println("Listado de personas: ");
                    // Mejora usando lamda y método de referencia
                    //personas.forEach((persona) -> System.out.println(persona));
                    // usando metodos de referencia mejorado
                    personas.forEach(System.out::println);
                }
                case 3->{
                    System.out.println("Hasta pronto ... ✋");
                    salir = true;
                }
                default -> System.out.println("Opcion erronea ->" + opcion);
            }// fin switch
            return salir;
        }



}