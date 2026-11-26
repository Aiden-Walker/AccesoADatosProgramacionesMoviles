package com.accesodatos.hibernate.libros;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.accesodatos.hibernate.libros.dao.AutorDao;
import com.accesodatos.hibernate.libros.dao.EjemplarDao;
import com.accesodatos.hibernate.libros.dao.LibroDao;
import com.accesodatos.hibernate.libros.dao.PrestamoDao;
import com.accesodatos.hibernate.libros.dao.UsuarioDao;
import com.accesodatos.hibernate.libros.dominio.Autor;
import com.accesodatos.hibernate.libros.dominio.Ejemplar;
import com.accesodatos.hibernate.libros.dominio.Libro;
import com.accesodatos.hibernate.libros.dominio.Prestamo;
import com.accesodatos.hibernate.libros.dominio.Usuario;

public class App {
    public static void main(String[] args) {

        AutorDao autorDao = new AutorDao();
        LibroDao libroDao = new LibroDao();
        EjemplarDao ejemplarDao = new EjemplarDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        PrestamoDao prestamoDao = new PrestamoDao();

        // 1. Dos autores y un libro, asociados, y volcar a BD
        Autor a1 = new Autor("Ana Pérez");
        Autor a2 = new Autor("Luis Gómez");
        Libro libro = new Libro("Aprendiendo Hibernate", "978-1-111-11111-2", "Editorial Sur", 50);
        libro.addAutor(a1);
        libro.addAutor(a2);
        libroDao.save(libro); // el cascade guarda también los autores

        // 2. Dos ejemplares del libro, y volcar a BD
        Ejemplar e1 = new Ejemplar("EJ-003", "Biblioteca de Sevilla");
        Ejemplar e2 = new Ejemplar("EJ-004", "Biblioteca de Málaga");
        libro.addEjemplar(e1);
        libro.addEjemplar(e2);
        ejemplarDao.save(e1);
        ejemplarDao.save(e2);

        // 3. Dos usuarios y un préstamo a cada uno
        Usuario u1 = new Usuario("Raúl Sánchez");
        Usuario u2 = new Usuario("Laura López");
        usuarioDao.save(u1);
        usuarioDao.save(u2);

        Prestamo p1 = new Prestamo(u1, e1, LocalDateTime.now().minusDays(10));
        p1.setFechaDevolucion(LocalDateTime.now().minusDays(3)); // solo este lo devuelve
        Prestamo p2 = new Prestamo(u2, e2, LocalDateTime.now());
        prestamoDao.save(p1);
        prestamoDao.save(p2);

        // 4. Recuperar de BD uno de los objetos (supongamos que no lo tenemos a mano)
        Optional<Autor> optAutor = autorDao.get(a1.getId());
        if (optAutor.isPresent()) {
            Autor autor = optAutor.get();
            System.out.println("Recuperado: " + autor);

            // 5. Borrarlo (con el MISMO dao con el que lo hemos recuperado)
            autorDao.delete(autor);
            System.out.println("Autor borrado");
        }

        // 6. Préstamos no devueltos
        List<Prestamo> noDevueltos = prestamoDao.getPrestamosNoDevueltos();
        System.out.println("*** Préstamos no devueltos:");
        for (Prestamo p : noDevueltos) {
            System.out.println(p);
        }

        // 7. Ejemplares de libros de más de 30 páginas
        List<Ejemplar> ejemplares = ejemplarDao.getEjemplaresLibrosMasPaginas(30);
        System.out.println("*** Ejemplares de libros de más de 30 páginas:");
        for (Ejemplar e : ejemplares) {
            System.out.println(e);
        }
    }
}