/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Produtor;
import br.ufra.acai.entidade.Usuario;
import br.ufra.acai.rn.UsuarioRN;
import br.ufra.acai.spring.Util;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UsuarioBean {

    private final UsuarioRN rn_usuario = new UsuarioRN();
    private Usuario usuario = new Usuario();
    private Produtor produtor = new Produtor();
    private List<Usuario> listaUsuarios;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        listaUsuarios = rn_usuario.obterTodos();
        return listaUsuarios;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public String salvar() {
        if (usuario.getProdutorList() == null) {
            usuario.setProdutorList(new ArrayList<Produtor>());
            produtor.setUsuario(usuario);
            usuario.getProdutorList().add(produtor);
        }
        if (rn_usuario.salvar(usuario)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Sucesso! O usuário "
                    + produtor.getNome() + " " + produtor.getSobrenome() + " foi cadastrado");
            return "/acesso/login.jsf";
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! Não foi possível realizar o cadastro");
            return null;
        }
    }

    public void remover() {
        if (rn_usuario.remover(usuario)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Sucesso! O usuário foi removido");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! Não foi possível remover o usuário");

        }
    }

    public String autenticar() {
        return "/sistema/inicio.xhtml";
    }

    public String logout() {
        Util.encerrarSessao();
        return "/acesso/login.xhtml";
    }

    public String visualizarPerfil() {
        return "/cadastro/perfil/lista.xhtml";
    }

    public String editar() {
        return "/cadastro/perfil/formulario.xhtml";
    }

}
