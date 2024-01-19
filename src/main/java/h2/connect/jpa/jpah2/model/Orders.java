package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.OrderDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_id;
    private Date created_date;
    private double total_price;
    private int total_quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "address_id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment", referencedColumnName = "id")
    private Payment payment;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public void addOrderDetailToOrder(OrderDetail orderDetail){
        orderDetails.add(orderDetail);
    }
    public void removeOrderDetailFromOrder(OrderDetail orderDetail){
        orderDetails.remove(orderDetail);
    }


    public Orders() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public static Orders from(OrderDto orderDto) {
        Orders orders = new Orders();
        orders.setCreated_date(orderDto.getCreated_date());
        orders.setTotal_price(orderDto.getTotal_price());
        orders.setTotal_quantity(orderDto.getTotal_quantity());
        orders.setAddress(orderDto.getAddress());
        return orders;

    }

}
