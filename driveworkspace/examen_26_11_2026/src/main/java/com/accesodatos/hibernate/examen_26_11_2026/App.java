package com.accesodatos.hibernate.examen_26_11_2026;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;

import veterinario.dao.MascotaDao;
import veterinario.dao.MicroChipDao;
import veterinario.dao.PropietarioDao;
import veterinario.dao.TratamientoDao;
import veterinario.dominio.Mascota;
import veterinario.dominio.Propietario;
import veterinario.dominio.Tratamiento;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		PropietarioDao propiDao = new PropietarioDao();
		MascotaDao mascoDao = new MascotaDao();
		MicroChipDao microDao = new MicroChipDao();
		TratamientoDao tratiDao = new TratamientoDao();
		// 1. Dos propietarios, y volcar a BD
		Propietario p1 = new Propietario("1111HXM", "Paco Salas", "420");
		Propietario p2 = new Propietario("2222HXS", "Gertrudis", "670");
		propiDao.save(p1);
		propiDao.save(p2);
		// 2. Crear tres mascotas, asignarlas a los propietarios anteriores y
		// persistirlas en base de datos
		Mascota m1 = new Mascota("Maximiliano I", "Perro", 15.0);
		Mascota m2 = new Mascota("Humo", "Gato", 13.0);
		Mascota m3 = new Mascota("Gary", "Gary", 15.0);
		p1.addMascota(m1);
		p2.addMascota(m2);
		p2.addMascota(m3);
		mascoDao.save(m1);
		mascoDao.save(m2);
		mascoDao.save(m3);
		// 3 Crear dos microchips asignarlos a mascotas y persistirlo en la base de
		// datos
		// 4 Crear tres tratamientos distintos y asociarlos a las mascotas (asegurando
		// que al menos
		// una mascota reciba varios tratamientos y un tratamiento se aplique a varias
		// mascotas).
		// Volcar en BD.
		Tratamiento t1 = new Tratamiento("MataPiojos3452", 1200,
				"Esta cosa mata a los piojos de manera ultra rapida y eficaz, no daña a tu perro!");
		Tratamiento t2 = new Tratamiento("FormulaLockIn", 450,
				"Esto hara que tu gato deje de destruir cosas en casa, si destruye algo te devolvemos el dinero!");
		Tratamiento t3 = new Tratamiento("Excorciser", 666,
				"Si tu Gary hace cosas no de Gary, dale esto y arreglado, Gary Gary Gary");
		m1.addTratamiento(t1);
		m2.addTratamiento(t2);
		m3.addTratamiento(t3);
		tratiDao.save(t1);
		tratiDao.save(t2);
		tratiDao.save(t3);
		// 5 Recuperar a una mascota por su id updatear su peso y actualizar la base de
		// datos
		Optional<Mascota> optMascota = mascoDao.get(m1.getId());
		if (optMascota.isPresent()) {
			Mascota mascota = optMascota.get();
			System.out.println("Recuperado: " + mascota);
			mascota.setPeso(888);
			// Maximiliano primero comio demasiados turrones y polvorones en navidades, lo
			// siento Marta
			m1 = mascota;
			mascoDao.update(m1);

		}
		/*
		 * 6. Listar por consola todas las mascotas almacenadas en la BD junto con los
		 * datos de su propietario y su microchip (si tiene).
		 */
		List<Mascota> mascotas = mascoDao.getAll();
		for (Mascota e : mascotas) {
			System.out.println(e);
		}
		/*
		 * 7. Listar por consola todos los tratamientos registrados en la BD junto con
		 * las mascotas que los han recibido.
		 */
		List<Tratamiento> tratamientos = tratiDao.getAll();
		for (Tratamiento e : tratamientos) {
			System.out.println(e);
		}
		/*
		 * 8. Recuperar un tratamiento (o una mascota) de la BD y eliminarlo,
		 * comprobando que la operación se realiza sin errores de integridad
		 * referencial.
		 */
		// Mi odio hacia el tratamiento numero 3 es incomesurable, lo voy a borrar de la
		// existencia de la base de datos
		Optional<Tratamiento> optTratamiento = tratiDao.get(t3.getId());
		if (optTratamiento.isPresent()) {
			Tratamiento tratamiento = optTratamiento.get();
			System.out.println("Recuperado: " + tratamiento);
			t3 = tratamiento;
			tratiDao.delete(t3);

		}
	}
}