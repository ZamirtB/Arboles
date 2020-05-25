package unac.edu.co;

    public class Estudiante implements Comparar {
        long Codigo;
        String Nombre;
        String Correo;

        public Estudiante() {
            this(0, null, null);
        }
        public Estudiante(long codi, String nom, String corr) {
            Codigo = codi;
            Nombre = nom;
            Correo = corr;
        }
        public String toString() {
            if (Nombre != null) {
                return Codigo + " " + Nombre + " ";
            } else {
                return "No está asignado";
            }
        }
        public boolean menorQue(Object op2) {
            Estudiante p2 = (Estudiante) op2;
            return Codigo < p2.Codigo;
        }
        public boolean menorIgualQue(Object op2) {
            Estudiante p2 = (Estudiante) op2;
            return Codigo <= p2.Codigo;
        }
        public boolean mayorQue(Object op2) {
            Estudiante p2 = (Estudiante) op2;
            return Codigo > p2.Codigo;
        }
        public boolean mayorIgualQue(Object op2) {
            Estudiante p2 = (Estudiante) op2;
            return Codigo >= p2.Codigo;
        }
        public boolean igualQue(Object op2) {
            Estudiante p2 = (Estudiante) op2;
            return Codigo == p2.Codigo;
        }
    }
