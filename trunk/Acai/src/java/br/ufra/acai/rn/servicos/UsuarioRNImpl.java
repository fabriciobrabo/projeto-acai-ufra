package br.ufra.acai.rn.servicos;

import br.ufra.acai.dao.servicos.UsuarioDAOImpl;
import br.ufra.acai.entidade.Produtor;
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

    public Usuario obter(String acesso) {
        return usuario_dao.obter(acesso);
    }

    public boolean salvar(Usuario t, Produtor o) {
        if (t.getProdutorList().isEmpty()) {
            t.getProdutorList().add(o);
            if (t.getId() == null) {
                return usuario_dao.criar(t);
            } else {
                return usuario_dao.atualizar(t);
            }
        } else {
            return false;
        }
    }

    public boolean remover(Usuario t) {
        return usuario_dao.excluir(t);
    }

    public Usuario obter(Object id) {
        return usuario_dao.obter(Usuario.class, id);
    }

    public List<Usuario> obterTodos() {
        return usuario_dao.obterTodos(Usuario.class);
    }

}
