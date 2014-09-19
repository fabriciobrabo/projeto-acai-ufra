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
 * @author fabricio correa brabo
 */
@Entity
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findByLocal", query = "SELECT l FROM Local l WHERE l.local = :local"),
    @NamedQuery(name = "Local.findByNome", query = "SELECT l FROM Local l WHERE l.nome = :nome"),
    @NamedQuery(name = "Local.findByCidade", query = "SELECT l FROM Local l WHERE l.cidade = :cidade"),
    @NamedQuery(name = "Local.findByEstado", query = "SELECT l FROM Local l WHERE l.estado = :estado"),
    @NamedQuery(name = "Local.findByCoordenadas", query = "SELECT l FROM Local l WHERE l.coordenadas = :coordenadas")})
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "local")
    private Integer local;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Lob
    @Column(name = "complemento")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Column(name = "coordenadas")
    private String coordenadas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private List<Extracao> extracaoList;

    public Local() {
    }

    public Local(Integer local) {
        this.local = local;
    }

    public Local(Integer local, String nome, String cidade, String estado) {
        this.local = local;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    @XmlTransient
    public List<Extracao> getExtracaoList() {
        return extracaoList;
    }

    public void setExtracaoList(List<Extracao> extracaoList) {
        this.extracaoList = extracaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (local != null ? local.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.local == null && other.local != null) || (this.local != null && !this.local.equals(other.local))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Local[ local=" + local + " ]";
    }
    
}
