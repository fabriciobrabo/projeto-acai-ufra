/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Produtor;
import br.ufra.acai.rn.ProdutorRN;
import br.ufra.acai.spring.Util;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ufrastic
 */
@ManagedBean
@RequestScoped
public class ProdutorBean {

    public ProdutorBean() {
        for (Produtor var : Util.obterUsuarioLogado().getProdutorList()) {
            produtor = var;
        }
    }

    private Produtor produtor;
    private final ProdutorRN rn_produtor = new ProdutorRN();

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
    
    public void salvar(){
        if (rn_produtor.salvar(produtor)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito! Perfil Cadastrado");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! Não foi possível atualizar o perfil");
        }
    }
}
