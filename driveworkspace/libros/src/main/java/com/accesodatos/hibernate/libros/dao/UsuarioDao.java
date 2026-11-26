package com.accesodatos.hibernate.libros.dao;

import com.accesodatos.hibernate.libros.dominio.Usuario;

public class UsuarioDao extends AbstractDao<Usuario> {
    public UsuarioDao() {
        setClazz(Usuario.class);
    }
}