package unac.edu.co;

public class Nodo{
        protected Object dato;
        protected Nodo izquierda;
        protected Nodo derecha;

        public Nodo(Object valor){
            dato = valor;
            izquierda = derecha = null;
        }
        public Nodo(Nodo raizIzquierda, Object valor, Nodo raizDerecha){
            dato = valor;
            izquierda = raizIzquierda;
            derecha = raizDerecha;
        }
        public Object valueNode(){
            return dato;
        }
        public Nodo subTreeL(){
            return izquierda;
        }
        public Nodo subTreeR(){
            return derecha;
        }
        public void NewValue(Object d){
            dato = d;
        }
        public void leftRoot(Nodo n){
            izquierda = n;
        }
        public void RightRoot(Nodo n){
            derecha = n;
        }
        public void leftRoot(){
            System.out.print(dato + " ");
        }
        public void visited(){
            System.out.print(dato + " ");
        }
}