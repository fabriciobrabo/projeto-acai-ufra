/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao.servicos;

import br.ufra.acai.entidade.Associacao;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface AssociacaoDAO {

    public boolean criar(Associacao o);

    public boolean atualizar(Associacao o);

    public boolean excluir(Associacao o);

    public Associacao obter(Object id);

    public List<Associacao> obterTodos();
}
