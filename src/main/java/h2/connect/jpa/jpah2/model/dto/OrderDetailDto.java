package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.OrderDetail;

import java.util.Date;
import java.util.Objects;

public class OrderDetailDto {
    private long id;
    private double price;
    private int ODquantity;
    private Date created_data;
    private PlainOrderDto plainOrderDto;
    private PlainProductDto plainProductDto;

    public static OrderDetailDto from(OrderDetail orderDetail) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setId(orderDetail.getId());
        orderDetailDto.setPrice(orderDetail.getPrice());
        orderDetailDto.setODquantity(orderDetail.getCDquantity());
        if(Objects.nonNull(orderDetail.getOrders())){
            orderDetailDto.setPlainOrderDto(PlainOrderDto.from(orderDetail.getOrders()));
        }
        if(Objects.nonNull(orderDetail.getProducts())){
            orderDetailDto.setPlainProductDto(PlainProductDto.from(orderDetail.getProducts()));
        }
        return orderDetailDto;
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

    public int getODquantity() {
        return ODquantity;
    }

    public void setODquantity(int ODquantity) {
        this.ODquantity = ODquantity;
    }

    public Date getCreated_data() {
        return created_data;
    }

    public void setCreated_data(Date created_data) {
        this.created_data = created_data;
    }

    public PlainOrderDto getPlainOrderDto() {
        return plainOrderDto;
    }

    public void setPlainOrderDto(PlainOrderDto plainOrderDto) {
        this.plainOrderDto = plainOrderDto;
    }

    public PlainProductDto getPlainProductDto() {
        return plainProductDto;
    }

    public void setPlainProductDto(PlainProductDto plainProductDto) {
        this.plainProductDto = plainProductDto;
    }
}

