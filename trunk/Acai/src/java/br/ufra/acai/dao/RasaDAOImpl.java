/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.GenericDAO;
import br.ufra.acai.dao.servicos.RasaDAO;
import br.ufra.acai.entidade.Rasa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class RasaDAOImpl extends GenericDAO implements RasaDAO {

    @Override
    public boolean criar(Rasa o) {
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
    public boolean atualizar(Rasa o) {
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
    public boolean excluir(Rasa o) {
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
    public Rasa obter(Object id) {
        if (id == null) {
            return null;
        }
        String query = Rasa.class.getSimpleName() + ".findById";
        final Query q = this.getEntityManager().createNamedQuery(query);
        Rasa t = (Rasa) q.setParameter("id", id).getSingleResult();
        return t;
    }

    @Override
    public List<Rasa> obterTodos() {
        List<Rasa> resposta = null;
        String query = Rasa.class.getSimpleName() + ".findAll";
        Query q = this.getEntityManager().createNamedQuery(query);
        resposta = q.getResultList();
        return resposta;
    }
}
