package unac.edu.co;

public class Estudiante {
    long code;
    String name;
    String correo;

    public Estudiante(){
        this(0,null,null);
    }

    public Estudiante(long code, String name, String correo) {
        this.code = code;
        this.name = name;
        this.correo = correo;
    }



    public String toString(){
        if (name != null)
            return code + " " + name + " ";
        else
            return "No asignado";
    }

    public boolean menorQue(Object op2) {
        Estudiante p2 = (Estudiante) op2;
        return code < p2.code;
    }

    public boolean menorIgualQue(Object op2){
        Estudiante p2 = (Estudiante) op2;
        return code <= p2.code;
    }

    public boolean mayorQue(Object op2){
        Estudiante p2 = (Estudiante) op2;
        return code > p2.code;
    }

    public boolean mayorIgualQue(Object op2){
        Estudiante p2 = (Estudiante) op2;
        return code >= p2.code;
    }

    public boolean igualQue(Object op2){
        Estudiante p2 = (Estudiante) op2;
        return code == p2.code;
    }

}
