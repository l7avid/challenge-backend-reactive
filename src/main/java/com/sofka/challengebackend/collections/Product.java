package com.sofka.challengebackend.collections;


import java.util.List;
import java.util.Objects;

public class Product {

    private String productName;
    private Long productPrice;
    private String productDescription;
    private Integer minAmount;
    private Integer maxAmount;
    private Integer availableAmount;
    private Purveyor purveyor;

    public Product(String productName,
                   Long productPrice,
                   String productDescription,
                   Integer minAmount,
                   Integer maxAmount,
                   Integer availableAmount,
                   Purveyor purveyor) {

        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.availableAmount = availableAmount;
        this.purveyor = purveyor;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Purveyor getPurveyor() {
        return purveyor;
    }

    public void setPurveyor(Purveyor purveyor) {
        this.purveyor = purveyor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", availableAmount=" + availableAmount +
                ", purveyor=" + purveyor +
                '}';
    }
}
