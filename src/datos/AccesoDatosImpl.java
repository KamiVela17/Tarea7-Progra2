/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Comisiones;
import excepciones.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruldin
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Comisiones> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Comisiones> comisiones = new ArrayList();
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);

            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                Comisiones pelicula = new Comisiones(linea);
                comisiones.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return comisiones;
    }

    @Override
    public void escribir(Comisiones comisiones, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(comisiones.toString());
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);

            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i = 0;
            linea = entrada.readLine();
            while (linea != null) {

                String[] arr = linea.split("|");

                if (buscar != null && buscar.equalsIgnoreCase(arr[0])) {
                    resultado = "Comision: " + linea + " encontrada en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
}
