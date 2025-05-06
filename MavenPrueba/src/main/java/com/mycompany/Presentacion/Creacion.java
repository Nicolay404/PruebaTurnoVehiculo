/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Presentacion;

import com.mycompany.Persistencias.PropietarioJpaController;
import com.mycompany.Persistencias.TurnoJpaController;
import com.mycompany.Persistencias.VehiculoJpaController;

/**
 *
 * @author Nicolay
 */
public class Creacion {
    public static void main(String[] args) {
        try {
            
            VehiculoJpaController vehiculoJpa = new VehiculoJpaController();
            PropietarioJpaController propietarioJpa = new PropietarioJpaController();
            TurnoJpaController turnoJpa = new TurnoJpaController();

            System.out.println("Tablas creadas correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
