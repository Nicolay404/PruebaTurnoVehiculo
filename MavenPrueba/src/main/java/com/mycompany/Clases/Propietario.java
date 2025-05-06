package com.mycompany.Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Propietario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_propietario;
    String cedula;
    String Nombre;
    String Apellido;

    @OneToOne(mappedBy = "propietario")
     Vehiculo vehiculo;

    public Propietario() {
    }

    public Propietario(int id_propietario, String cedula, String Nombre, String Apellidos) {
        this.id_propietario = id_propietario;
        this.cedula = cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellidos;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellidos) {
        this.Apellido = Apellidos;
    }

}
