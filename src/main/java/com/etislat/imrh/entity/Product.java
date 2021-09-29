package com.etislat.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "PRODUCT")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseEntity {

    @GenericGenerator(
        name = "productSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "PRODUCT_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "productSequenceGenerator")
    @Column(name="PRODUCT_ID", unique=true, nullable=false)
    private Long productId;

    @Column(name="PRODUCT_NAME", nullable=false)
    private String productName;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PartnerCountryProduct> partnerCountryProducts = new ArrayList<>();

    public Product() {}

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<PartnerCountryProduct> getPartnerCountryProducts() {
        return partnerCountryProducts;
    }
    public void setPartnerCountryProducts(List<PartnerCountryProduct> partnerCountryProducts) {
        this.partnerCountryProducts = partnerCountryProducts;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
