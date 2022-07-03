package com.example.demo.repositories;

import com.example.demo.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario,Integer> {
    public abstract ArrayList<Usuario> findByapellidoPaterno(String apellidoPaterno);
}
