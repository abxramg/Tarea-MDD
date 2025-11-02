import java.util.Scanner;

public class PruebaHanoi {

    // Método principal para ejecutar el juego
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numDiscos; // Numero de discos a mover

        System.out.println("Ingresa la cantidad de discos para jugar:");
        numDiscos = Integer.parseInt(teclado.nextLine());

        JuegoHanoi juego = new JuegoHanoi(numDiscos);
        juego.resolver();

        teclado.close();
    }
}