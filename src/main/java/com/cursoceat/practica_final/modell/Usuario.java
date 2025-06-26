package com.cursoceat.practica_final.modell;

import jakarta.persistence.*;

import javax.swing.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String email;
    private String direccion;
    private String puesto;
//    private int id_img;
//    private int id_arch;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // cascada para operaciones de persistencia
    @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")
    private Imagen imagen;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // cascada para operaciones de persistencia
    @JoinColumn(name = "id_archivo", referencedColumnName = "id_archivo")
    private Archivo archivo;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    //    public int getId_img() {
//        return id_img;
//    }
//
//    public void setId_img(int id_img) {
//        this.id_img = id_img;
//    }
//
//    public int getId_arch() {
//        return id_arch;
//    }
//
//    public void setId_arch(int id_arch) {
//        this.id_arch = id_arch;
//    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
