package br.ufra.acai.rn;

import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.dao.servicos.ProdutorDAO;
import br.ufra.acai.entidade.Produtor;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class ProdutorRN {

    private final ProdutorDAO produtor_dao;

    public ProdutorRN() {
        produtor_dao = FabricaDAO.criarProdutorDAO();
    }

    public List<Produtor> obterTodosOrdenadoNome() {
        return produtor_dao.obterTodosOrdenado("nome");
    }

    public boolean salvar(Produtor t) {
        if (t.getId() == null) {
            return produtor_dao.criar(t);
        } else {
            return produtor_dao.atualizar(t);
        }
    }

    public boolean remover(Produtor t) {
        return produtor_dao.excluir(t);
    }

    public Produtor obter(Object id) {
        return produtor_dao.obter(id);
    }

    public List<Produtor> obterTodos() {
        return produtor_dao.obterTodos();
    }

}
