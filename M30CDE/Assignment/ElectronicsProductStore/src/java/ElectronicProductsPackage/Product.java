/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicProductsPackage;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ChrisRollings
 */
@Entity
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_id != null ? _id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ElectronicProductsPackage.ProductEntity[ id=" + _id + " ]";
    }
    private Long _id;
    private int _categoryId;
    private int _price;
    private String _desc;
    private String _name;
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public int getPrice() {
        return _price;
    }

    public void setPrice(int price) {
        this._price = price;
    }

    public String getDescription() {
        return _desc;
    }

    public void setDescription(String desc) {
        this._desc = desc;
    }

    public String getName() {
        return _desc;
    }

    public void setName(String name) {
        this._name = name;
    }

}
