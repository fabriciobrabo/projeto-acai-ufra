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
 * @author ISARH-UFRA
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByPeso", query = "SELECT p FROM Produto p WHERE p.peso = :peso"),
    @NamedQuery(name = "Produto.findByDataVenda", query = "SELECT p FROM Produto p WHERE p.dataVenda = :dataVenda"),
    @NamedQuery(name = "Produto.findByQrcode", query = "SELECT p FROM Produto p WHERE p.qrcode = :qrcode"),
    @NamedQuery(name = "Produto.findByPrecoVenda", query = "SELECT p FROM Produto p WHERE p.precoVenda = :precoVenda"),
    @NamedQuery(name = "Produto.findByTipoTransporte", query = "SELECT p FROM Produto p WHERE p.tipoTransporte = :tipoTransporte"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade")})
public class Produto implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "data_venda")
    private String dataVenda;
    @Column(name = "qrcode")
    private String qrcode;
    @Column(name = "preco_venda")
    private BigDecimal precoVenda;
    @Basic(optional = false)
    @Column(name = "tipoTransporte")
    private String tipoTransporte;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "rasa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rasa rasa;
    @JoinColumn(name = "transportadora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transportadora transportadoraId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<ItemProduto> itemProdutoList;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, BigDecimal peso, String dataVenda, String tipoTransporte, int quantidade) {
        this.id = id;
        this.peso = peso;
        this.dataVenda = dataVenda;
        this.tipoTransporte = tipoTransporte;
        this.quantidade = quantidade;
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

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Rasa getRasa() {
        return rasa;
    }

    public void setRasa(Rasa rasa) {
        this.rasa = rasa;
    }

    public Transportadora getTransportadoraId() {
        return transportadoraId;
    }

    public void setTransportadoraId(Transportadora transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

    @XmlTransient
    public List<ItemProduto> getItemProdutoList() {
        return itemProdutoList;
    }

    public void setItemProdutoList(List<ItemProduto> itemProdutoList) {
        this.itemProdutoList = itemProdutoList;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.Produto[ id=" + id + " ]";
    }
    
}
