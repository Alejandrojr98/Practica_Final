package com.cursoceat.practica_final.service;

import com.cursoceat.practica_final.modell.Archivo;
import com.cursoceat.practica_final.repository.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivoServicio {

    @Autowired
    private ArchivoRepository archivoRepository;

    public List<Archivo> findAll() {
        return archivoRepository.findAll();
    }

    public Archivo findById(int id) {
        return archivoRepository.findById(id).orElse(null);
    }
}
