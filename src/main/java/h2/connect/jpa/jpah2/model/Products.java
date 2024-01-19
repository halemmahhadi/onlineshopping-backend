package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.ProductDTo;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_id;
    private String product_name;
    private String image;
    private double Price;
    private String descriptions;
    private int quantity;
    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartDetails> carderDetails = new ArrayList<>();

    public Products() {
    }

    public void addProductToCartDetail(CartDetails cartDetail) {
        carderDetails.add(cartDetail);
    }

    public void removeProductFromCartDetail(CartDetails cartDetail) {
        carderDetails.remove(cartDetail);
    }

    public void addProductToOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }

    public void removeProductFromOrderDetail(OrderDetail orderDetail) {
        orderDetails.remove(orderDetail);
    }

    public Products(String product_name, String image, double price, String descriptions, int quantity) {
        this.product_name = product_name;
        this.image = image;
        Price = price;
        this.descriptions = descriptions;
        this.quantity = quantity;


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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public List<CartDetails> getCarderDetails() {
        return carderDetails;
    }

    public void setCarderDetails(List<CartDetails> carderDetails) {
        this.carderDetails = carderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;


    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", image='" + image + '\'' +
                ", Price=" + Price +
                ", descriptions='" + descriptions + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public static Products from(ProductDTo productDTo) {
        Products products = new Products();
        products.setProduct_name(productDTo.getProduct_name());
        products.setDescriptions(productDTo.getDescriptions());
        products.setImage(productDTo.getImage());
        products.setPrice(productDTo.getPrice());
        products.setQuantity(productDTo.getQuantity());
        return products;


    }
}
