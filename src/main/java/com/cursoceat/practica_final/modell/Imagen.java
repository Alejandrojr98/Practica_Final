package com.cursoceat.practica_final.modell;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_imagen")
    private int idImagen;
    private String nombre;
    @Lob
    private byte[] datos;

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getDatos() {
        return datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "idImagen=" + idImagen +
                ", nombre='" + nombre + '\'' +
                ", datos=" + Arrays.toString(datos) +
                '}';
    }
}
