/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.*;
import dominio.Comisiones;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author Ruldin
 */
public class CatalogoComisionesImpl implements CatalogoComisiones {

    private final AccesoDatos datos;

    public CatalogoComisionesImpl() {
        this.datos = new AccesoDatosImpl(); //poner * en el import datos.*
    }

    @Override
    public void agregarComision(String nombre, String enero, String febrero, String marzo, String nombreArchivo) {
        Comisiones comisiones = new Comisiones(nombre, Double.parseDouble(enero), Double.parseDouble(febrero), Double.parseDouble(marzo), 0.0, 0.0);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);//bandera si anexa o no
            datos.escribir(comisiones, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarComisiones(String nombreArchivo) {

        try {
            List<Comisiones> comisiones = datos.listar(nombreArchivo);
            System.out.println("Nombre \t|| Enero \t|| Febrero \t|| Marzo \t|| Total \t|| Promedio");

            for (Comisiones comision : comisiones) {
                System.out.println(comision);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }

    }

    @Override
    public void buscarComisiones(String nombreArchivo, String buscar) {
        String resultado = null;
        try {

            resultado = datos.buscar(nombreArchivo, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar la comision");
            ex.printStackTrace();
        }
        System.out.println("Resultado Busqueda:" + resultado);

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {

        try {
            if (datos.existe(nombreArchivo)) {
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //crearmos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }

    }
}
