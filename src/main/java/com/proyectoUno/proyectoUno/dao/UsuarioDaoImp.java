package com.proyectoUno.proyectoUno.dao;

import com.proyectoUno.proyectoUno.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // permite acceder al repositorio de la base de datos
@Transactional // la forma en la que trata las consultas sql
public class UsuarioDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager; //Permite la conexión con la base de datos
    @Override
    public List<User> getUsuarios() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    public void registrar(User user) {
       entityManager.merge(user);
    }
}
