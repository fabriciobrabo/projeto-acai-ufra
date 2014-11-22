package br.ufra.acai.dao.servicos;

import br.ufra.acai.dao.servicos.FabricaDAO;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

/**
 *
 * @author fabricio correa brabo
 * @param <T>
 */
public class GenericDAO {

    private EntityManager em;

    public GenericDAO() {
        this.em = (EntityManager) FabricaDAO.obterFabrica().createEntityManager();
    }

    protected boolean iniciarTransacao() {
        try {
            if (this.getEntityManager().getTransaction().isActive()) {
                return true;
            }
            this.getEntityManager().getTransaction().begin();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean confirmarTransacao() {
        try {
            this.getEntityManager().getTransaction().commit();
            return true;
        } catch (EntityExistsException e) {
            return false;
        }
    }

    protected boolean desfazerTransacao() {
        try {
            this.getEntityManager().getTransaction().rollback();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean transacaoAberta() {
        try {
            return this.getEntityManager().isOpen();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return the entityManager
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * @param entityManager the entityManager to set
     */
    protected void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

}
