import java.util.Scanner;

public class piedraPapelTijera {

    static int elegirEstiloJuego() {
        Scanner sc = new Scanner(System.in);
        boolean semaforo = true;
        int opcion = 0;

        while (semaforo == true) {
            // Se enseña el menú
            System.out.println("----------------------------");
            System.out.println("1. Jugador contra Ordenador.");
            System.out.println("2. Jugador contra Jugador.");
            System.out.println("----------------------------");

            // Se comprueba que el usuario ha puesto un número dentro de los parámetros
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 2) { // No acepta si es otro numero menor de 1 o mayor de 2
                    System.out.println("No válido, solo puede ser 1 o 2.");
                } else {
                    semaforo = false;
                }
            } else {
                System.out.println("No válido, debe de ser un número.");
                sc.next();
            }

        }
        return opcion;

    }
    //Declaramos estilo juego como una variable local para llamarla en un futuro
    static int estiloJuego = elegirEstiloJuego();

    // Método para añadir el nombre del jugador o jugadores

    static String[] elegirnombre() {
        Scanner sc = new Scanner(System.in);
        int estiloJuegoElegido = estiloJuego;

        System.out.println("Dime el nombre del primer usuario");
        String nombrePrimerJugador = sc.nextLine();
        String nombreSegundoJugador;

        // Comprobamos que estilo de juego se ha elegido en el menú
        if (estiloJuegoElegido == 1) {
            nombreSegundoJugador = "Ordenador";
        } else {
            System.out.println("Dime el nombre del segundo usuario");
            nombreSegundoJugador = sc.nextLine();
        }
        System.out.println("El jugador " + nombrePrimerJugador + " va a jugar contra " + nombreSegundoJugador);

        String[] nombresJugadores = { nombrePrimerJugador, nombreSegundoJugador };

        return nombresJugadores;
    }

    // Declaramos una variable global para almacenar el nombre de los jugadores y
    // poder utilizarla en un futuro
    static String[] nombreJugadores = elegirnombre();

    // Creamos un apartado para solicitar el número de rondas que se quieren jugar
    static int numeroRondas() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cuantas rondas queréis jugar");

        // Comprobamos que el valor introducido es un número
        boolean bucleActivo = true;

            while (bucleActivo == true) {
                if (sc.hasNextInt()) {
                    numeroRondas = sc.nextInt();
                    if (numeroRondas < 1) { // Comprobamos que el número de rondas sea mayor a 1
                        System.out.println("Número de rondas incorrecta, debéis jugar como mínimo 1 ronda.");
                    } else{
                        bucleActivo = false;
                    }
                } else {
                    System.out.println("Error. Debes introducir un número de rondas");
                    sc.next();
                }
            }

        return numeroRondas;
    }

    // Declaramos una variable global para almacenar el número de rondas que se
    // quieren jugar para utilizarlo más adelante
    static int numeroRondas = numeroRondas();

    static int eleccionOpcion(){ 
        Scanner sc = new Scanner (System.in);   
        boolean semaforo = true;
        int opcion = 0;
            while (semaforo == true) {
            // Se enseña el menú
            System.out.println("----------------------------");
            System.out.println("1.Piedra");
            System.out.println("2.Papel");
            System.out.println("3.Tijeras");
            System.out.println("----------------------------");

            // Se comprueba que el usuario ha puesto un número dentro de los parámetros
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 3) { // No acepta si es otro numero menor de 1 o mayor de 3
                    System.out.println("No válido, solo puede ser 1,2,3.");
                } else {
                    semaforo = false;
                }
            } else {
                System.out.println("No válido, debe de ser un número.");
                sc.next();
            }
        }

        return opcion;
    }

    static int eleccionOrdenador(){
        int eleccionOrdenador = ((int) (Math.random()*3)+1);

        return eleccionOrdenador;
    }

    static int enfrentamiento(){
        int victoriasJugador1 = 0;
        int victoriasJugador2 = 0;
        int numeroRondasPartida = numeroRondas;
        int estiloJuegoSeleccionado = estiloJuego;
    }

    public static void main(String[] args) {
        System.out.println(eleccionOpcion());
    }
}