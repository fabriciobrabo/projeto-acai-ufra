package br.ufra.acai.dao.servicos;

import br.ufra.acai.dao.FabricaDAO;
import br.ufra.acai.dao.GenericDAO;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fabricio correa brabo
 * @param <T>
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    private EntityManager em;

    public GenericDAOImpl() {
        this.em = (EntityManager) FabricaDAO.obterFabrica().createEntityManager();
    }

    @Override
    public boolean criar(T o) {
        try {
            this.iniciarTransacao();
            System.out.println("chegou aqui");
            this.getEntityManager().persist(this.getEntityManager().merge(o));
            System.out.println("chegou aqui 2");
            this.confirmarTransacao();
            System.out.println("chegou aqui 3");
            return true;
        } catch (Exception e) {
            if (this.transacaoAberta()) {
                this.desfazerTransacao();
            }
            return false;
        }
    }

    @Override
    public boolean atualizar(T o) {
        try {
            this.iniciarTransacao();
            this.getEntityManager().merge(o);
            this.confirmarTransacao();
            return true;
        } catch (Exception e) {
            if (this.transacaoAberta()) {
                this.desfazerTransacao();
            }
            return false;
        }
    }

    @Override
    public boolean excluir(T o) {
        try {
            this.iniciarTransacao();
            this.getEntityManager().remove(o);
            this.confirmarTransacao();
            return true;
        } catch (Exception e) {
            if (this.transacaoAberta()) {
                this.desfazerTransacao();
            }
            return false;
        }
    }

    @Override
    public T obter(Class<T> classe, Object id) {
        if (id == null) {
            return null;
        }
        try {
            String query = classe.getSimpleName() + ".findById";
            final Query q = this.getEntityManager().createNamedQuery(query);
            T t = (T) q.setParameter("id", id).getSingleResult();
            return t;
        } catch (Exception e) {
            if (this.transacaoAberta()) {
                this.desfazerTransacao();
            }
            return null;
        }
    }

    @Override
    public List<T> obterTodos(Class<T> classe) {
        List<T> resposta = null;
        try {
            String query = classe.getSimpleName() + ".findAll";
            Query q = this.getEntityManager().createNamedQuery(query);
            resposta = (List<T>) q.getResultList();
            return resposta;
        } catch (Exception e) {
            if (this.transacaoAberta()) {
                this.desfazerTransacao();
            }
            return resposta;
        }
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
