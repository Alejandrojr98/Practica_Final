package com.cursoceat.practica_final.service;

import com.cursoceat.practica_final.modell.Archivo;
import com.cursoceat.practica_final.modell.Imagen;
import com.cursoceat.practica_final.modell.Usuario;
import com.cursoceat.practica_final.repository.ArchivoRepository;
import com.cursoceat.practica_final.repository.ImagenRepository;
import com.cursoceat.practica_final.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public Usuario findById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public void actualizarArchivo(int idUsuario, MultipartFile archivo) throws IOException {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();

        Archivo archivoActual= usuario.getArchivo();

        if(archivoActual==null) {
            Archivo archivoNuevo = new Archivo();
            archivoNuevo.setNombreArchivo(archivo.getOriginalFilename());
            archivoNuevo.setContenido(archivo.getBytes());
            archivoNuevo.setTipoMime(archivo.getContentType());
            usuario.setArchivo(archivoNuevo);
        }else{
            archivoActual.setContenido(archivo.getBytes());
            archivoActual.setTipoMime(archivo.getContentType());
            archivoActual.setNombreArchivo(archivo.getOriginalFilename());
            archivoRepository.save(archivoActual);
        }

        usuarioRepository.save(usuario);
    }

    @Transactional
    public void actualizarImagen(int idUsuario, MultipartFile imagen) throws IOException {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        Imagen imagenActual= usuario.getImagen();

        if(imagenActual==null) {
            Imagen imagenNuevo = new Imagen();
            imagenNuevo.setNombre(imagen.getOriginalFilename());
            imagenNuevo.setDatos(imagen.getBytes());
            usuario.setImagen(imagenNuevo);
        }else{
            imagenActual.setDatos(imagen.getBytes());
            imagenActual.setNombre(imagen.getOriginalFilename());
            imagenRepository.save(imagenActual);
        }
        usuarioRepository.save(usuario);
    }
}
