package com.accesodatos.hibernate.utiles;
import javax.persistence.EntityManager;
public class EntityManagerUtil {
	public static EntityManager getEntityManager() {

		//en la siguiente línea se pone lo que pusimos en <persistence-unit name="OtraReunionMas"
		//en el fichero persistence.xml
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("OtraReunionMas");
		EntityManager manager=factory.createEntityManager();

		return manager;
}
