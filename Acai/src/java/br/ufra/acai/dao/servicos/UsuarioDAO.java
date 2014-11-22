/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.dao.servicos;

import br.ufra.acai.entidade.Usuario;
import java.util.List;

/**
 *
 * @author fabricio correa brabo
 */
public interface UsuarioDAO {

    public Usuario obter(String acesso);

    public boolean criar(Usuario o);

    public boolean atualizar(Usuario o);

    public boolean excluir(Usuario o);

    public Usuario obter(Object id);

    public List<Usuario> obterTodos();
}
