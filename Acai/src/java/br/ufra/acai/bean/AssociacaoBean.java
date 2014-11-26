/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Associacao;
import br.ufra.acai.rn.AssociacaoRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ufrastic
 */
@ManagedBean
@RequestScoped
public class AssociacaoBean {

    private Associacao associacao = new Associacao();
    private List<Associacao> listaAssociacoes;
    private final AssociacaoRN rn_associacao = new AssociacaoRN();

    public Associacao getAssociacao() {
        return associacao;
    }

    public void setAssociacao(Associacao associacao) {
        this.associacao = associacao;
    }

    public List<Associacao> getListaAssociacoes() {
        return listaAssociacoes;
    }
    
    public String editar(){
        return "/sistema/cadastro/associacao/formulario.jsf";
    }
    
    public void excluir(){
        if (rn_associacao.remover(associacao)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível excluir a associacão, verifique se já não existe uma rasa com essa identificação");
        }
    }

    public void salvar() {
        if (rn_associacao.salvar(associacao)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível atualizar/criar a associacão, verifique se já não existe uma rasa com essa identificação");
        }
        associacao = new Associacao();
    }
}
