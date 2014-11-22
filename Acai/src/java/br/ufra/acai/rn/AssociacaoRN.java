/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.rn;

import br.ufra.acai.dao.servicos.AssociacaoDAO;
import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.entidade.Associacao;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class AssociacaoRN {

    private final AssociacaoDAO rasa_dao;

    public AssociacaoRN() {
        rasa_dao = FabricaDAO.criarAssociacaoDAO();
    }

    public boolean salvar(Associacao t) {
        if (t.getId() == null) {
            return rasa_dao.criar(t);
        } else {
            return rasa_dao.atualizar(t);
        }
    }

    public boolean remover(Associacao t) {
        return rasa_dao.excluir(t);
    }

    public Associacao obter(Object id) {
        return rasa_dao.obter(id);
    }

    public List<Associacao> obterTodos() {
        return rasa_dao.obterTodos();
    }
}
