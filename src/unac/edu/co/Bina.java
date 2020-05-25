package unac.edu.co;

public class Bina {
    protected Nodo root;
    public Bina() {
        root = null;
    }
    public Bina(Nodo raiz) {
        this.root = raiz;
    }
    public Nodo TreeRoot() {
        return root;
    }
    boolean esVacio() {
        return root == null;
    }
    public static Nodo NewTree(Nodo leftRoot, Object dato, Nodo RightRoot) {
        return new Nodo(leftRoot, dato, RightRoot);
    }
    public static void imprimirPorNiveles(Nodo raiz) throws Exception {
        Cola cola = new Cola();
        cola.insertar(raiz);
        int i = 1;
        while (!cola.colaVacia()){
            Nodo aux = (Nodo) cola.quitar();
            System.out.println(aux.dato);
            if (aux.subTreeL() != null){
                cola.insertar(aux.subTreeL());
            }
            if (aux.subTreeR() != null){
                cola.insertar(aux.subTreeR());
            }
            i++;
        }
    }
    public static void preorden(Nodo r){
        if (r != null){
            r.visited();
            preorden(r.subTreeL());
            preorden(r.subTreeR());
        }
    }
    public static void inorden(Nodo r) {
        if (r != null) {
            inorden (r.subTreeL());
            r.visited();
            inorden (r.subTreeR());
        }
    }
    public static void postorden(Nodo r) {
        if (r != null) {
            postorden (r.subTreeL());
            postorden (r.subTreeR());
            r.visited();
        }
    }
    public static int numNodos(Nodo raiz) {
        if (raiz == null)
            return 0;
        else
            return 1 + numNodos(raiz.subTreeL()) + numNodos(raiz.subTreeR());
    }
    public static int altura(Nodo raiz){
        if (raiz == null)
            return 0;
        else{
            int alturaIzq = altura(raiz.subTreeL());
            int alturaDer = altura(raiz.subTreeR());
            if (alturaIzq > alturaDer)
                return alturaIzq + 1;
            else
                return alturaDer + 1;
        }
    }
    public static boolean fullTree(Nodo root){
        if (root == null)
            return true;
        else if (altura(root.subTreeL()) != altura(root.subTreeR()))
            return false;
        return fullTree(root.subTreeL()) && fullTree(root.subTreeR());
    }
}
