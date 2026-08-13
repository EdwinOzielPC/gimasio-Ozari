/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_modelo;

/**
 *
 * @author CC_Laboratorio
 */
public class Entrenador extends Persona {
    private String especialidad;

    // Constructor vacío
    public Entrenador() {
        super();
    }

    // Constructor completo
    public Entrenador(
            int id,
            String nombre,
            String especialidad,
            String telefono) {

        super(id, nombre, telefono);

        this.especialidad = especialidad;
    }

    @Override
    public String mostrarInformacion() {
        return getNombre()
                + " - "
                + especialidad
                + " - Tel: "
                + getTelefono();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public Object getIdEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

