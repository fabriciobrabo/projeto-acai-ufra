/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ufrastic
 */
@Entity
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findById", query = "SELECT l FROM Local l WHERE l.id = :id"),
    @NamedQuery(name = "Local.findByNome", query = "SELECT l FROM Local l WHERE l.nome = :nome"),
    @NamedQuery(name = "Local.findByLocalidade", query = "SELECT l FROM Local l WHERE l.localidade = :localidade"),
    @NamedQuery(name = "Local.findByEstado", query = "SELECT l FROM Local l WHERE l.estado = :estado"),
    @NamedQuery(name = "Local.findByLatitude", query = "SELECT l FROM Local l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "Local.findByLongitude", query = "SELECT l FROM Local l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "Local.findByValidado", query = "SELECT l FROM Local l WHERE l.validado = :validado")})
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "localidade")
    private String localidade;
    @Lob
    @Column(name = "complemento")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "validado")
    private Boolean validado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local", orphanRemoval = true)
    private List<Colheita> colheitaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local", orphanRemoval = true)
    private List<Produtor> produtorList;

    public Local() {
    }

    public Local(Integer id) {
        this.id = id;
    }

    public Local(Integer id, String nome, String localidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.localidade = localidade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    @XmlTransient
    public List<Colheita> getColheitaList() {
        return colheitaList;
    }

    public void setColheitaList(List<Colheita> colheitaList) {
        this.colheitaList = colheitaList;
    }

    @XmlTransient
    public List<Produtor> getProdutorList() {
        return produtorList;
    }

    public void setProdutorList(List<Produtor> produtorList) {
        this.produtorList = produtorList;
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
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Local[ id=" + id + " ]";
    }
    
}
