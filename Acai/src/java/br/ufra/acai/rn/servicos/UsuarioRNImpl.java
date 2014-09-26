package br.ufra.acai.rn.servicos;

import br.ufra.acai.dao.servicos.UsuarioDAOImpl;
import br.ufra.acai.entidade.Usuario;
import br.ufra.acai.rn.UsuarioRN;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class UsuarioRNImpl implements UsuarioRN<Usuario> {

    private final UsuarioDAOImpl usuario_dao;

    public UsuarioRNImpl() {
        usuario_dao = new UsuarioDAOImpl();
    }

    @Override
    public Usuario obter(String acesso) {
        return usuario_dao.obter(acesso);
    }

    @Override
    public boolean salvar(Usuario t) {
        if (t.getId() == null) {
            return usuario_dao.criar(t);
        } else {
            return usuario_dao.atualizar(t);
        }
    }

    @Override
    public boolean remover(Usuario t) {
        return usuario_dao.excluir(t);
    }

    @Override
    public Usuario obter(Class<Usuario> classe, Object id) {
        return usuario_dao.obter(classe, id);
    }

    @Override
    public List<Usuario> obterTodos(Class<Usuario> classe) {
        return usuario_dao.obterTodos(classe);
    }

}
