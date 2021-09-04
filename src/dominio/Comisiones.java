/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Ruldin
 */
public class Comisiones {

    String nombre;
    double enero;
    double febrero;
    double marzo;
    double promedio;
    double total;

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEnero() {
        return enero;
    }

    public void setEnero(double enero) {
        this.enero = enero;
    }

    public double getFebrero() {
        return febrero;
    }

    public void setFebrero(double febrero) {
        this.febrero = febrero;
    }

    public double getMarzo() {
        return marzo;
    }

    public void setMarzo(double marzo) {
        this.marzo = marzo;
    }

    public Comisiones(String nombre, double enero, double febrero, double marzo, double promedio, double total) {
        this.nombre = nombre;
        this.enero = enero;
        this.febrero = febrero;
        this.marzo = marzo;
        this.promedio = promedio;
        this.total = total;
    }

    public Comisiones(String comisiones) {
        try {
            String[] arr = comisiones.split("\\|");

            this.nombre = arr[0];
            this.enero = Double.parseDouble(arr[1]);
            this.febrero = Double.parseDouble(arr[2]);
            this.marzo = Double.parseDouble(arr[3]);
            this.promedio = (this.enero + this.febrero + this.marzo) / 3;
            this.total = (this.enero + this.febrero + this.marzo);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {

        return this.nombre + " | " + String.valueOf(this.enero) + " | " + String.valueOf(this.febrero) + " | " + String.valueOf(this.marzo) + " | " + String.valueOf(this.promedio) + " | " + String.valueOf(this.total);
    }

    public void setMes(int mes, double valor) {

        switch (mes) {
            case 1:
                setEnero(valor);
                break;
            case 2:
                setFebrero(valor);

                break;
            case 3:
                setMarzo(valor);

                break;

            default:
                System.out.println("Solo números entre 1 y 3");
        }

    }
}
