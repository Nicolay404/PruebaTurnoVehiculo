package com.mycompany.Clases;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idVehiculo;
    String placa;
    String marca;
    String estado;
    
    
    @OneToOne
    Propietario propietario;

    public Vehiculo() {
    }

    public Vehiculo(int id_vehiculo, String placa, String marca, String estado) {
        this.idVehiculo = id_vehiculo;
        this.placa = placa;
        this.marca = marca;
        this.estado = estado;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
    public int getId_vehiculo() {
        return idVehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.idVehiculo = id_vehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
