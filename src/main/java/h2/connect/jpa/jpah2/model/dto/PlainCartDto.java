package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.Products;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import lombok.Data;

import java.util.Date;

@Data
public class PlainCartDto {
    private long cart_id;
    private Date created_date;
    private double total_price;
    private int total_quantity;

    public static PlainCartDto from(ShoppingCart shoppingCart) {
        PlainCartDto plainCartDto = new PlainCartDto();
        plainCartDto.setCart_id(shoppingCart.getCart_id());
        plainCartDto.setCreated_date(shoppingCart.getCreated_date());
        plainCartDto.setTotal_price(shoppingCart.getTotal_price());
        plainCartDto.setTotal_quantity(shoppingCart.getTotal_quantity());
        return plainCartDto;
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
}
