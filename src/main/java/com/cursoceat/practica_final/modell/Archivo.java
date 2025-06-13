package com.cursoceat.practica_final.modell;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_archivo")
    private int idArchivo;
    private String nombreArchivo;
    private String tipoMime;
    @Lob
    private byte[] contenido;

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoMime() {
        return tipoMime;
    }

    public void setTipoMime(String tipoMime) {
        this.tipoMime = tipoMime;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Archivo{" +
                "idArchivo=" + idArchivo +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                ", tipoMime='" + tipoMime + '\'' +
                ", contenido=" + Arrays.toString(contenido) +
                '}';
    }
}
