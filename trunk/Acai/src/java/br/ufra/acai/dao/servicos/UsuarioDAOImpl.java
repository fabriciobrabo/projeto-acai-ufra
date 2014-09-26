/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao.servicos;

import br.ufra.acai.dao.UsuarioDAO;
import br.ufra.acai.entidade.Usuario;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO<Usuario> {

    /**
     *
     * @param acesso Parametro de login
     * @return
     */
    @Override
    public Usuario obter(String acesso) {
        String query = "SELECT u FROM Usuario u WHERE u.email = :acesso OR "
                + "u.username = :acesso";
        Usuario resultado;
        try {
            Query q = super.getEntityManager().createQuery(query).setParameter("acesso", acesso);
            resultado = (Usuario) q.getSingleResult();
            return resultado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
