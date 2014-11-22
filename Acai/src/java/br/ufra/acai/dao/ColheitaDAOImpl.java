/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.ColheitaDAO;
import br.ufra.acai.dao.servicos.GenericDAO;
import br.ufra.acai.entidade.Colheita;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class ColheitaDAOImpl extends GenericDAO implements ColheitaDAO {

    @Override
    public boolean criar(Colheita o) {
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
    public boolean atualizar(Colheita o) {
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
    public boolean excluir(Colheita o) {
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
    public Colheita obter(Object id) {
        if (id == null) {
            return null;
        }
        String query = Colheita.class.getSimpleName() + ".findById";
        final Query q = this.getEntityManager().createNamedQuery(query);
        Colheita t = (Colheita) q.setParameter("id", id).getSingleResult();
        return t;
    }

    @Override
    public List<Colheita> obterTodos() {
        List<Colheita> resposta = null;
        String query = Colheita.class.getSimpleName() + ".findAll";
        Query q = this.getEntityManager().createNamedQuery(query);
        resposta = q.getResultList();
        return resposta;
    }
}
