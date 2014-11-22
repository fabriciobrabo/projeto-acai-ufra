/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.dao.servicos;

import br.ufra.acai.entidade.Colheita;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface ColheitaDAO {
    
    public boolean criar(Colheita o);

    public boolean atualizar(Colheita o);

    public boolean excluir(Colheita o);

    public Colheita obter(Object id);

    public List<Colheita> obterTodos();
}
