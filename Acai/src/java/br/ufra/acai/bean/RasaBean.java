/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Rasa;
import br.ufra.acai.rn.RasaRN;
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
public class RasaBean {

    private Rasa rasa = new Rasa();
    private List<Rasa> listaRasas;
    private final RasaRN rn_rasa = new RasaRN();

    public Rasa getRasa() {
        return rasa;
    }

    public void setRasa(Rasa rasa) {
        this.rasa = rasa;
    }

    public List<Rasa> getListaRasas() {
        listaRasas = rn_rasa.obterTodos();
        return listaRasas;
    }

    public List<Rasa> autoCompleteRasa(String busca) {
        return rn_rasa.autoCompleteRasa(busca);
    }

    public String editar() {
        return "/sistema/cadastro/rasa/formulario.jsf";
    }

    public void excluir() {
        if (rn_rasa.remover(rasa)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível excluir a rasa, verifique se já não existe uma rasa com essa identificação");
        }
    }

    public void salvar() {
        if (rn_rasa.salvar(rasa)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível atualizar/criar a rasa, verifique se já não existe uma rasa com essa identificação");
        }
        rasa = new Rasa();
    }
}
