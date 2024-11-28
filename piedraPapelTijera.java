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

    // Declaramos estilo juego como una variable local para llamarla en un futuro
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
                } else {
                    bucleActivo = false;
                }
            } else {
                System.out.println("Error. Debes introducir un número de rondas");
                sc.next();
            }
        }

        System.out.println();
        System.out.println("Cargando partida...");
        System.out.println();
        System.out.println("¡Qué empiece!");
        return numeroRondas;
    }

    // Declaramos una variable global para almacenar el número de rondas que se
    // quieren jugar para utilizarlo más adelante
    static int numeroRondas = numeroRondas();

    static int eleccionOpcion() {
        Scanner sc = new Scanner(System.in);
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
                    System.out.println("No válido, solo puede ser 1,2 o 3.");
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

    static int eleccionOrdenador() {
        int eleccionOrdenador = ((int) (Math.random() * 3) + 1);

        return eleccionOrdenador;
    }

    static String traducirOpcion(int opcion) {
        switch (opcion) {
            case 1:
                return "¡¡Piedra!! \r\n" +
                        "    _______\r\n" +
                        "---'   ____)\r\n" +
                        "      (_____)\r\n" +
                        "      (_____)\r\n" +
                        "      (____)\r\n" +
                        "---.__(___)";
            case 2:
                return "¡¡Papel!! \r\n" +
                        "     _______ \r \n" +
                        "---'    ____)____\r \n" +
                        "           ______)\r \n" +
                        "          _______)\r \n" +
                        "         _______)\r \n" +
                        "---.__________)";
            case 3:
                return "¡¡Tijeras!! \r\n" +
                "_______ \r\n" +
                "---'   ____)____\r\n" +
                "          ______)\r\n" + 
                "       __________)\r\n" +
                "      (____)\r\n" +
                "---.__(___)\r\n";
            default:
                return "No deberías de ver esto.";
        }
    }
    static void enfrentamiento() {
        int victoriasJugador1 = 0;
        int victoriasJugador2 = 0;
        int numeroRondasPartida = numeroRondas;
        int estiloJuegoSeleccionado = estiloJuego;
        int eleccion2 = 0;

        // Tabla de la lógica.
        // 1- piedra
        // 2- papel
        // 3- Tijeras
        /*
         * Piedra le puede a tijeras (1 == 3)
         * Tijeras le puede a papel ( 3 == 2)
         * Papel le puede a piedra ( 2 == 1)
         * 
         * Compararemos la elección del usuario con el de la máquina (O otro usuario) y
         * si no lo cumple! entonces es porque ha perdido.
         */

        for (int i = 0; i < numeroRondasPartida; i++) { // Búcle hasta las veces que se haya la ronda
            int eleccionJugador = eleccionOpcion(); // Se asigna el numero que el jugador ha elegido al int
            if (estiloJuegoSeleccionado == 1) { // Contra ordenador.
                eleccion2 = eleccionOrdenador(); // Se asigna el numero que el ordenador ha elegido al int
            } else { // Contra jugador2
                eleccion2 = eleccionOpcion(); // Se asigna el numero que el jugador2 ha elegido al int
            }
            System.out.println(nombreJugadores[0] +" eligió: " + traducirOpcion(eleccionJugador));
            System.out.println(nombreJugadores[1] + " eligió: " + traducirOpcion(eleccion2));
            System.out.println();

            if (eleccion2 == eleccionJugador) {
                System.out.println("¡¡Empate!!");
                i--;
            } else if (eleccionJugador == 1 && eleccion2 == 3 || eleccionJugador == 3 && eleccion2 == 2
                    || eleccionJugador == 2 && eleccion2 == 1) {
                System.out.println("¡" +nombreJugadores[0] + " ganó la ronda!");
                victoriasJugador1++;
            } else {
                System.out.println("¡" +nombreJugadores[1] + " ganó la ronda!");
                victoriasJugador2++;
            }
            System.out.println();
            System.out.println("----Marcador----");
            System.out.println(nombreJugadores[0]+":" + victoriasJugador1);
            System.out.println(nombreJugadores[1]+":" + victoriasJugador2);
            System.out.println("----------------");
            System.out.println();
        
        }

        System.out.println("¡Fin de la partida! el ganador es...");
        if (victoriasJugador1 == 3) {
            System.out.println(nombreJugadores[0]);            
        } else {
            System.out.println(nombreJugadores[1]);
        }
        return;
    }

    public static void main(String[] args) {
        enfrentamiento();
    }
}