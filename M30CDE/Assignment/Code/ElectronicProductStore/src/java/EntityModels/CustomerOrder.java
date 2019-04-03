/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Chris
 */
@Entity
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateOfOrder;
    private Long total;

    public void setTotal(Long total) {
        this.total = total;
    }
    public Long getTotal() {
        return total;
    }
    private String address;
    private String city;
    private String expMonth;
    private String state;
    private String zip;
    private String expYear;
    private String cvv;
    private String firstName;
    private String email;

    // <editor-fold desc="Properties"> 
    public Date getDateOfOrder() {
        return this.dateOfOrder;
    }

    public void setDateOfOrder(Date date) {
        this.dateOfOrder = date;
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
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityModels.Order[ id=" + id + " ]";
    }
    // </editor-fold>

    private String nameOnCard;

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getExpYear() {
        return expYear;
    }

    public String getCvv() {
        return cvv;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
    private String creditCardNumber;

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
