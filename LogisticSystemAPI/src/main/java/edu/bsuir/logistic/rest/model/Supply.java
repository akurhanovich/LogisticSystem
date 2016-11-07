package edu.bsuir.logistic.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alesha on 06.11.2016.
 */
@Entity
@Table(name = "Supply")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Supply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSupply", unique = true, nullable = false)
    private Integer idSupply;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idGoods", nullable = false)
    private Goods goods;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idSupplier", nullable = false)
    private Supplier supplier;

    @NotEmpty
    @Column(name = "date", nullable = false)
    @Type(type = "date")
    private Date date;

    @NotEmpty
    @Column(name = "quantity", nullable = false)
    private float quantity;

    public Supply() {
        this.idSupply = 0;
    }

    public Supply(Integer idSupply, Goods goods, Supplier supplier, Date date, float quantity) {
        this.idSupply = idSupply;
        this.goods = goods;
        this.supplier = supplier;
        this.date = date;
        this.quantity = quantity;
    }

    public Integer getIdSupply() {
        return idSupply;
    }

    public void setIdSupply(Integer idSupply) {
        this.idSupply = idSupply;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
