package com.cursoceat.practica_final.modell;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Llamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLlamada;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_llamada;
    private String estado;
    private String tipo_servicio;
    private String localidad;
    private String disponibilidad_cliente;
    private String disponibilidad_centro;
    private String nombre_centro;
    private String nombre_cliente;
    private String prescripcion;
    private String metales;
    private String tatuajes;
    private String zona_prueba;
    private String zona_operada;
    private String telefono_cliente;
    private String telefono_centro;
    private String email_cliente;
    private String email_centro;
    @Lob
    private byte[] archivo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime cita;

    public int getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    public Date getFecha_llamada() {
        return fecha_llamada;
    }

    public void setFecha_llamada(Date fecha_llamada) {
        this.fecha_llamada = fecha_llamada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDisponibilidad_cliente() {
        return disponibilidad_cliente;
    }

    public void setDisponibilidad_cliente(String disponibilidad_cliente) {
        this.disponibilidad_cliente = disponibilidad_cliente;
    }

    public String getDisponibilidad_centro() {
        return disponibilidad_centro;
    }

    public void setDisponibilidad_centro(String disponibilidad_centro) {
        this.disponibilidad_centro = disponibilidad_centro;
    }

    public String getNombre_centro() {
        return nombre_centro;
    }

    public void setNombre_centro(String nombre_centro) {
        this.nombre_centro = nombre_centro;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
    }

    public String getMetales() {
        return metales;
    }

    public void setMetales(String metales) {
        this.metales = metales;
    }

    public String getTatuajes() {
        return tatuajes;
    }

    public void setTatuajes(String tatuajes) {
        this.tatuajes = tatuajes;
    }

    public String getZona_prueba() {
        return zona_prueba;
    }

    public void setZona_prueba(String zona_prueba) {
        this.zona_prueba = zona_prueba;
    }

    public String getZona_operada() {
        return zona_operada;
    }

    public void setZona_operada(String zona_operada) {
        this.zona_operada = zona_operada;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getTelefono_centro() {
        return telefono_centro;
    }

    public void setTelefono_centro(String telefono_centro) {
        this.telefono_centro = telefono_centro;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getEmail_centro() {
        return email_centro;
    }

    public void setEmail_centro(String email_centro) {
        this.email_centro = email_centro;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public LocalDateTime getCita() {
        return cita;
    }

    public void setCita(LocalDateTime cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "idLlamada=" + idLlamada +
                ", fecha_llamada=" + fecha_llamada +
                ", estado='" + estado + '\'' +
                ", tipo_servicio='" + tipo_servicio + '\'' +
                ", localidad='" + localidad + '\'' +
                ", disponibilidad_cliente='" + disponibilidad_cliente + '\'' +
                ", disponibilidad_centro='" + disponibilidad_centro + '\'' +
                ", nombre_centro='" + nombre_centro + '\'' +
                ", nombre_cliente='" + nombre_cliente + '\'' +
                ", prescripcion='" + prescripcion + '\'' +
                ", metales='" + metales + '\'' +
                ", tatuajes='" + tatuajes + '\'' +
                ", zona_prueba='" + zona_prueba + '\'' +
                ", zona_operada='" + zona_operada + '\'' +
                ", telefono_cliente='" + telefono_cliente + '\'' +
                ", telefono_centro='" + telefono_centro + '\'' +
                ", email_cliente='" + email_cliente + '\'' +
                ", email_centro='" + email_centro + '\'' +
                ", archivo=" + Arrays.toString(archivo) +
                ", cita=" + cita +
                '}';
    }
}
