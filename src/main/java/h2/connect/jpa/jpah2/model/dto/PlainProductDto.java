package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.Products;
import lombok.Data;

import java.util.stream.Collectors;

@Data
public class PlainProductDto {
    private long product_id;
    private  String product_name;
    private  String image;
    private  double Price;
    private String descriptions;
    private int quantity;


    public static  PlainProductDto from(Products products){
        PlainProductDto plainProductDto=new PlainProductDto();
        plainProductDto.setProduct_id(products.getProduct_id());
        plainProductDto.setProduct_name(products.getProduct_name());
        plainProductDto.setDescriptions(products.getDescriptions());
        plainProductDto.setImage(products.getImage());
        plainProductDto.setPrice(products.getPrice());
        plainProductDto.setQuantity(products.getQuantity());
        return plainProductDto;


    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
