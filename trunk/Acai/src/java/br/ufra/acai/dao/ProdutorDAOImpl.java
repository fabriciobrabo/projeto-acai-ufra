/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.GenericDAO;
import br.ufra.acai.dao.servicos.ProdutorDAO;
import br.ufra.acai.entidade.Produtor;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class ProdutorDAOImpl extends GenericDAO implements ProdutorDAO {

    @Override
    public List<Produtor> obterTodosOrdenado(String param) {
        List<Produtor> resposta = null;
        String query = "SELECT c FROM Produtor c ORDER BY c." + param;
        Query q = this.getEntityManager().createQuery(query);
        resposta = (List<Produtor>) q.getResultList();
        return resposta;
    }

    @Override
    public boolean criar(Produtor o) {
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
    public boolean atualizar(Produtor o) {
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
    public boolean excluir(Produtor o) {
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
    public Produtor obter(Object id) {
        if (id == null) {
            return null;
        }
        String query = Produtor.class.getSimpleName() + ".findById";
        final Query q = this.getEntityManager().createNamedQuery(query);
        Produtor t = (Produtor) q.setParameter("id", id).getSingleResult();
        return t;
    }

    @Override
    public List<Produtor> obterTodos() {
        List<Produtor> resposta = null;
        String query = Produtor.class.getSimpleName() + ".findAll";
        Query q = this.getEntityManager().createNamedQuery(query);
        resposta = q.getResultList();
        return resposta;
    }

}
