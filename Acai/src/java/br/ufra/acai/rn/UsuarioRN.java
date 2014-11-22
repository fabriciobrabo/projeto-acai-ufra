package br.ufra.acai.rn;

import br.ufra.acai.dao.servicos.FabricaDAO;
import br.ufra.acai.dao.servicos.UsuarioDAO;
import br.ufra.acai.entidade.Usuario;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class UsuarioRN {

    private final UsuarioDAO usuario_dao;

    public UsuarioRN() {
        usuario_dao = FabricaDAO.criarUsuarioDAO();
    }

    public Usuario obter(String acesso) {
        return usuario_dao.obter(acesso);
    }

    public boolean salvar(Usuario u) {
        if (u.getPerfil() == null) {
            u.setPerfil("ROLE_USER");
            if (u.getId() == null) {
                return usuario_dao.criar(u);
            } else {
                return usuario_dao.atualizar(u);
            }
        } else {
            return false;
        }
    }

    public boolean remover(Usuario t) {
        return usuario_dao.excluir(t);
    }

    public Usuario obter(Object id) {
        return usuario_dao.obter(id);
    }

    public List<Usuario> obterTodos() {
        return usuario_dao.obterTodos();
    }

}
