package unac.edu.co;

public class Buscar extends Bina{
    public Buscar() {
        super();
    }
    public void insertar (Object valor )throws Exception {
        Comparar date;
        date = (Comparar) valor;
        root = insertar(root, date);
    }
    protected Nodo insertar(Nodo raizSub, Comparar dato) throws Exception {
        if (raizSub == null)
            raizSub = new Nodo(dato);
        else if (dato.menorQue(raizSub.valueNode())) {
            Nodo iz;
            iz = insertar(raizSub.subTreeL(), dato);
            raizSub.leftRoot(iz);
        }
        else if (dato.mayorQue(raizSub.valueNode())) {
            Nodo dr;
            dr = insertar(raizSub.subTreeR(), dato);
            raizSub.RightRoot(dr);
        }
        else
            throw new Exception("Nodo duplicado");
        return raizSub;
    }
    public void eliminar (Object valor) throws Exception {
        Comparar date;
        date = (Comparar) valor;
        root = eliminar(root, date);
    }
    protected Nodo eliminar (Nodo raizSub, Comparar dato) throws Exception {
        if (raizSub == null)
            throw new Exception ("No encontrado el nodo con la clave");
        else if (dato.menorQue(raizSub.valueNode())) {
            Nodo iz;
            iz = eliminar(raizSub.subTreeL(), dato);
            raizSub.leftRoot(iz);
        }
        else if (dato.mayorQue(raizSub.valueNode())) {
            Nodo dr;
            dr = eliminar(raizSub.subTreeR(), dato);
            raizSub.RightRoot(dr);
        }
        else{
            Nodo q;
            q = raizSub;
            if (q.subTreeL() == null)
                raizSub = q.subTreeR();
            else if (q.subTreeR() == null)
                raizSub = q.subTreeL();
            else {
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }
    private Nodo reemplazar(Nodo act) {
        Nodo a, p;
        p = act;
        a = act.subTreeL();
        while (a.subTreeR() != null) {
            p = a;
            a = a.subTreeR();
        }
        act.NewValue(a.valueNode());
        if (p == act)
            p.leftRoot(a.subTreeL());
        else
            p.RightRoot(a.subTreeL());
        return a;
    }
}
