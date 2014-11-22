/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.GenericDAO;
import br.ufra.acai.dao.servicos.ProdutoDAO;
import br.ufra.acai.entidade.Produto;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class ProdutoDAOImpl extends GenericDAO implements ProdutoDAO {

    @Override
    public boolean criar(Produto o) {
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
    public boolean atualizar(Produto o) {
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
    public boolean excluir(Produto o) {
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
    public Produto obter(Object id) {
        if (id == null) {
            return null;
        }
        String query = Produto.class.getSimpleName() + ".findById";
        final Query q = this.getEntityManager().createNamedQuery(query);
        Produto t = (Produto) q.setParameter("id", id).getSingleResult();
        return t;
    }

    @Override
    public List<Produto> obterTodos() {
        List<Produto> resposta = null;
        String query = Produto.class.getSimpleName() + ".findAll";
        Query q = this.getEntityManager().createNamedQuery(query);
        resposta = q.getResultList();
        return resposta;
    }
}
