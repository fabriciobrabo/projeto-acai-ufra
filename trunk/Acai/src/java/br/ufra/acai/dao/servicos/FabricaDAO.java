package br.ufra.acai.dao.servicos;

import br.ufra.acai.dao.AssociacaoDAOImpl;
import br.ufra.acai.dao.ColheitaDAOImpl;
import br.ufra.acai.dao.LocalDAOImpl;
import br.ufra.acai.dao.ProdutoDAOImpl;
import br.ufra.acai.dao.ProdutorDAOImpl;
import br.ufra.acai.dao.RasaDAOImpl;
import br.ufra.acai.dao.UsuarioDAOImpl;
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

    public static AssociacaoDAO criarAssociacaoDAO() {
        return new AssociacaoDAOImpl();
    }

    public static ColheitaDAO criarColheitaDAO() {
        return new ColheitaDAOImpl();
    }

    public static LocalDAO criarLocalDAO() {
        return new LocalDAOImpl();
    }

    public static ProdutoDAO criarProdutoDAO() {
        return new ProdutoDAOImpl();
    }

    public static ProdutorDAO criarProdutorDAO() {
        return new ProdutorDAOImpl();
    }

    public static RasaDAO criarRasaDAO() {
        return new RasaDAOImpl();
    }

    public static UsuarioDAO criarUsuarioDAO() {
        return new UsuarioDAOImpl();
    }

    public static GenericDAO criarGenericDAO() {
        return new GenericDAO();
    }
}
