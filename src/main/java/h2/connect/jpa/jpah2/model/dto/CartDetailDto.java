package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.Products;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class CartDetailDto {
    private long id;
    private double price;
    private int CDquantity;
    private PlainCartDto plainCartDto;
    private PlainProductDto plainProductDto;


    public static CartDetailDto from(CartDetails cartDetails) {
        CartDetailDto cartDetailDto = new CartDetailDto();
        cartDetailDto.setId(cartDetails.getId());
        cartDetailDto.setPrice(cartDetails.getPrice());
        cartDetailDto.setCDquantity(cartDetails.getCDquantity());
        if(Objects.nonNull(cartDetails.getShoppingCart())){
            cartDetailDto.setPlainCartDto(PlainCartDto.from(cartDetails.getShoppingCart()));
        }
        if(Objects.nonNull(cartDetails.getProduct())){
            cartDetailDto.setPlainProductDto(PlainProductDto.from(cartDetails.getProduct()));
        }

        return cartDetailDto;
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

    public PlainCartDto getPlainCartDto() {
        return plainCartDto;
    }

    public void setPlainCartDto(PlainCartDto plainCartDto) {
        this.plainCartDto = plainCartDto;
    }

    public PlainProductDto getPlainProductDto() {
        return plainProductDto;
    }

    public void setPlainProductDto(PlainProductDto plainProductDto) {
        this.plainProductDto = plainProductDto;
    }
}
