package unac.edu.co;

public class Cola {
    protected NCola adelante;
    protected NCola ultimo;

    public Cola() {
        adelante = ultimo = null;
    }
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
    public Object quitar() throws Exception {
        Object aux;
        if (!colaVacia()) {
            aux = adelante.elemento;
            adelante = adelante.siguiente;
        } else
            throw new Exception("Eliminar de una cola vacía");
        return aux;
    }
    public void borrarCola() {
        for (; adelante != null;) {
            adelante = adelante.siguiente;
        }
        System.gc();
    }
    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (adelante.elemento);
    }
    public boolean colaVacia() {
        return (adelante == null);
    }
}
