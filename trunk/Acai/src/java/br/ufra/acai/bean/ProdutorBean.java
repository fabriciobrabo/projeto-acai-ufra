/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.bean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Produtor;
import br.ufra.acai.rn.servicos.ProdutorRNImpl;
import javax.faces.application.FacesMessage;
@ManagedBean
@RequestScoped
public class ProdutorBean {
    ProdutorRNImpl rn = new ProdutorRNImpl();
    Produtor produtor = new Produtor();
    List<Produtor> produtores;
}
