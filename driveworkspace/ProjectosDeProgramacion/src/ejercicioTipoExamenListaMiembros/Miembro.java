package ejercicioTipoExamenListaMiembros;

public class Miembro {
	private String email;
	private String nombre;
	private ListaMiembros amigos;

	public Miembro(String email, String nombre) {
		this.email = email;
		this.nombre = nombre;
		this.amigos = new ListaMiembros();
	}

	public ListaMiembros getAmigos() {
		return amigos;
	}

	public String toString() {
		return this.email + " - " + this.nombre;
	}

	public void anyadeAmigo(Miembro b) {
		this.amigos.anyadeMiembroSinRepetir(b);
	}

	public boolean tieneComoAmigoA(Miembro otro) {
		return this.amigos.contieneMiembro(otro);
	}

	public void eliminaAmigo(Miembro m) {
		this.amigos.eliminaMiembro(m);
	}

	public ListaMiembros personasQueQuizaConozca() {
		ListaMiembros miembrosQQConozca = new ListaMiembros();
		for (int i = 0; i < this.amigos.getTamanyo(); i++) {
			Miembro amigoMio = this.amigos.getTabla()[i];
			for (int j = 0; j < this.amigos.getTabla()[i].amigos.getTamanyo(); j++) {
				Miembro amigoDeMiAmigo = amigoMio.amigos.getTabla()[j];
				if (!this.equals(amigoDeMiAmigo) && !this.amigos.contieneMiembro(amigoDeMiAmigo)) {
					miembrosQQConozca.anyadeMiembroSinRepetir(amigoDeMiAmigo);
				}
			}
		}
		return miembrosQQConozca;
	}

	public ListaMiembros amigosEnComun(Miembro b) {
		ListaMiembros amigosMuyVoid = new ListaMiembros();
		for (int i = 0; i < this.amigos.getTamanyo(); i++) {
			if (b.tieneComoAmigoA(this.amigos.getTabla()[i])) {
				amigosMuyVoid.anyadeMiembroSinRepetir(this.amigos.getTabla()[i]);
			}
		}
		return amigosMuyVoid;
	}

	public boolean tieneLosMismosAmigosQue(Miembro b) {
		boolean thisTrue = false;
		ListaMiembros listaComun = this.amigosEnComun(b);
//		if (listaComun.getTamanyo() == this.amigos.getTamanyo() && listaComun.getTamanyo() == b.amigos.getTamanyo()) {
//			for(int i = 0; i <listaComun.getTamanyo();i++) {
//				Miembro amigoComun = listaComun.getTabla()[i];
//				if(this.tieneComoAmigoA(amigoComun)&&b.tieneComoAmigoA(amigoComun)) {
//					counter++;
//				}
//			}
//			if(counter==listaComun.getTamanyo()) {
//				thisTrue = true;
//			}
		if (listaComun.getTamanyo() == this.amigos.getTamanyo() && listaComun.getTamanyo() == b.amigos.getTamanyo()) {
			thisTrue = true;
		}
		return thisTrue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miembro other = (Miembro) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
