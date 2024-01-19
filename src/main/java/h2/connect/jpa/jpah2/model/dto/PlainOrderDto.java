package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.Orders;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import lombok.Data;

import java.util.Date;

@Data
public class PlainOrderDto {
    private long order_id;
    private Date created_date;
    private double total_price;
    private int total_quantity;


    public static PlainOrderDto from(Orders orders) {
        PlainOrderDto plainOrderDto = new PlainOrderDto();
        plainOrderDto.setOrder_id(orders.getOrder_id());
        plainOrderDto.setCreated_date(orders.getCreated_date());
        plainOrderDto.setTotal_price(orders.getTotal_price());
        plainOrderDto.setTotal_quantity(orders.getTotal_quantity());
        return plainOrderDto;

    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
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
