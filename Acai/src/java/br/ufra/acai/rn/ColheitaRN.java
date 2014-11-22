/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.rn;

import br.ufra.acai.dao.servicos.ColheitaDAO;
import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.entidade.Colheita;
import br.ufra.acai.entidade.Produtor;
import br.ufra.acai.spring.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class ColheitaRN {

    private final ColheitaDAO colheita_dao;

    public ColheitaRN() {
        colheita_dao = FabricaDAO.criarColheitaDAO();
    }

    public boolean salvar(Colheita t) {
        if (t.getId() == null) {
            for (Produtor produtor : Util.obterUsuarioLogado().getProdutorList()) {
                t.setProdutor(produtor);
            }
            return colheita_dao.criar(t);
        } else {
            return colheita_dao.atualizar(t);
        }
    }

    public boolean remover(Colheita t) {
        return colheita_dao.excluir(t);
    }

    public Colheita obter(Object id) {
        return colheita_dao.obter(id);
    }

    public List<Colheita> obterTodos() {
        return colheita_dao.obterTodos();
    }

//    public List<Colheita> autoCompleteColheita(String busca) {
//        List<Colheita> resposta = new ArrayList<Colheita>();
//        for (Colheita colheita : obterTodos()) {
//            if (colheita.getDataColheita()) {
//                resposta.add(colheita);
//            }
//            return resposta;
//        }
//    }
}
