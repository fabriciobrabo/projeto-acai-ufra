package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.GenericDAOImpl;
import br.ufra.acai.dao.servicos.ProdutorDAOImpl;
import javax.persistence.EntityManager;
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
    
    public static EntityManager criarEntityManager() {
        return fabrica.createEntityManager();
    }
    
    public static ProdutorDAO criarProdutorDAO() {
        return new ProdutorDAOImpl();
    }
    
    public static GenericDAO criarGenericDAO() {
        return new GenericDAOImpl();
    }
}
