/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.spring;

import br.ufra.acai.entidade.Usuario;
import br.ufra.acai.rn.UsuarioRN;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ufrastic
 */
public class Util {

    private static final UsuarioRN rn_usuario = new UsuarioRN();

    public static Usuario obterUsuarioLogado() {
        FacesContext f = FacesContext.getCurrentInstance();
        ExternalContext e = f.getExternalContext();

        return rn_usuario.obter(e.getRemoteUser());
    }

    public static void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Object session = externalContext.getSession(true);
        if (session instanceof HttpSession) {
            ((HttpSession) session).invalidate();
        }
    }
}
