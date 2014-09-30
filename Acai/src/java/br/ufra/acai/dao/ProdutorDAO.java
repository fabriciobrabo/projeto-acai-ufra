package br.ufra.acai.dao;

import br.ufra.acai.entidade.Produtor;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface ProdutorDAO {

    public List<Produtor> obterTodosOrdenado(String param);
}
