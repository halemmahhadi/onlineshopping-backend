package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.CartDetailDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class CartDetails {
    @Id @GeneratedValue
    private long id;
    private double price;
    private int CDquantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Products product;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    public CartDetails() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCDquantity() {
        return CDquantity;
    }

    public void setCDquantity(int CDquantity) {
        this.CDquantity = CDquantity;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public static CartDetails from(CartDetailDto cartDetailDto) {
        CartDetails cartDetails = new CartDetails();
        cartDetails.setPrice(cartDetailDto.getPrice());
        cartDetails.setCDquantity(cartDetailDto.getCDquantity());
        return cartDetails;
    }


}
