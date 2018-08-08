package com.movileseller.movileapp.layer.data.entities.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the order database table.
 * 
 */
@Embeddable
public class OrderPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idOrder;

    private Integer idCustomer;

    private Integer idPhone;

    public OrderPK() {
    }

    public Integer getIdOrder() {
        return this.idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdCustomer() {
        return this.idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdPhone() {
        return this.idPhone;
    }

    public void setIdPhone(Integer idphone) {
        this.idPhone = idphone;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderPK)) {
            return false;
        }
        OrderPK castOther = (OrderPK) other;
        return (this.idOrder == castOther.idOrder) && this.idCustomer == castOther.idCustomer
                && this.idPhone == castOther.idPhone;
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.idOrder;
        hash = hash * prime + this.idCustomer;
        hash = hash * prime + this.idPhone;

        return hash;
    }
}