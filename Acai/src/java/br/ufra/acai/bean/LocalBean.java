/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.bean;

import br.ufra.acai.bean.util.BeanUtil;
import br.ufra.acai.entidade.Local;
import br.ufra.acai.rn.LocalRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author ufrastic
 */
@ManagedBean
@RequestScoped
public class LocalBean implements Serializable {

    private Local local = new Local();
    private MapModel draggableModel;
    private Marker marker;
    private List<Local> listaLocais;
    private final LocalRN rn_local = new LocalRN();

    public List<Local> getListaLocais() {
        listaLocais = rn_local.obterTodos();
        return listaLocais;
    }

    public MapModel getPontosLocais() {
        draggableModel = new DefaultMapModel();
        for (Local temp : rn_local.obterTodos()) {
            LatLng coord = new LatLng(temp.getLatitude(), temp.getLongitude());
            draggableModel.addOverlay(new Marker(coord, temp.getNome()));
        }
        for (Marker premarker : draggableModel.getMarkers()) {
            premarker.setDraggable(true);
        }
        return draggableModel;
    }

    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String editar() {
        return "/sistema/cadastro/local/formulario.jsf";
    }

    public void excluir() {
        if (rn_local.salvar(local)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível excluir o local.");
        }
    }

    public void salvar() {
        if (rn_local.salvar(local)) {
            BeanUtil.mensagem(FacesMessage.SEVERITY_INFO, "Feito!");
        } else {
            BeanUtil.mensagem(FacesMessage.SEVERITY_FATAL, "Erro!! "
                    + "Não foi possível atualizar/criar a local, verifique se já não existe uma rasa com essa identificação");
        }
        local = new Local();
    }
}
