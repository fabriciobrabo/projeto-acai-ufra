/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.rn;

import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.dao.servicos.LocalDAO;
import br.ufra.acai.entidade.Local;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class LocalRN {

    private final LocalDAO rasa_dao;

    public LocalRN() {
        rasa_dao = FabricaDAO.criarLocalDAO();
    }

    public boolean salvar(Local t) {
        if (t.getId()== null) {
            return rasa_dao.criar(t);
        } else {
            return rasa_dao.atualizar(t);
        }
    }

    public boolean remover(Local t) {
        return rasa_dao.excluir(t);
    }

    public Local obter(Object id) {
        return rasa_dao.obter(id);
    }

    public List<Local> obterTodos() {
        return rasa_dao.obterTodos();
    }
}
