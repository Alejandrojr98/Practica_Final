package com.cursoceat.practica_final.repository;

import com.cursoceat.practica_final.modell.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
