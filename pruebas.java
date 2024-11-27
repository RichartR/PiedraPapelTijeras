public record pruebas() {
    static int eleccionOrdenador(){
        int eleccionOrdenador = ((int) (Math.random()*3)+1);

        return eleccionOrdenador;
    }
    public static void main(String[] args) {
        System.out.println(eleccionOrdenador());
    }   
}
