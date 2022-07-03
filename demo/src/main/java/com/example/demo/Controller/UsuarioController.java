package com.example.demo.Controller;

import com.example.demo.entitys.Usuario;
import com.example.demo.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    UsuarioServices usuarioServices;
    @GetMapping()
    public ArrayList<Usuario>obtenerUser(){
        return usuarioServices.ListUser();
    }

    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return this.usuarioServices.saveUser(usuario);
    }
    @GetMapping(path = "/{apellidoPaterno}")
    public ArrayList<Usuario> ontenerUsuarioapellidoPaterno(@PathVariable("apellidoPaterno")String apellidoPaterno)
    {
        return this.usuarioServices.ListApePaterno(apellidoPaterno);
    }
    @DeleteMapping(path = "/{dUsuario}")
    public String eliminarPorId(@PathVariable ("dUsuario")Integer IdUsuario)
    {
        boolean ok=this.usuarioServices.eliminarUser(IdUsuario);
        if(ok)
        {
            return "Se elimino con exito"+IdUsuario;
        }else
            {
                return "No se pudo eliminar el usuario con id "+IdUsuario;
            }
    }
}
