/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.bean;

import br.ufra.acai.entidade.Usuario;
import br.ufra.acai.rn.servicos.UsuarioRNImpl;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.ufra.acai.bean.util.BeanUtil;
import javax.faces.application.FacesMessage;

@ManagedBean
@RequestScoped
public class UsuarioBean {
    private final UsuarioRNImpl rn = new UsuarioRNImpl();
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        usuarios=rn.obterTodos(Usuario.class);
        return usuarios;
    }
    
    public void salvar(){
        if(rn.salvar(usuario)){
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Sucesso! O usuário foi salvo");
        }else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! Não foi possível salvar o usuário");
        }
    }
    public void remover(){
        if(rn.remover(usuario)){
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Sucesso! O usuário foi removido");
        }else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! Não foi possível remover o usuário");
   
        }
    }
    public String autenticar(){
        return "/sistema/inicio.xhtml";
    }
    public String deslogar(){
        return "/acesso/login.xhtml";
    }
   
    public String visualizarPerfil(){
        return "/cadastro/perfil/lista.xhtml";
    }
    public String editar(){
        return "/cadastro/perfil/formulario.xhtml";
    }
  
    
    

    
    
    
}
