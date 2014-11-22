/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.rn;

import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.dao.servicos.ProdutoDAO;
import br.ufra.acai.entidade.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class ProdutoRN {

    private final ProdutoDAO produto_dao;

    public ProdutoRN() {
        produto_dao = FabricaDAO.criarProdutoDAO();
    }

    public boolean salvar(Produto t) {
        if (t.getId() == null) {
            return produto_dao.criar(t);
        } else {
            return produto_dao.atualizar(t);
        }
    }

    public boolean remover(Produto t) {
        return produto_dao.excluir(t);
    }

    public Produto obter(Object id) {
        return produto_dao.obter(id);
    }

    public List<Produto> obterTodos() {
        return produto_dao.obterTodos();
    }
}
