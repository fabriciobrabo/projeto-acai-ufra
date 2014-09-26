package br.ufra.acai.rn.servicos;

import br.ufra.acai.dao.servicos.ProdutorDAOImpl;
import br.ufra.acai.entidade.Produtor;
import br.ufra.acai.rn.ProdutorRN;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class ProdutorRNImpl implements ProdutorRN<Produtor> {

    private final ProdutorDAOImpl produtor_dao;

    public ProdutorRNImpl() {
        produtor_dao = new ProdutorDAOImpl();
    }

    @Override
    public List<Produtor> obterTodosOrdenadoNome() {
        return produtor_dao.obterTodosOrdenado(Produtor.class, "nome");
    }

    @Override
    public boolean salvar(Produtor t) {
        if (t.getId() == null) {
            return produtor_dao.criar(t);
        } else {
            return produtor_dao.atualizar(t);
        }
    }

    @Override
    public boolean remover(Produtor t) {
        return produtor_dao.excluir(t);
    }

    @Override
    public Produtor obter(Class<Produtor> classe, Object id) {
        return produtor_dao.obter(classe, id);
    }

    @Override
    public List<Produtor> obterTodos(Class<Produtor> classe) {
        return produtor_dao.obterTodos(classe);
    }

}
