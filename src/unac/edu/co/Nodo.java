package unac.edu.co;

public class Nodo {
    protected Object date;
    protected Nodo l;
    protected Nodo de;

    public Nodo(Object valor){
        date = valor;

        l = de = null;
    }

    public Nodo(Nodo ramaIzquierda, Object valor, Nodo ramaDerecha){
        date = valor;
        l = ramaIzquierda;
        de = ramaDerecha;
    }

    public Object valorNodo(){
        return date;
    }

    public Nodo subArbolIzquierdo(){
        return l;
    }

    public Nodo subArbolDerecho(){
        return de;
    }

    public void nuevoValor(Object d){
        date = d;
    }

    public void ramaIzquierda(Nodo n){
        l = n;
    }

    public void ramaDerecha(Nodo n){
        de = n;
    }

    public void visitar(){
        System.out.print(date + " ");
    }
}

