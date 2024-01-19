package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.OrderDetailDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class OrderDetail {
    @Id @GeneratedValue
    private long id;
    private double price;
    private int ODquantity;
    private Date created_data;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId")
    private Products products;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderId")
    private Orders orders;




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
        return ODquantity;
    }

    public void setCDquantity(int CDquantity) {
        this.ODquantity = CDquantity;
    }

    public Date getCreated_data() {
        return created_data;
    }

    public void setCreated_data(Date created_data) {
        this.created_data = created_data;
    }

    public int getODquantity() {
        return ODquantity;
    }

    public void setODquantity(int ODquantity) {
        this.ODquantity = ODquantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public static OrderDetail from(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailDto.getId());
        orderDetail.setPrice(orderDetailDto.getPrice());
        orderDetail.setCDquantity(orderDetailDto.getODquantity());
        return orderDetail;
    }
}
