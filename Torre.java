import java.util.Stack;

/**
 * Clase que representa una torre del juego.
 */
public class Torre {

    private Stack<Integer> discos;
    private String nombre;

    /**
     * Crea una nueva torre con su respectivo nombre.
     */
    public Torre(String nombre) {
        this.nombre = nombre;
        this.discos = new Stack<>();
    }

    /**
     * Obtiene el nombre de la torre.
     * @return El nombre asignado a la torre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Verifica si la torre esta vacia.
     * @return Regresa true si la torre es vacia. En otro caso, false.
     */
    public boolean estaVacia() {
        if (discos.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Observa el disco superior de la torre (sin retirarlo).
     * @return El disco que se encuentre el la cima de la torre.
     */
    public Integer verDiscoSuperior() {
        if (!discos.isEmpty()) {
            return discos.peek();
        } else {
        return null;
        }
    }

    /**
     * Coloca un disco a la torre a la cima de la torre.
     * @param disco
     */
    public void agregarDisco(int disco) {
        discos.push(disco);
    }

    /**
     * Retira el disco de la cima de la torre.
     * @return El disco que se encuentre en la cima de la torre.
     */
    public Integer retirarDisco() {
        if (!discos.isEmpty()) {
            return discos.pop(); 
        } else {
        return null;
        }
    }

    /**
     * Muestra el estado de la torre
     */
    public void mostrarEstado() {
        System.out.println("Torre " + nombre + ": " + discos);
    }
}