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
 * @author ufrastic
 */
@Entity
@Table(name = "colheita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colheita.findAll", query = "SELECT c FROM Colheita c"),
    @NamedQuery(name = "Colheita.findById", query = "SELECT c FROM Colheita c WHERE c.id = :id"),
    @NamedQuery(name = "Colheita.findByDataColheita", query = "SELECT c FROM Colheita c WHERE c.dataColheita = :dataColheita"),
    @NamedQuery(name = "Colheita.findByPeso", query = "SELECT c FROM Colheita c WHERE c.peso = :peso"),
    @NamedQuery(name = "Colheita.findByObservacao", query = "SELECT c FROM Colheita c WHERE c.observacao = :observacao")})
public class Colheita implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colheita", orphanRemoval = true)
    private List<Produto> produtoList;
    @JoinColumn(name = "local", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Local local;
    @JoinColumn(name = "produtor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produtor produtor;

    public Colheita() {
    }

    public Colheita(Integer id) {
        this.id = id;
    }

    public Colheita(Integer id, Date dataColheita) {
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
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
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
        if (!(object instanceof Colheita)) {
            return false;
        }
        Colheita other = (Colheita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Colheita[ id=" + id + " ]";
    }
    
}
