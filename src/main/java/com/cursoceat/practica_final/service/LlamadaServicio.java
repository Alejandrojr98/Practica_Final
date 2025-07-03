package com.cursoceat.practica_final.service;

import com.cursoceat.practica_final.modell.Llamada;
import com.cursoceat.practica_final.repository.LlamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LlamadaServicio {

    @Autowired
    private LlamadaRepository llamadaRepository;

    public List<Llamada> findAll(){
        return llamadaRepository.findAll();
    }

    public Llamada findById(int id){
        return llamadaRepository.findById(id).orElse(null);
    }
}
