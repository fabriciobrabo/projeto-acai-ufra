/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bpmlab
 */
@Entity
@Table(name = "rasa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rasa.findAll", query = "SELECT r FROM Rasa r"),
    @NamedQuery(name = "Rasa.findById", query = "SELECT r FROM Rasa r WHERE r.id = :id"),
    @NamedQuery(name = "Rasa.findByPeso", query = "SELECT r FROM Rasa r WHERE r.peso = :peso"),
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
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "complemento")
    private String complemento;

    public Rasa() {
    }

    public Rasa(Integer id) {
        this.id = id;
    }

    public Rasa(Integer id, BigDecimal peso) {
        this.id = id;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
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
