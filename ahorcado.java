import java.util.Scanner;

public class ahorcado {

static String menuEleccionPalabra() {
    Scanner sc = new Scanner(System.in);
    
    boolean bucleActivo = true;
    boolean hayPalabraSeleccionada = false; //Comprobamos si se puede acceder o no al menú 2.
    String palabraSeleccionada = "";
    int eleccionMenu = 0;

    while (bucleActivo) {

        // Mostramos el menú
        System.out.println("===== Juego del ahorcado =====");
        System.out.println("Elige una de las opciones");
        System.out.println("0. Palabra aleatoria.");
        System.out.println("1. Escribir palabra a adivinar.");
        System.out.println("2. Advinar palabra.");
        System.out.println("3. Salir.");

        // Se comprueba que el usuario ha puesto un número dentro de los parámetros
        if (sc.hasNextInt()) {
            eleccionMenu = sc.nextInt();
            if (eleccionMenu < 0 || eleccionMenu > 3) { // No acepta si es otro numero menor de 1 o mayor de 2
                System.out.println("No válido, solo puede introducir uno de los números del menú (0-1).");
            }
        } else {
            System.out.println("No válido, debe seleccionar un número.");
            sc.next();
        }

        // Una vez validado el número comprobamos que menú se va a utilizar
        switch (eleccionMenu) {
            case 0:
                palabraSeleccionada = palabraAleatoria();
                hayPalabraSeleccionada = true;
                break;
            case 1:
                palabraSeleccionada = introducirPalabra();
                hayPalabraSeleccionada = true;
                break;
            case 2:
                if (!hayPalabraSeleccionada) {
                    System.out.println("No tienes una palabra seleccionada. Debes utilizar la opción 0 o 1 para seleccionar una.");
                    break;
                }
            // case 3:
            //     return ;
        }
    }

    return palabraSeleccionada;
}

//En caso de elegir la opción "1" del menú permitimos nosotros al usuario escoger la palabra
static String introducirPalabra() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Dime una palabra para adivinar");
    String palabraElegidaUsuario = sc.nextLine();

    return palabraElegidaUsuario;
}

static String palabraElegidaUsuario = introducirPalabra(); //Guardamos la palabra del usuario

//En caso de elegir la opción "0" del menú asignamos nosotros la palabra
static String palabraAleatoria(){
    String [] palabrasAleatorias = {"gato", "libro", "mesa", "cielo", "flor", "zapato", "faro", "nube", "piedra", "camino"};

    String palabraAleatoria = palabrasAleatorias[((int) (Math.random()*10)-1)];

    return palabraAleatoria;
}

//Guardamos la palabra para comprobar si se ha introducido una o no

//Encaso de elegir la opción "2" primero debemos comprobar si hay una palabra seleccionada, si la hay mostrar la palabra con guiones
// static String adivinarPalabra() {

// }

// Censuramos la palabra con ---

static String censurarPalabra(){

    //Recibimos la palabra
            Scanner sc = new Scanner(System.in);
        System.out.println("Palabra:");
        String palabra = sc.nextLine();
        Character palabraDividida[] = new Character[palabra.length()];
        Character palabraCensurada[] = new Character[palabra.length()];

        // Llenar el array con guiones y mostrarlos
        for (int i = 0; i < palabra.length(); i++) {
            palabraCensurada[i] = '-';
            palabraDividida[i] = palabra.charAt(i);
            System.out.print(palabraCensurada[i]);
        }
        return ;
    }


//Necesito una variable para guardar la palabra o null y saber si está llena o no
    public static void main(String[] args) {
        menuEleccionPalabra();
    }   
}
