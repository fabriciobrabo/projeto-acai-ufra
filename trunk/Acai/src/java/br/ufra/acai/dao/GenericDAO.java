/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fabricio correa brabo
 */
public class GenericDAO<T> implements InterfaceGenericDAO<T> {

    private EntityManager em = (EntityManager) FabricaEntityManager.obterFabrica().createEntityManager();

    public GenericDAO() {
    }

    @Override
    public boolean criar(T o) {
        try {
            this.iniciarTransacao();
            em.persist(o);
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
    public boolean atualizar(T o) {
        try {
            this.iniciarTransacao();
            em.merge(o);
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
            em.remove(o);
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
            this.iniciarTransacao();
            String query = classe.getSimpleName() + ".findById";
            final Query q = em.createNamedQuery(query);
            T t = (T) q.setParameter("id", id).getSingleResult();
            this.confirmarTransacao();
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
            this.iniciarTransacao();
            String query = classe.getSimpleName() + ".findAll";
            Query q = em.createNamedQuery(query);
            resposta = (List<T>) q.getResultList();
            this.confirmarTransacao();
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
            Query q = em.createQuery(query);
            resposta = (List<T>) q.getResultList();
            this.desfazerTransacao();
            return resposta;
        } catch (Exception e) {
            if (this.transacaoAberta()) {
                this.transacaoAberta();
            }
            return resposta;
        }
    }

    public boolean iniciarTransacao() {
        try {
            if (em.getTransaction().isActive()) {
                return true;
            }
            em.getTransaction().begin();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean confirmarTransacao() {
        try {
            em.getTransaction().commit();
            return true;
        } catch (EntityExistsException e) {
            return false;
        }
    }

    public boolean desfazerTransacao() {
        try {
            em.getTransaction().rollback();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean transacaoAberta() {
        try {
            return em.isOpen();
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
