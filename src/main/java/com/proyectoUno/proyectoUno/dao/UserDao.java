package com.proyectoUno.proyectoUno.dao;

import com.proyectoUno.proyectoUno.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsuarios();

    void delete(Long id);

    void registrar(User user);
}
