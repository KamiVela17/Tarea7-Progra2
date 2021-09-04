/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Ruldin
 */
public interface CatalogoComisiones {

    public void agregarComision(String nombreComision, String enero, String febrero, String marzo, String nombreArchivo);

    public void listarComisiones(String nombreArchivo);

    public void buscarComisiones(String nombreArchivo, String buscar);

    public void iniciarArchivo(String nombreArchivo);
}
