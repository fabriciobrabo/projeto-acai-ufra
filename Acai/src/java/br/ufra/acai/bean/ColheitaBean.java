/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Colheita;
import br.ufra.acai.rn.ColheitaRN;
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
public class ColheitaBean {

    private Colheita colheita = new Colheita();
    private List<Colheita> listaColheitas;
    private final ColheitaRN rn_colheita = new ColheitaRN();

    public Colheita getColheita() {
        return colheita;
    }

    public void setColheita(Colheita rasa) {
        this.colheita = rasa;
    }

    public List<Colheita> getListaColheitas() {
        return listaColheitas;
    }

    public List<Colheita> autoCompleteColheita(String busca) {
        return rn_colheita.autoCompleteColheita(busca);
    }

    public void salvar() {
        if (rn_colheita.salvar(colheita)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível atualizar/criar a colheita, verifique se já não existe uma rasa com essa identificação");
        }
        colheita = new Colheita();
    }
}
