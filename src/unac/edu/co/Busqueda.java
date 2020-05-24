package unac.edu.co;
public class Busqueda extends Bin {

    public Busqueda() {
        super();
    }
        public void insertar (Object valor )throws Exception {
            Comparar dat;
            dat = (Comparar) valor;
            raiz = insertar(raiz, dat);
        }

        //método interno para realizar la operación
        protected Nodo insertar(Nodo raizSub, Comparar dato) throws Exception {
            if (raizSub == null)
                raizSub = new Nodo(dato);
            else if (dato.menorQue(raizSub.valorNodo())) {
                Nodo iz;
                iz = insertar(raizSub.subArbolIzquierdo(), dato);
                raizSub.ramaIzquierda(iz);
            }
            else if (dato.mayorQue(raizSub.valorNodo())) {
                Nodo dr;
                dr = insertar(raizSub.subArbolDerecho(), dato);
                raizSub.ramaDerecha(dr);
            }
            else
                throw new Exception("Nodo duplicado");
            return raizSub;
        }

        public void eliminar (Object valor) throws Exception {
            Comparar dato;
            dato = (Comparar) valor;
            raiz = eliminar(raiz, dato);
        }

        //método interno para realizar la operación
        protected Nodo eliminar (Nodo raizSub, Comparar dato) throws Exception {
            if (raizSub == null)
                throw new Exception ("No encontrado el nodo con la clave");
            else if (dato.menorQue(raizSub.valorNodo())) {
                Nodo iz;
                iz = eliminar(raizSub.subArbolIzquierdo(), dato);
                raizSub.ramaIzquierda(iz);
            }
            else if (dato.mayorQue(raizSub.valorNodo())) {
                Nodo dr;
                dr = eliminar(raizSub.subArbolDerecho(), dato);
                raizSub.ramaDerecha(dr);
            }
            else{ // Nodo encontrado
                Nodo q;
                q = raizSub; // nodo a quitar del árbol
                if (q.subArbolIzquierdo() == null)
                    raizSub = q.subArbolDerecho();
                else if (q.subArbolDerecho() == null)
                    raizSub = q.subArbolIzquierdo();
                else { // tiene rama izquierda y derecha
                    q = reemplazar(q);
                }
                q = null;
            }
            return raizSub;
        }

        // método interno para sustituir por el mayor de los menores
        private Nodo reemplazar(Nodo act) {
            Nodo a, p;
            p = act;
            a = act.subArbolIzquierdo(); // rama de nodos menores
            while (a.subArbolDerecho() != null) {
                p = a;
                a = a.subArbolDerecho();
            }
            act.nuevoValor(a.valorNodo());
            if (p == act)
                p.ramaIzquierda(a.subArbolIzquierdo());
            else
                p.ramaDerecha(a.subArbolIzquierdo());
            return a;
        }
    }

