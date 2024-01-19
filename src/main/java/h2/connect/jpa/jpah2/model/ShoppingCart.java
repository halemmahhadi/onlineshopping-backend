package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.CartDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue
    private long cart_id;
    private Date created_date;
    private double total_price;
    private int total_quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartDetails> carderDetail = new ArrayList<>();

    public ShoppingCart() {
    }
    public void addCartDetailToCart(CartDetails cartDetails){
        carderDetail.add(cartDetails);
    }
    public void removeCartDetailFromCart(CartDetails cartDetails){
        carderDetail.remove(cartDetails);
    }

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartDetails> getCarderDetail() {
        return carderDetail;
    }

    public void setCarderDetail(List<CartDetails> carderDetail) {
        this.carderDetail = carderDetail;
    }

    public static ShoppingCart from(CartDto cartDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCreated_date(cartDto.getCreated_date());
        shoppingCart.setTotal_price(cartDto.getTotal_price());
        shoppingCart.setTotal_quantity(cartDto.getTotal_quantity());
        return shoppingCart;
    }
}
