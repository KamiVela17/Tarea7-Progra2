/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import dominio.Comisiones;
import excepciones.*;
import java.util.*;
/**
 *
 * @author Ruldin
 */
public interface AccesoDatos {
    boolean existe(String nombreArchivo)throws AccesoDatosEx;
    public List<Comisiones> listar(String nombreArchivo) throws LecturaDatosEx;
    void escribir(Comisiones comisiones,String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    public String buscar(String nombreArchivo,String buscar)throws LecturaDatosEx;
    public void crear(String nombreArchivo)throws AccesoDatosEx;
    public void borrar(String nombreArchivo)throws AccesoDatosEx;
}
