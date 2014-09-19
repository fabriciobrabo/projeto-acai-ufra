/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufra.acai.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fabricio correa brabo
 */
@Entity
@Table(name = "item_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemProduto.findAll", query = "SELECT i FROM ItemProduto i"),
    @NamedQuery(name = "ItemProduto.findById", query = "SELECT i FROM ItemProduto i WHERE i.id = :id")})
public class ItemProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "extracao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Extracao extracao;

    public ItemProduto() {
    }

    public ItemProduto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Extracao getExtracao() {
        return extracao;
    }

    public void setExtracao(Extracao extracao) {
        this.extracao = extracao;
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
        if (!(object instanceof ItemProduto)) {
            return false;
        }
        ItemProduto other = (ItemProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.acai.entidade.ItemProduto[ id=" + id + " ]";
    }
    
}
