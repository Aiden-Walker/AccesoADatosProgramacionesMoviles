package com.accesodatos.hibernate.libros.dao;

import java.util.List;

import javax.persistence.Query;

import com.accesodatos.hibernate.libros.dominio.Ejemplar;

public class EjemplarDao extends AbstractDao<Ejemplar> {

    public EjemplarDao() {
        setClazz(Ejemplar.class);
    }

    // ejemplares de los libros con más páginas de las indicadas
    public List<Ejemplar> getEjemplaresLibrosMasPaginas(int paginas) {
    	
        String qlString = " FROM " + Ejemplar.class.getName() + " e WHERE e.libro.paginas > :paginas";
        
        Query query = getEntityManager().createQuery(qlString);
        query.setParameter("paginas", paginas);
        return query.getResultList();
    }
}