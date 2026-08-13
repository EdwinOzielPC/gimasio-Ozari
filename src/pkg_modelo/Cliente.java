/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_modelo;

/**
 *
 * @author CC_Laboratorio
 */
public class Cliente extends Persona {
private String apellido;
    private String fechaIngreso;
    private int idPlan;
    private int idEntrenador;

    // Constructor vacío
    public Cliente() {
        super();
    }

    // Constructor completo
    public Cliente(
            int id,
            String nombre,
            String apellido,
            String telefono,
            String fechaIngreso,
            int idPlan,
            int idEntrenador) {

        super(id, nombre, telefono);

        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.idPlan = idPlan;
        this.idEntrenador = idEntrenador;
    }

    @Override
    public String mostrarInformacion() {
        return getNombre() + " " + apellido
                + " - Tel: " + getTelefono();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    @Override
    public String toString() {
        return getNombre() + " " + apellido;
    }

    public Object getIdCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}    

