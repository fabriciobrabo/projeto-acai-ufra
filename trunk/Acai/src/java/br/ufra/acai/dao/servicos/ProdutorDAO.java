package br.ufra.acai.dao.servicos;

import br.ufra.acai.entidade.Produtor;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface ProdutorDAO {

    public List<Produtor> obterTodosOrdenado(String param);

    public boolean criar(Produtor o);

    public boolean atualizar(Produtor o);

    public boolean excluir(Produtor o);

    public Produtor obter(Object id);

    public List<Produtor> obterTodos();
}
