package com.cursoceat.practica_final.controller;

import com.cursoceat.practica_final.modell.Archivo;
import com.cursoceat.practica_final.modell.Imagen;
import com.cursoceat.practica_final.modell.Llamada;
import com.cursoceat.practica_final.modell.Usuario;
import com.cursoceat.practica_final.repository.ArchivoRepository;
import com.cursoceat.practica_final.repository.ImagenRepository;
import com.cursoceat.practica_final.repository.LlamadaRepository;
import com.cursoceat.practica_final.repository.UsuarioRepository;
import com.cursoceat.practica_final.service.ArchivoServicio;
import com.cursoceat.practica_final.service.LlamadaServicio;
import com.cursoceat.practica_final.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class UsuarioController {
    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final ImagenRepository imagenRepository;

    @Autowired
    private final ArchivoRepository archivoRepository;

    @Autowired
    private final LlamadaRepository llamadaRepository;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ArchivoServicio archivoServicio;

    @Autowired
    private LlamadaServicio llamadaServicio;

    public UsuarioController(UsuarioRepository usuarioRepository, ImagenRepository imagenRepository, ArchivoRepository archivoRepository, LlamadaRepository llamadaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.imagenRepository = imagenRepository;
        this.archivoRepository = archivoRepository;
        this.llamadaRepository = llamadaRepository;
    }

//    @GetMapping("/")
//    public String inicio() {
//        return "index";
//    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("llamadas", llamadaRepository.findAll());
        return "index";
    }

    @GetMapping("/listado_usuarios")
    public String listadoUsuario(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("imagenes", imagenRepository.findAll());
        model.addAttribute("archivos", archivoRepository.findAll());
        return "listado_usuarios";
    }

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
//        model.addAttribute("imagenes", new Imagen());
//        model.addAttribute("archivos", new Archivo());
        listaCargoUsuarios(model);
        return "formulario";
    }

    @GetMapping("/nuevaLlamada")
    public String nuevaLamada(Model model) {
        model.addAttribute("llamada", new Llamada());
//        model.addAttribute("imagenes", new Imagen());
//        model.addAttribute("archivos", new Archivo());
//        listaCargoUsuarios(model);
        listaEstado(model);
        listaPrescripcion(model);
        listaMetales(model);
        listaTatuajes(model);
        listaOperadas(model);
        return "formulario_llamadas";
    }

//    @PostMapping("/guardar")
//    public String guardarUsuario(@ModelAttribute Usuario usuario,@RequestParam("imagenMod") MultipartFile archivos,@RequestParam("archivoMod") MultipartFile archivos2) throws IOException {
//        usuarioServicio.actualizarArchivo(usuario.getIdUsuario(), archivos2);
//        usuarioServicio.actualizarImagen(usuario.getIdUsuario(), archivos);
//        usuarioRepository.save(usuario);
//        return "redirect:/";
//    }

//    @PostMapping("/guardar")
//    public String guardarUsuario(@ModelAttribute Usuario usuario, @RequestParam("imagen") MultipartFile archivos,@RequestParam("archivo") MultipartFile archivos2) throws IOException {
//        if(!archivos.isEmpty()){
//            Imagen imagenes = new Imagen();
//            imagenes.setNombre(archivos.getOriginalFilename());
//            imagenes.setDatos(archivos.getBytes());
//            usuario.setImagen(imagenes);
//        }
//        if(!archivos2.isEmpty()){
//            Archivo archivo3 = new Archivo();
//            archivo3.setNombreArchivo(archivos2.getOriginalFilename());
//            archivo3.setContenido(archivos2.getBytes());
//            archivo3.setTipoMime(archivos2.getContentType());
//            usuario.setArchivo(archivo3);
//        }
//        usuarioRepository.save(usuario);
//        return "redirect:/";
//    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/listado_usuarios";
    }

    @PostMapping("/guardarLlamada")
    public String guardarLlamada(@ModelAttribute Llamada llamada){
        llamadaRepository.save(llamada);
        return "redirect:/";
    }

    @PostMapping("/guardarIMG")
    public String guardarImg(@RequestParam("imagen") MultipartFile archivos, @ModelAttribute Imagen imagen) throws IOException {
//        try{
//            if(archivos.isEmpty()) {
//                System.out.println("img vacio");
//                return "redirect:/formulario";
//            }
            imagen.setNombre(archivos.getOriginalFilename());
            imagen.setDatos(archivos.getBytes());
            imagenRepository.save(imagen);
            return "redirect:/nuevo";
//        }catch (Exception e){
//            System.out.println("Error al guardar imagen");
//            return "redirect:/error";
//        }
    }

    @PostMapping("/guardarArchivo")
    public String guardarArchivo(@RequestParam("archivo") MultipartFile archivos, @ModelAttribute Archivo archivo) throws IOException {
//        try{
//            if(archivos.isEmpty()) {
//                System.out.println("archivo vacio");
//                return "redirect:/error";
//            }
            archivo.setNombreArchivo(archivos.getOriginalFilename());
            archivo.setContenido(archivos.getBytes());
            archivo.setTipoMime(archivos.getContentType());
            archivoRepository.save(archivo);
            return "redirect:/nuevo";
//        }catch (Exception e){
//            System.out.println("Error al guardar archivo");
//            return "redirect:/error";
//        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable("id") int idUsu) {
        usuarioRepository.deleteById(idUsu);
        return "redirect:/listado_usuarios";
    }

    @GetMapping("/eliminarLlamada/{id}")
    public String eliminarLlamada(@PathVariable("id") int idLla) {
        llamadaRepository.deleteById(idLla);
        return "redirect:/";
    }

