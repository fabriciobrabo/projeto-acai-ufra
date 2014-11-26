/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean.conversor;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Rasa;
import br.ufra.acai.rn.RasaRN;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ufrastic
 */
@FacesConverter(value = "rasaConversor")
public class RasaConversor implements Converter {

    private RasaRN rn_rasa;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Rasa resposta = null;
        if (value == null || value.equals("")) {
            return null;
        } else {
            rn_rasa = new RasaRN();
            try {
                resposta = rn_rasa.obter(new Integer(value));
                return resposta;
            } catch (Exception e) {
                BeanUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Falha de validação\n"
                        + "É preciso selecionar um ítem do campo de texto auto completável");
                return null;
            }
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value == null) {
            return "";
        } else if (value instanceof Rasa) {
            Integer id = ((Rasa) value).getId();
            if (id != null) {
                return id.toString();
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
