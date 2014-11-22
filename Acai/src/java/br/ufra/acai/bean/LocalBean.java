/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Local;
import br.ufra.acai.entidade.Rasa;
import br.ufra.acai.rn.LocalRN;
import br.ufra.acai.rn.RasaRN;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ufrastic
 */
@ManagedBean
@RequestScoped
public class LocalBean {

    private Local local = new Local();
    private final LocalRN rn_local = new LocalRN();

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void salvar() {
        if (rn_local.salvar(local)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível atualizar/criar a local, verifique se já não existe uma rasa com essa identificação");
        }
    }
}