//    @GetMapping("/eliminar/{id}")
//    public String eliminarEmpleado(@PathVariable("id") int idUsu) {
//        Usuario usuario = usuarioRepository.findById(idUsu).orElse(null);
//        if(usuario != null) {
//            int idImg= usuario.getImagen() != null? usuario.getImagen().getIdImagen():null;
//            int idArchivo= usuario.getArchivo() != null? usuario.getArchivo().getIdArchivo():null;
//
//            usuario.setImagen(null);
//            usuario.setArchivo(null);
//            usuarioRepository.save(usuario);
//            usuarioRepository.deleteById(idUsu);
//        }
//        return "redirect:/listado_usuarios";
//    }

    @GetMapping("/editar/{id}")
    public String editarEmpleado(@PathVariable("id") int idUsu, Model model) {
        Usuario usuario = usuarioRepository.findById(idUsu).orElse(null);
        listaCargoUsuarios(model);
        model.addAttribute("usuario", usuario);
        return "formulario";
    }

    @GetMapping("/editarLlamada/{id}")
    public String editarLlamada(@PathVariable("id") int idLla, Model model) {
        Llamada llamada = llamadaRepository.findById(idLla).orElse(null);
        listaEstado(model);
        listaPrescripcion(model);
        listaMetales(model);
        listaTatuajes(model);
        listaOperadas(model);
        model.addAttribute("llamada", llamada);
        return "formulario_llamadas";
    }

//    @GetMapping("/editar/{id}/{id_img}")
//    public String editarEmpleado(@PathVariable("id") int idUsu,@PathVariable("id_img") int idImg, Model model) {
//        Usuario usuario = usuarioRepository.findById(idUsu).orElse(null);
//        Imagen imagen = imagenRepository.findById(idImg).orElse(null);
//        ArrayList<String> puestoEmpleado = new ArrayList<>();
//        puestoEmpleado.add("");
//        puestoEmpleado.add("Jefe");
//        puestoEmpleado.add("Trabajador");
//        puestoEmpleado.add("Practicas");
//        puestoEmpleado.add("Subjefe");
//        puestoEmpleado.add("Empleado");
//        model.addAttribute("puestoEmpleado", puestoEmpleado);
//        model.addAttribute("imagenes", imagenRepository.findAll());
//        model.addAttribute("archivos", archivoRepository.findAll());
//        model.addAttribute("usuario", usuario);
//        model.addAttribute("imagenMod", imagen);
//        return "formulario";
//    }

    @GetMapping("/imagen/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> obtenerImagen(@PathVariable("id") int idUsu) {
        Usuario usuario = usuarioServicio.findById(idUsu);
        if (usuario == null || usuario.getImagen() == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] imagen = usuario.getImagen().getDatos(); // byte[]
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // o MediaType.IMAGE_PNG según el tipo de imagen
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
    }

    @GetMapping("/documento/descargar/{id}")
    public ResponseEntity<byte[]> descargarDocumento(@PathVariable("id") int idUsu) {
        Archivo archivo = archivoServicio.findById(idUsu);
        if (archivo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getNombreArchivo() + "\"")
                .contentType(MediaType.parseMediaType(archivo.getTipoMime()))
                .body(archivo.getContenido());
    }

    public void listaCargoUsuarios(Model model) {
        ArrayList<String> puestoEmpleado = new ArrayList<>();
        puestoEmpleado.add("");
        puestoEmpleado.add("Jefe");
        puestoEmpleado.add("Trabajador");
        puestoEmpleado.add("Practicas");
        puestoEmpleado.add("Subjefe");
        puestoEmpleado.add("Empleado");
        model.addAttribute("puestoEmpleado", puestoEmpleado);
        model.addAttribute("imagenes", imagenRepository.findAll());
        model.addAttribute("archivos", archivoRepository.findAll());
    }

    public void listaEstado(Model model) {
        ArrayList<String> estado = new ArrayList<>();
        estado.add("");
        estado.add("Pendiente");
        estado.add("Resuelto");
        model.addAttribute("estado", estado);
    }

    public void listaPrescripcion(Model model) {
        ArrayList<String> prescripcion = new ArrayList<>();
        prescripcion.add("");
        prescripcion.add("SI");
        prescripcion.add("NO");
        model.addAttribute("prescripcion", prescripcion);
    }

    public void listaMetales(Model model) {
        ArrayList<String> metales = new ArrayList<>();
        metales.add("");
        metales.add("SI");
        metales.add("NO");
        model.addAttribute("metales", metales);
    }

    public void listaTatuajes(Model model) {
        ArrayList<String> tatuajes = new ArrayList<>();
        tatuajes.add("");
        tatuajes.add("SI");
        tatuajes.add("NO");
        model.addAttribute("tatuajes", tatuajes);
    }

    public void listaOperadas(Model model) {
        ArrayList<String> operada = new ArrayList<>();
        operada.add("");
        operada.add("SI");
        operada.add("NO");
        model.addAttribute("operada", operada);
    }
}
