/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.AssociacaoDAO;
import br.ufra.acai.dao.servicos.GenericDAO;
import br.ufra.acai.entidade.Associacao;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class AssociacaoDAOImpl extends GenericDAO implements AssociacaoDAO {

    public AssociacaoDAOImpl() {
    }

    @Override
    public boolean criar(Associacao o) {
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
    public boolean atualizar(Associacao o) {
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
    public boolean excluir(Associacao o) {
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
    public Associacao obter(Object id) {
        if (id == null) {
            return null;
        }
        String query = Associacao.class.getSimpleName() + ".findById";
        final Query q = this.getEntityManager().createNamedQuery(query);
        Associacao t = (Associacao) q.setParameter("id", id).getSingleResult();
        return t;
    }

    @Override
    public List<Associacao> obterTodos() {
        List<Associacao> resposta = null;
        String query = Associacao.class.getSimpleName() + ".findAll";
        Query q = this.getEntityManager().createNamedQuery(query);
        resposta = q.getResultList();
        return resposta;
    }
}
