package veterinario.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManager manager;

    public static EntityManager getEntityManager() {
        // solo se crea la primera vez; después todos los DAO reciben el mismo
        if (manager == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("libros");
            manager = factory.createEntityManager();
        }
        return manager;
    }
}