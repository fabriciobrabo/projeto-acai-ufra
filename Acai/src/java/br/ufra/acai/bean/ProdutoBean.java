/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Produto;
import br.ufra.acai.rn.ProdutoRN;
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
public class ProdutoBean {

    private Produto produto = new Produto();
    private final ProdutoRN rn_produto = new ProdutoRN();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void salvar() {
        if (rn_produto.salvar(produto)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível atualizar/criar o produto, verifique se já não existe uma rasa com essa identificação");
        }
    }
}
