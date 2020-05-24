import unac.edu.co.Bin;
import unac.edu.co.Busqueda;
import unac.edu.co.Estudiante;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

        static Busqueda abb = new Busqueda();

        public static void main(String[] a) throws Exception {
            Bin arbol = new Bin();
            System.out.println("Carne           Nombre                                   Email");
            arbol();
            System.out.println("");
            System.out.print("Inorden: ");
            Bin.inorden(abb.raizArbol());
            System.out.println("");
            System.out.print("Preorden: ");
            Bin.preorden(abb.raizArbol());
            System.out.println("");
            System.out.print("Postorden: ");
            Bin.postorden(abb.raizArbol());
            System.out.println("\n");
            System.out.println("Por Niveles ");
            Bin.imprimirPorNiveles(abb.raizArbol());
            System.out.println("");
            System.out.println("Altura del Arbol: " + Bin.altura(abb.raizArbol()) + " niveles");
            System.out.println("Cantidad de Nodos: " + Bin.numNodos(abb.raizArbol()));
            System.out.println("Arbol lleno: " + Bin.arbolLleno(abb.raizArbol()));
        }

        public static void arbol() {
            try {
                FileReader fr = new FileReader("estudiantes.txt");
                BufferedReader br =new BufferedReader(fr);
                String linea;

                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    String s = "";
                    long n = 0;
                    for (int i = 0; i < linea.length(); i++) {
                        char c = linea.charAt(i);
                        if (c != ' ') {
                            s = s + (String.valueOf(c));
                        }else{
                            break;
                        }
                    }
                    n = Long.parseLong(s);
                    s = "";
                    for (int i = 16; i < linea.length(); i++) {
                        char c = linea.charAt(i);
                        if (c != ' ') {
                            s = s + (String.valueOf(c));
                        }else{
                            break;
                        }
                    }
                    String b = "";
                    for (int i = 58; i < linea.length(); i++) {
                        char c = linea.charAt(i);
                        if (c != ' ') {
                            b = b + (String.valueOf(c));
                        }else {
                            break;
                        }
                    }
                    Estudiante est = new Estudiante(n, s, b);
                    abb.insertar(est);
                }
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

