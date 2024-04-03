/**
 * NAYELY QUISPE MAMANI -------------- RU: 200050788
 */
package com.emergentes.modelo;

public class Estudiante {
    private int id;
    private String nombre;
    private int P1;
    private int P2;
    private int EF;
    private int nota;
    

    public Estudiante() {
        this.id = 0;
        this.nombre ="";
        this.P1=0;
        this.P2 =0;
        this.EF=0;
        this.nota=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getP1() {
        return P1;
    }

    public void setP1(int P1) {
        this.P1 = P1;
    }

    public int getP2() {
        return P2;
    }

    public void setP2(int P2) {
        this.P2 = P2;
    }

    public int getEF() {
        return EF;
    }

    public void setEF(int EF) {
        this.EF = EF;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public void calcularNotaTotal() {
        this.nota = this.P1 + this.P2 + this.EF;
    }
    
}

