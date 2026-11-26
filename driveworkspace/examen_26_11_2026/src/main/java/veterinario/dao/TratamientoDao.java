package veterinario.dao;

import veterinario.dominio.Tratamiento;

public class TratamientoDao extends AbstractDao<Tratamiento> {
	public TratamientoDao() {
		setClazz(Tratamiento.class);
	}
}
