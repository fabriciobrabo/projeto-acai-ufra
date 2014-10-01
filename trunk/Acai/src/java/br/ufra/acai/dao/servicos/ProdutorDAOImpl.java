/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao.servicos;

import br.ufra.acai.dao.ProdutorDAO;
import br.ufra.acai.entidade.Produtor;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class ProdutorDAOImpl extends GenericDAOImpl<Produtor> implements ProdutorDAO {

    @Override
    public List<Produtor> obterTodosOrdenado(String param) {
        List<Produtor> resposta = null;
        String query = "SELECT c FROM Produtor c ORDER BY c." + param;
        Query q = this.getEntityManager().createQuery(query);
        resposta = (List<Produtor>) q.getResultList();
        return resposta;
    }
    
}
