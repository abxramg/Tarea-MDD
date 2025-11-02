/**
 * Clase que contiene las reglas y el algoritmo para resolver el juego de las
 * Torres de Hanoi.
 */
public class JuegoHanoi {
    
    private Torre torreA;
    private Torre torreB;
    private Torre torreC;
    
    private int numDiscos;

    /**
     * Constructor que inicializa las tres torres.
     * @param numDiscos El numero de discos con los que se jugara.
     */
    public JuegoHanoi(int numDiscos) {
        this.numDiscos = numDiscos;
        this.torreA = new Torre("A");
        this.torreB = new Torre("B");
        this.torreC = new Torre("C");

        // Llenamos la torre A con los discos en orden decreciente
        for (int i = numDiscos; i >= 1; i--) {
            torreA.agregarDisco(i);
        }
    }

    /**
     * Metodo encargado de resolver el juego.
     */
    public void resolver() {
        int totalMovimientos = (int) Math.pow(2, numDiscos) - 1;

        // Si el número de discos es par, intercambiamos las torres B y C
        if (numDiscos % 2 == 0) {
            Torre temp = torreB;
            torreB = torreC;
            torreC = temp;
        }

        // Imprimir el estado inicial
        System.out.println("Resolviendo las Torres de Hanoi con " + numDiscos + " discos:");

        // Realizamos los movimientos
        for (int i = 1; i <= totalMovimientos; i++) {
            if (i % 3 == 1) {

                 // Mueve el disco de la torre A a la C 
                moverDisco(torreA, torreC);

            } else if (i % 3 == 2) {

                // Mueve el disco de la torre A a la B 
                moverDisco(torreA, torreB);

            } else {

                // Mueve el disco de la torre B a la C
                moverDisco(torreB, torreC);
            }
        }
    }

    /**
     * Metodo encargado de mover un disco entre 2 torres.
     * @param origen Torre desde donde sale el disco.
     * @param destino Torre a donde tiene que llegar el disco.
     */
    private void moverDisco(Torre origen, Torre destino) {
        Integer discoOrigen = origen.verDiscoSuperior();
        Integer discoDestino = destino.verDiscoSuperior();

        // Si la torre origen tiene un disco y la torre destino está vacía o 
        // el disco origen es más pequeño
        if (discoOrigen != null && (discoDestino == null || discoOrigen < discoDestino)) {
            destino.agregarDisco(origen.retirarDisco());
            System.out.println("Mover disco de " + origen.getNombre() + " a " + destino.getNombre());
        }

        // Si la torre destino tiene un disco y la torre origen está vacía, 
        // mover el disco destino a origen
        else if (discoDestino != null) {
            origen.agregarDisco(destino.retirarDisco());
            System.out.println("Mover disco de " + destino.getNombre() + " a " + origen.getNombre());
        }

        // Mostrar el estado de las torres después del movimiento
        torreA.mostrarEstado();
        torreB.mostrarEstado();
        torreC.mostrarEstado();
    }
}