package br.ufra.acai.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author fabricio correa brabo
 */
public class FabricaDAO {
    
    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("AcaiPU");
    
    private FabricaDAO() {
    }

    public static EntityManagerFactory obterFabrica() {
        return fabrica;
    }

    public static EntityManagerFactory obterFabrica(String unidadePersistencia) {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
        fabrica = Persistence.createEntityManagerFactory(unidadePersistencia);
        return fabrica;
    }
}
