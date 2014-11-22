/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao;

import br.ufra.acai.dao.servicos.GenericDAO;
import br.ufra.acai.dao.servicos.UsuarioDAO;
import br.ufra.acai.entidade.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class UsuarioDAOImpl extends GenericDAO implements UsuarioDAO {

    /**
     *
     * @param acesso Parametro de loginf
     * @return
     */
    @Override
    public Usuario obter(String acesso) {
        String query = "SELECT u FROM Usuario u WHERE u.email = :acesso OR "
                + "u.username = :acesso";
        Usuario resultado;
        try {
            Query q = this.getEntityManager().createQuery(query).setParameter("acesso", acesso);
            resultado = (Usuario) q.getSingleResult();
            return resultado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean criar(Usuario o) {
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
    public boolean atualizar(Usuario o) {
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
    public boolean excluir(Usuario o) {
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
    public Usuario obter(Object id) {
        if (id == null) {
            return null;
        }
        String query = Usuario.class.getSimpleName() + ".findById";
        final Query q = this.getEntityManager().createNamedQuery(query);
        Usuario t = (Usuario) q.setParameter("id", id).getSingleResult();
        return t;
    }

    @Override
    public List<Usuario> obterTodos() {
        List<Usuario> resposta = null;
        String query = Usuario.class.getSimpleName() + ".findAll";
        Query q = this.getEntityManager().createNamedQuery(query);
        resposta = q.getResultList();
        return resposta;
    }

}
