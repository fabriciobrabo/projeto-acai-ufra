

package br.ufra.acai.bean.util;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class BeanUtil implements Serializable{
    public static void mensagem(Severity severity, String mensagem){
        FacesMessage fm= new FacesMessage(severity, mensagem,null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
}
