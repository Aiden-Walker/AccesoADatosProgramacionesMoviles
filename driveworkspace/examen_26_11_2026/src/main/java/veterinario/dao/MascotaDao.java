package veterinario.dao;

import veterinario.dominio.Mascota;
import veterinario.dominio.Propietario;

public class MascotaDao extends AbstractDao<Mascota> {
	public MascotaDao() {
		setClazz(Mascota.class);
	}
}
