package unac.edu.co;

public class Cola {
    protected NCola adelante;
    protected NCola ultimo;


    // constructor: crea cola vacía
    public Cola() {
        adelante = ultimo = null;
    }

    // insertar: pone elemento por el final
    public void insertar(Object elemento) {
        NCola a;
        a = new NCola(elemento);
        if (colaVacia()) {
            adelante = a;
        } else {
            ultimo.siguiente = a;
        }
        ultimo = a;
    }

    // quitar: sale el elemento frente
    public Object quitar() throws Exception {
        Object aux;
        if (!colaVacia()) {
            aux = adelante.elemento;
            adelante = adelante.siguiente;
        } else
            throw new Exception("Eliminar de una cola vacía");
        return aux;
    }

    // libera todos los nodos de la cola
    public void borrarCola() {
        for (; adelante != null;) {
            adelante = adelante.siguiente;
        }
        System.gc();
    }

    // acceso al primero de la cola
    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (adelante.elemento);
    }

    // verificación del estado de la cola
    public boolean colaVacia() {
        return (adelante == null);
    }
}
