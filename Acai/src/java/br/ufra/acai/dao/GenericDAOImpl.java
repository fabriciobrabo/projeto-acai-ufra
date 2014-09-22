/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.dao.servicos.GenericDAO;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fabricio correa brabo
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    private EntityManager em = (EntityManager) FabricaDAO.obterFabrica().createEntityManager();

    public GenericDAOImpl() {
    }

    @Override
    public boolean criar(T o) {
        try {
            this.iniciarTransacao();
            this.getEntityManager().persist(o);
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

    public List<T> obterTodosOrdenado(Class<T> classe, String atributo) {
        List<T> resposta = null;
        try {
            this.iniciarTransacao();
            String query = "SELECT c FROM " + classe.getSimpleName() + " c ORDER BY c." + atributo;
            Query q = this.getEntityManager().createQuery(query);
            resposta = (List<T>) q.getResultList();
            return resposta;
        } catch (Exception e) {
            if (this.transacaoAberta()) {
            }
            return resposta;
        }
    }

    private boolean iniciarTransacao() {
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

    private boolean confirmarTransacao() {
        try {
            this.getEntityManager().getTransaction().commit();
            return true;
        } catch (EntityExistsException e) {
            return false;
        }
    }

    private boolean desfazerTransacao() {
        try {
            this.getEntityManager().getTransaction().rollback();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean transacaoAberta() {
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
