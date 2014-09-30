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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "produtor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtor.findAll", query = "SELECT p FROM Produtor p"),
    @NamedQuery(name = "Produtor.findById", query = "SELECT p FROM Produtor p WHERE p.id = :id"),
    @NamedQuery(name = "Produtor.findByNome", query = "SELECT p FROM Produtor p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produtor.findBySobrenome", query = "SELECT p FROM Produtor p WHERE p.sobrenome = :sobrenome"),
    @NamedQuery(name = "Produtor.findByRg", query = "SELECT p FROM Produtor p WHERE p.rg = :rg"),
    @NamedQuery(name = "Produtor.findByCpf", query = "SELECT p FROM Produtor p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Produtor.findByTelefone", query = "SELECT p FROM Produtor p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Produtor.findByEmail", query = "SELECT p FROM Produtor p WHERE p.email = :email"),
    @NamedQuery(name = "Produtor.findByLocalizacao", query = "SELECT p FROM Produtor p WHERE p.localizacao = :localizacao"),
    @NamedQuery(name = "Produtor.findByCnpj", query = "SELECT p FROM Produtor p WHERE p.cnpj = :cnpj")})
public class Produtor implements Serializable {
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
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "localizacao")
    private String localizacao;
    @Column(name = "cnpj")
    private String cnpj;
    @JoinColumn(name = "responsavel", referencedColumnName = "id")
    @ManyToOne
    private Responsavel responsavel;
    @JoinColumn(name = "associacao", referencedColumnName = "associacao")
    @ManyToOne
    private Associacao associacao;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtor")
    private List<Extracao> extracaoList;

    public Produtor() {
    }

    public Produtor(Integer id) {
        this.id = id;
    }

    public Produtor(Integer id, String nome, String sobrenome, String rg, String cpf, String telefone, String email, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.localizacao = localizacao;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Associacao getAssociacao() {
        return associacao;
    }

    public void setAssociacao(Associacao associacao) {
        this.associacao = associacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtor)) {
            return false;
        }
        Produtor other = (Produtor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Produtor[ id=" + id + " ]";
    }
    
}
