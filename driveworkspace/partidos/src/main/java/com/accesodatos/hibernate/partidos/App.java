package com.accesodatos.hibernate.partidos;

import java.time.LocalDateTime;

import com.accesodatos.hibernate.partidos.dao.EntrenadorDao;
import com.accesodatos.hibernate.partidos.dao.EquipoDao;
import com.accesodatos.hibernate.partidos.dao.JugadorDao;
import com.accesodatos.hibernate.partidos.dao.PartidoDao;
import com.accesodatos.hibernate.partidos.dominio.Entrenador;
import com.accesodatos.hibernate.partidos.dominio.Equipo;
import com.accesodatos.hibernate.partidos.dominio.Jugador;
import com.accesodatos.hibernate.partidos.dominio.Partido;

public class App {
  public static void main(String[] args) {
	  
	EquipoDao equipoDao = new EquipoDao();
	EntrenadorDao entrenadorDao = new EntrenadorDao();
	JugadorDao jugadorDao = new JugadorDao();
	PartidoDao partidoDao = new PartidoDao();
	
	//1
    Equipo equipo1 = new Equipo(1999, "cadi", "ercadi");
    Equipo equipo2 = new Equipo(1999, "sevilla", "beti");
    
    equipoDao.save(equipo1);
    equipoDao.save(equipo2);
    
    
    //2
    Entrenador entrenador1 = new Entrenador(9, "felipe");
    Entrenador entrenador2 = new Entrenador(9, "juan");
    
    entrenadorDao.save(entrenador1);
    entrenadorDao.save(entrenador2);
    
    equipo1.setEntrenador(entrenador1);
    equipo2.setEntrenador(entrenador2);
    
    
    //3
    Jugador jugador1 = new Jugador("enrique", 99, "delantero");
    Jugador jugador2 = new Jugador("pepe", 67, "defensa");
    
    equipo1.addJugadores(jugador1);
    equipo2.addJugadores(jugador2);
    
    //el .save es para ñadir nuevos registros no para actulizar
    jugadorDao.save(jugador1);
    jugadorDao.save(jugador2);
    
    
    //4
    Partido partido1 = new Partido(LocalDateTime.now(), 2, 2);
    Partido partido2 = new Partido(LocalDateTime.now().minusDays(2), 2, 2);
    
    partido1.addEquipo(equipo1);
    partido1.addEquipo(equipo2);
    
    partido2.addEquipo(equipo1);
    partido2.addEquipo(equipo2);
    
    partidoDao.save(partido1);
    partidoDao.save(partido2);

    
    //5
    partido1.setMarcadorEquipo1(60);
    partido1.setMarcadorEquipo2(0);
    
    partido2.setMarcadorEquipo1(9);
    partido2.setMarcadorEquipo2(4);
    
    partidoDao.update(partido1);
    partidoDao.update(partido2);
    
    //6
    System.out.println(equipoDao.getAll());
    
    //7
    equipo1.removeJugadores(jugador1);
    jugadorDao.delete(jugador1);
    
    //8
    System.out.println(partidoDao.getAll());
    
    //9
    Entrenador e = entrenadorDao.get(entrenador1.getId()).get();
    e.setExperiencia(26);
    entrenadorDao.update(e);
    System.out.println(e);

  }
}
