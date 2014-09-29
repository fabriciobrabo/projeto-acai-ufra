/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.acai.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ISARH-UFRA
 */
@Entity
@Table(name = "rasa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rasa.findAll", query = "SELECT r FROM Rasa r"),
    @NamedQuery(name = "Rasa.findById", query = "SELECT r FROM Rasa r WHERE r.id = :id"),
    @NamedQuery(name = "Rasa.findByVolume", query = "SELECT r FROM Rasa r WHERE r.volume = :volume"),
    @NamedQuery(name = "Rasa.findByCodigo", query = "SELECT r FROM Rasa r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Rasa.findByComplemento", query = "SELECT r FROM Rasa r WHERE r.complemento = :complemento")})
public class Rasa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "volume")
    private BigDecimal volume;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "complemento")
    private String complemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rasa")
    private List<Produto> produtoList;

    public Rasa() {
    }

    public Rasa(Integer id) {
        this.id = id;
    }

    public Rasa(Integer id, BigDecimal volume) {
        this.id = id;
        this.volume = volume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
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
        if (!(object instanceof Rasa)) {
            return false;
        }
        Rasa other = (Rasa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Rasa[ id=" + id + " ]";
    }
    
}
