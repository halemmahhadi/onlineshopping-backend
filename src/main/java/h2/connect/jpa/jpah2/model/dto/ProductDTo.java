package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.Customer;
import h2.connect.jpa.jpah2.model.Products;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductDTo {
    private long product_id;
    private  String product_name;
    private  String image;
    private  double Price;
    private String descriptions;
    private int quantity;
    private List<CartDetailDto> carderDetailDto=new ArrayList<>();


    public static  ProductDTo from(Products products){
        ProductDTo productDTo=new ProductDTo();
        productDTo.setProduct_id(products.getProduct_id());
        productDTo.setProduct_name(products.getProduct_name());
        productDTo.setDescriptions(products.getDescriptions());
        productDTo.setImage(products.getImage());
        productDTo.setPrice(products.getPrice());
        productDTo.setQuantity(products.getQuantity());
        productDTo.setCarderDetailDto(products.getCarderDetails().stream().map(CartDetailDto::from).collect(Collectors.toList()));
        return productDTo;


    }
    public long getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return Price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<CartDetailDto> getCarderDetailDto() {
        return carderDetailDto;
    }

    public void setCarderDetailDto(List<CartDetailDto> carderDetailDto) {
        this.carderDetailDto = carderDetailDto;
    }
}
