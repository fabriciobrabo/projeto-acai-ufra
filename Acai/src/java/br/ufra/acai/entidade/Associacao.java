/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author ufrastic
 */
@Entity
@Table(name = "associacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Associacao.findAll", query = "SELECT a FROM Associacao a"),
    @NamedQuery(name = "Associacao.findByAssociacao", query = "SELECT a FROM Associacao a WHERE a.associacao = :associacao"),
    @NamedQuery(name = "Associacao.findByResponsavel", query = "SELECT a FROM Associacao a WHERE a.responsavel = :responsavel"),
    @NamedQuery(name = "Associacao.findByNome", query = "SELECT a FROM Associacao a WHERE a.nome = :nome"),
    @NamedQuery(name = "Associacao.findByTelefone", query = "SELECT a FROM Associacao a WHERE a.telefone = :telefone"),
    @NamedQuery(name = "Associacao.findByEmail", query = "SELECT a FROM Associacao a WHERE a.email = :email"),
    @NamedQuery(name = "Associacao.findByLocalizacao", query = "SELECT a FROM Associacao a WHERE a.localizacao = :localizacao"),
    @NamedQuery(name = "Associacao.findByDescricaoAtividade", query = "SELECT a FROM Associacao a WHERE a.descricaoAtividade = :descricaoAtividade")})
public class Associacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "associacao")
    private Integer associacao;
    @Basic(optional = false)
    @Column(name = "responsavel")
    private String responsavel;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "localizacao")
    private String localizacao;
    @Column(name = "descricao_Atividade")
    private String descricaoAtividade;
    @OneToMany(mappedBy = "associacao")
    private List<Produtor> produtorList;

    public Associacao() {
    }

    public Associacao(Integer associacao) {
        this.associacao = associacao;
    }

    public Associacao(Integer associacao, String responsavel, String nome, String telefone, String email, String localizacao) {
        this.associacao = associacao;
        this.responsavel = responsavel;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.localizacao = localizacao;
    }

    public Integer getAssociacao() {
        return associacao;
    }

    public void setAssociacao(Integer associacao) {
        this.associacao = associacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
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
        hash += (associacao != null ? associacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Associacao)) {
            return false;
        }
        Associacao other = (Associacao) object;
        if ((this.associacao == null && other.associacao != null) || (this.associacao != null && !this.associacao.equals(other.associacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Associacao[ associacao=" + associacao + " ]";
    }
    
}
