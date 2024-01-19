package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.Address;
import h2.connect.jpa.jpah2.model.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDto {
    private long order_id;
    private Date created_date;
    private double total_price;
    private int total_quantity;
    private Address address;
    private List<OrderDetailDto> orderDetailDto=new ArrayList<>();


    public static OrderDto from(Orders orders) {
        OrderDto orderDto = new OrderDto();
        orderDto.setCreated_date(orders.getCreated_date());
        orderDto.setTotal_price(orders.getTotal_price());
        orderDto.setTotal_quantity(orders.getTotal_quantity());
        orderDto.setAddress(orders.getAddress());
        orderDto.setOrderDetailDto(orders.getOrderDetails().stream().map(OrderDetailDto::from).collect(Collectors.toList()));
        return orderDto;

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

    public List<OrderDetailDto> getOrderDetailDto() {
        return orderDetailDto;
    }

    public void setOrderDetailDto(List<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDto = orderDetailDtos;
    }
}
