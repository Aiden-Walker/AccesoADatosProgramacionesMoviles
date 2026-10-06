package testsJUnit;

public class Fisica {

	// Velocidad: v = d / t
	public double calcularVelocidad(double distancia, double tiempo) {
		if (tiempo == 0)
			throw new IllegalArgumentException("El tiempo no puede ser cero");
		return distancia / tiempo;
	}

	// EnergÃ­a cinÃ©tica: Ec = 1/2 * m * v^2
	public double energiaCinetica(double masa, double velocidad) {
		return 0.5 * masa * Math.pow(velocidad, 2);
	}

	// Fuerza: F = m * a
	public double fuerza(double masa, double aceleracion) {
		return masa * aceleracion;
	}

	// Peso: P = m * g (g = 9.81 m/sÂ²)
	public double peso(double masa) {
		final double gravedad = 9.81;
		return masa * gravedad;
	}

	// Trabajo: W = F * D
	public double trabajo(double fuerza, double desplazamiento) {
		return fuerza * desplazamiento;
	}

	// Densidad: Ï� = m / V
	public double densidad(double masa, double volumen) {
		if (volumen == 0)
			throw new IllegalArgumentException("El volumen no puede ser cero");
		return masa / volumen;
	}
}
