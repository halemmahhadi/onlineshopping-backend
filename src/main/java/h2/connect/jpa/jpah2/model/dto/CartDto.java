package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.Customer;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDto {
    private long cart_id;
    private Date created_date;
    private double total_price;
    private int total_quantity;
    private Customer customer;
    private List<CartDetailDto>cartDetailDto=new ArrayList<>();

    public static CartDto from(ShoppingCart shoppingCart) {
        CartDto cartDto = new CartDto();
        cartDto.setCreated_date(shoppingCart.getCreated_date());
        cartDto.setTotal_price(shoppingCart.getTotal_price());
        cartDto.setTotal_quantity(shoppingCart.getTotal_quantity());
        cartDto.setCustomer(shoppingCart.getCustomer());
        cartDto.setCartDetailDto(shoppingCart.getCarderDetail().stream().map(CartDetailDto::from).collect(Collectors.toList()));
        return cartDto;

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

    public List<CartDetailDto> getCartDetailDto() {
        return cartDetailDto;
    }

    public void setCartDetailDto(List<CartDetailDto> cartDetailDto) {
        this.cartDetailDto = cartDetailDto;
    }
}

