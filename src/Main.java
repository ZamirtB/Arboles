import unac.edu.co.Bina;
import unac.edu.co.Buscar;
import unac.edu.co.Estudiante;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    static Buscar add = new Buscar();

    public static void main(String[] args)  throws Exception{
        Bina arbol = new Bina();
        System.out.println("Carné           Nombre                                   Email");
        tree();
        System.out.println("");
        System.out.print("Inorden: ");
        Bina.inorden(add.TreeRoot());
        System.out.println("");
        System.out.print("Preorden: ");
        Bina.preorden(add.TreeRoot());
        System.out.println("");
        System.out.print("Postorden: ");
        Bina.postorden(add.TreeRoot());
        System.out.println("\n");
        System.out.println("Niveles ");
        Bina.imprimirPorNiveles(add.TreeRoot());
        System.out.println("");
        System.out.println("Altura del Arbol: " + Bina.altura(add.TreeRoot()) + " Niveles");
        System.out.println("Cantidad de Nodos: " + Bina.numNodos(add.TreeRoot()));
        System.out.println("Arbol lleno: " + Bina.fullTree(add.TreeRoot()));
    }
    public static void tree(){
        try{
            FileReader file = new FileReader("estudiantes.txt");
            BufferedReader b = new BufferedReader(file);
            String linea;
            while ((linea = b .readLine()) != null){
                System.out.println(linea);
                String s= "";
                long t = 0;
                for (int i=0 ; i< linea.length(); i++){
                    char a= linea.charAt((i));
                    if(a!= ' '){
                        s = s + (String.valueOf(a));
                    }else{
                        break;
                    }
                }
                t = Long.parseLong(s);
                s= "";
                for(int i=16;  i<linea.length(); i++){
                    char a = linea.charAt(i);
                    if (a !=  ' '){
                        s = s + (String.valueOf(a));
                    }else{
                        break;
                    }
                }
                String v ="";
                for (int i= 58; i <linea.length(); i++  ){
                    char a = linea.charAt(i);
                    if(a != ' '){
                        v = v + (String.valueOf(a));
                    }else {
                        break;
                    }
                }
                Estudiante student = new Estudiante( t, s, v);
                add.insertar(student);
            }
            file.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}