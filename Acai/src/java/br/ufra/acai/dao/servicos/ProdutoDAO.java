/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao.servicos;

import br.ufra.acai.entidade.Produto;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface ProdutoDAO {

    public boolean criar(Produto o);

    public boolean atualizar(Produto o);

    public boolean excluir(Produto o);

    public Produto obter(Object id);

    public List<Produto> obterTodos();
}
