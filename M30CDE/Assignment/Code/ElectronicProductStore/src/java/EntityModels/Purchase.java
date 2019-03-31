/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Chris
 */
@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long Quantity;
    @ManyToMany(targetEntity = Product.class)
    private Set productSet;
    @ManyToOne
    private CustomerOrder order;

    // <editor-fold desc="Properties"> 
    public Long getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(Long quantity) {
        this.Quantity = quantity;
    }

    public CustomerOrder getOrder() {
        return this.order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    public Set getProductSet() {
        return this.productSet;
    }

    public void setProductSet(Set productSet) {
        this.productSet = productSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // </editor-fold>
    
    // <editor-fold desc="Inherited"> Dsdsad
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityModels.Purchase[ id=" + id + " ]";
    }

    // </editor-fold>
}
