package unac.edu.co;

public class Bin {
    protected Nodo raiz;

    public Bin() {
        raiz = null;
    }

    public Bin(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo raizArbol() {
        return raiz;
    }

    // Comprueba el estatus del árbol
    boolean esVacio() {
        return raiz == null;
    }

    public static Nodo nuevoArbol(Nodo ramaIzquierda, Object date, Nodo ramaDerecha) {
        return new Nodo(ramaIzquierda, date, ramaDerecha);
    }


    public static void imprimirPorNiveles(Nodo raiz) throws Exception {
        Cola cola = new Cola();
        cola.insertar(raiz);
        int i = 1;
        while (!cola.colaVacia()){
            Nodo aux = (Nodo)cola.quitar();
            System.out.println(aux.date);
            if (aux.subArbolIzquierdo() != null){
                cola.insertar(aux.subArbolIzquierdo());
            }
            if (aux.subArbolDerecho() != null){
                cola.insertar(aux.subArbolDerecho());
            }
            i++;
        }
    }

    //Recorrido de un arbol binario en preorden
    public static void preorden(Nodo r){
        if (r != null){
            r.visitar();
            preorden(r.subArbolIzquierdo());
            preorden(r.subArbolDerecho());
        }
    }

    // Recorrido de un árbol binario en inorden
    public static void inorden(Nodo r) {
        if (r != null) {
            inorden (r.subArbolIzquierdo());
            r.visitar();
            inorden (r.subArbolDerecho());
        }
    }

    // Recorrido de un árbol binario en postorden
    public static void postorden(Nodo r) {
        if (r != null) {
            postorden (r.subArbolIzquierdo());
            postorden (r.subArbolDerecho());
            r.visitar();
        }
    }

    public static int numNodos(Nodo raiz) {
        if (raiz == null)
            return 0;
        else
            return 1 + numNodos(raiz.subArbolIzquierdo()) + numNodos(raiz.subArbolDerecho());
    }

    public static int altura(Nodo raiz){
        if (raiz == null)
            return 0;
        else{
            int alturaIzq = altura(raiz.subArbolIzquierdo());
            int alturaDer = altura(raiz.subArbolDerecho());
            if (alturaIzq > alturaDer)
                return alturaIzq + 1;
            else
                return alturaDer + 1;
        }
    }



    public static boolean arbolLleno(Nodo raiz){
        if (raiz == null)
            return true;
        else if (altura(raiz.subArbolIzquierdo()) != altura(raiz.subArbolDerecho()))
            return false;
        return arbolLleno(raiz.subArbolIzquierdo()) && arbolLleno(raiz.subArbolDerecho());
    }



}