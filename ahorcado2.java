import java.util.Scanner;

public class ahorcado2 {

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
                if (!hayPalabraSeleccionada) { //Comprobamos si hay una palabra seleccionada para adivinar antes de salir del menú
                    System.out.println("No tienes una palabra seleccionada. Debes utilizar la opción 0 o 1 para seleccionar una.");
                    break;
                } else {
                    bucleActivo = false;
                    break;
                }
            case 3:
                System.out.println("Saliendo...");
                return "";
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

//En caso de elegir la opción "0" del menú asignamos nosotros la palabra
static String palabraAleatoria(){
    String [] palabrasAleatorias = {"gato", "libro", "mesa", "cielo", "flor", "zapato", "faro", "nube", "piedra", "camino"};

    String palabraAleatoria = palabrasAleatorias[(int) (Math.random() * palabrasAleatorias.length)];
    // String palabraAleatoria = palabrasAleatorias[((int) (Math.random()*10)-1)];

    return palabraAleatoria;
}

// Censuramos la palabra con ---

static void ahorcado(){

    //Recibimos la palabra
    Scanner sc = new Scanner(System.in);
    String palabra = menuEleccionPalabra();
    
    Character palabraDividida[] = new Character[palabra.length()];
    Character palabraCensurada[] = new Character[palabra.length()];
    Character[] palabrasFallidas = new Character[10];
    int acierto = palabraCensurada.length;
    int fallos = 0;


    // Llenar el array con guiones y mostrarlos
    for (int i = 0; i < palabra.length(); i++) {
        palabraCensurada[i] = '-';
        palabraDividida[i] = palabra.charAt(i);
        if (Character.isWhitespace(palabraDividida[i])) {
            palabraCensurada[i] = ' ';
        }
        
    }
    if (!palabra.isEmpty()) { //Comparamos si le hemos pasado o no palabra para finalizar el juego
        System.out.println("Palabra:");
    while (fallos < 10) {
            if (acierto == 0) {
            System.out.println("¡Felicidades, acertaste!");
            System.out.println("¿Quieres jugar otra vez? (S/N)");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("S")) {
            ahorcado();
            } else {
            System.out.println("Gracias por jugar.");
            }
            break;
        }

        System.out.println();
        for (int i = 0; i < fallos; i++) { //Va enseñando las letras que están mal.
                    System.out.print(palabrasFallidas[i] + " ");
            } 

        System.out.println();
        for (int i = 0; i < palabraCensurada.length; i++) {
            System.out.print(palabraCensurada[i]); //Enseña la palabra censurada, poco a poco mientras se resuelve.
        }

        System.out.println("");
        System.out.println("Di una letra, llevas " + fallos + " fallos." );
        Character adivina = sc.next().charAt(0);
        boolean existeLetra = false;
        for (int i = 0; i < palabraCensurada.length; i++) {
            if (String.valueOf(adivina).equalsIgnoreCase(String.valueOf(palabraDividida[i]))) {
                palabraCensurada[i] = palabraDividida[i];
                acierto--; //Cuando aciertas, se resta a la cantidad de letras que hay en la palabra, por lo que cuando llegue a 0 es porque has acertado la palabra.
                existeLetra = true; //Comprobamos si la letra está en la palabra o no
            }

        }

        if (!existeLetra) {
            boolean letraRepetida = false;
            
            // Verificar si la letra ya está en las fallidas
            for (int i = 0; i < fallos; i++) {
                if (String.valueOf(palabrasFallidas[i]).equalsIgnoreCase(String.valueOf(adivina))) {
                    letraRepetida = true;
                    break;
                }
            }
        
            if (!letraRepetida) {
                if (fallos < palabrasFallidas.length) {
                    palabrasFallidas[fallos] = adivina; // Registrar la letra fallida
                }
                fallos++; // Incrementar el contador de fallos
            } else {
                System.out.println("Ya intentaste con la letra '" + adivina + "'. Intenta con otra.");
            }
        }
        
        
        if (fallos == 10){
            System.out.println("Has perdido, la palabra era " + palabra + ". ");
            System.out.println("");
            System.out.println("¿Quieres jugar otra vez? (S/N)");
            String respuesta = sc.next();
            if (respuesta.equalsIgnoreCase("S")) {
            ahorcado();
            } else {
            System.out.println("Gracias por jugar.");
            }
        }
        }
    }
    }

    public static void main(String[] args) {
        ahorcado();
    }   
}
