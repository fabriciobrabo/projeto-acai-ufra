/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ISARH-UFRA
 */
@Entity
@Table(name = "extracao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extracao.findAll", query = "SELECT e FROM Extracao e"),
    @NamedQuery(name = "Extracao.findById", query = "SELECT e FROM Extracao e WHERE e.id = :id"),
    @NamedQuery(name = "Extracao.findByDataColheita", query = "SELECT e FROM Extracao e WHERE e.dataColheita = :dataColheita"),
    @NamedQuery(name = "Extracao.findByPeso", query = "SELECT e FROM Extracao e WHERE e.peso = :peso"),
    @NamedQuery(name = "Extracao.findByObservacao", query = "SELECT e FROM Extracao e WHERE e.observacao = :observacao")})
public class Extracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_colheita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataColheita;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "observacao")
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "extracao")
    private List<ItemProduto> itemProdutoList;
    @JoinColumn(name = "produtor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produtor produtor;
    @JoinColumn(name = "local", referencedColumnName = "local")
    @ManyToOne(optional = false)
    private Local local;

    public Extracao() {
    }

    public Extracao(Integer id) {
        this.id = id;
    }

    public Extracao(Integer id, Date dataColheita) {
        this.id = id;
        this.dataColheita = dataColheita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(Date dataColheita) {
        this.dataColheita = dataColheita;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public List<ItemProduto> getItemProdutoList() {
        return itemProdutoList;
    }

    public void setItemProdutoList(List<ItemProduto> itemProdutoList) {
        this.itemProdutoList = itemProdutoList;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extracao)) {
            return false;
        }
        Extracao other = (Extracao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Extracao[ id=" + id + " ]";
    }
    
}
