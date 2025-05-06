package com.mycompany.Clases;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTurno;
    private String anden;
    private String dia;
    private String Hora;
    
    @OneToOne
    private Vehiculo auto;

    public Turno() {
    }

    public Turno(int id_turno, String anden, String dia, String hora_Disponible) {
        this.idTurno = id_turno;
        this.anden = anden;
        this.dia = dia;
        this.Hora = hora_Disponible;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getAnden() {
        return anden;
    }

    public void setAnden(String anden) {
        this.anden = anden;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String horaDisponible) {
        this.Hora = horaDisponible;
    }

    public Vehiculo getAuto() {
        return auto;
    }

    public void setAuto(Vehiculo auto) {
        this.auto = auto;
    }

    

}
