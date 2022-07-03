package com.example.demo.services;

import com.example.demo.entitys.Usuario;
import com.example.demo.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioServices {
    @Autowired
    UsuarioRespository usuarioRespository;

    public ArrayList<Usuario>ListUser(){
      return (ArrayList<Usuario>)  usuarioRespository.findAll();
    }
    public Usuario saveUser(Usuario user){
        return usuarioRespository.save(user);
    }
    public ArrayList<Usuario> ListApePaterno(String apellidoPaterno)
    {
           return usuarioRespository.findByapellidoPaterno(apellidoPaterno);
    }
    public boolean eliminarUser(Integer idUsuario)
    {
        try{
            usuarioRespository.deleteById(idUsuario);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
