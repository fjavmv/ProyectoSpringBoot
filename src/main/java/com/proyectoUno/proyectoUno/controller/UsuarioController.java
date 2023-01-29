package com.proyectoUno.proyectoUno.controller;

import com.proyectoUno.proyectoUno.dao.UserDao;
import com.proyectoUno.proyectoUno.dao.UsuarioDaoImp;
import com.proyectoUno.proyectoUno.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Un controlador sirve para manejar las direcciones de url
@RestController
public class UsuarioController {

    //Indicamos la url para devolver el contenido
    @Autowired //De manera automatica se crea un objeto y la guarda inyección de dependencia
    private UserDao userDao;
    @RequestMapping(value = "api/usuarios/{id}")
    public User getUser(@PathVariable long id){
        return new User(id,"Francisco Javier", "Méndez Vázquez", "fjmendez07@gmail.com","9711227512","12345");
    }

    @RequestMapping(value = "api/usuarios")
    public List<User> getUsers(){
        return userDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody User user){
        userDao.registrar(user);
    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        userDao.delete(id);
    }



}
