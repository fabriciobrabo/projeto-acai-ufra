/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao.servicos;

import br.ufra.acai.entidade.Local;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface LocalDAO {

    public boolean criar(Local o);

    public boolean atualizar(Local o);

    public boolean excluir(Local o);

    public Local obter(Object id);

    public List<Local> obterTodos();
}
