/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.rn;

import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.dao.servicos.RasaDAO;
import br.ufra.acai.entidade.Rasa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class RasaRN {

    private final RasaDAO rasa_dao;

    public RasaRN() {
        rasa_dao = FabricaDAO.criarRasaDAO();
    }

    public boolean salvar(Rasa t) {
        if (t.getId() == null) {
            return rasa_dao.criar(t);
        } else {
            return rasa_dao.atualizar(t);
        }
    }

    public boolean remover(Rasa t) {
        return rasa_dao.excluir(t);
    }

    public Rasa obter(Object id) {
        return rasa_dao.obter(id);
    }

    public List<Rasa> obterTodos() {
        return rasa_dao.obterTodos();
    }
    
    public List<Rasa> autoCompleteRasa(String busca) {
        List<Rasa> resposta = new ArrayList<Rasa>();
        for (Rasa rasa : obterTodos()) {
            if (!(rasa.getCodigo().toUpperCase().contains(busca.toUpperCase()))) {
                //Não encontrou o codigo, então tenta pelo id
                if (rasa.getId().toString().contains(busca)) {
                    resposta.add(rasa);
                    break;
                }
            } else {
                //Encontrou então adiciona
                resposta.add(rasa);
            }
        }
        return resposta;
    }
}
