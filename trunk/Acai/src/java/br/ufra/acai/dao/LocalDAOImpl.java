/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.GenericDAO;
import br.ufra.acai.dao.servicos.LocalDAO;
import br.ufra.acai.entidade.Local;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class LocalDAOImpl extends GenericDAO implements LocalDAO {

    public LocalDAOImpl() {
    }

    @Override
    public boolean criar(Local o) {
        try {
            this.iniciarTransacao();
            this.getEntityManager().persist(o);
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
    public boolean atualizar(Local o) {
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
    public boolean excluir(Local o) {
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
    public Local obter(Object id) {
        if (id == null) {
            return null;
        }
        String query = Local.class.getSimpleName() + ".findById";
        final Query q = this.getEntityManager().createNamedQuery(query);
        Local t = (Local) q.setParameter("id", id).getSingleResult();
        return t;
    }

    @Override
    public List<Local> obterTodos() {
        List<Local> resposta = null;
        String query = Local.class.getSimpleName() + ".findAll";
        Query q = this.getEntityManager().createNamedQuery(query);
        resposta = q.getResultList();
        return resposta;
    }
}
