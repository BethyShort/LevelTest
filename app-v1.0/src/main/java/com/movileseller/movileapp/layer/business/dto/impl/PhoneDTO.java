package com.movileseller.movileapp.layer.business.dto.impl;

import java.io.Serializable;
import java.math.BigDecimal;

import com.movileseller.movileapp.layer.business.dto.interfaces.DataTransferObject;

public class PhoneDTO implements Serializable, DataTransferObject {

    private static final long serialVersionUID = -1561807024058675560L;

    private int        phoneId     = -1;
    private String     name        = "";
    private byte[]     image;
    private String     description = "";
    private BigDecimal price       = BigDecimal.ZERO;

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
