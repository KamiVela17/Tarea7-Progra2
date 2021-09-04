/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelisplus;

import java.util.*;
import negocio.CatalogoComisiones;
import negocio.CatalogoComisionesImpl;

/**
 *
 * @author Ruldin
 */
public class ComisionesMes {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\KamiVela\\Documents\\Archivo.txt";
    private static final CatalogoComisiones catalogoComi = new CatalogoComisionesImpl();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.- Iniciar catalogo comisiones"
                        + "\n2.- Agregar comision\n"
                        + "3.- Listar comisiones\n"
                        + "4.- Buscar comisiones\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        catalogoComi.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //2. agregar informacion archivo

                        System.out.println("Ingrese datos de la comision:");

                        System.out.println("Ingrese nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese informacion de enero");
                        String enero = scanner.nextLine();
                        System.out.println("Ingrese informacion de febrero");
                        String febrero = scanner.nextLine();
                        System.out.println("Ingrese informacion de marzo");
                        String marzo = scanner.nextLine();

                        catalogoComi.agregarComision(nombre, enero, febrero, marzo, nombreArchivo);
                        break;
                    case 3:
                        //3. listar catalogo completo
                        catalogoComi.listarComisiones(nombreArchivo);
                        break;
                    case 4:
                        //4. Buscar pelicula
                        System.out.println("Introduce datos de la comision a buscar:");
                        String buscar = scanner.nextLine();
                        catalogoComi.buscarComisiones(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
