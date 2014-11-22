/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao.servicos;

import br.ufra.acai.entidade.Rasa;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface RasaDAO {

    public boolean criar(Rasa o);

    public boolean atualizar(Rasa o);

    public boolean excluir(Rasa o);

    public Rasa obter(Object id);

    public List<Rasa> obterTodos();
}
