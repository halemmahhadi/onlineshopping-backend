package h2.connect.jpa.jpah2.model;

import com.sun.istack.NotNull;
import lombok.Data;
import h2.connect.jpa.jpah2.model.dto.CheckoutDto;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Checkout {
    @Id @GeneratedValue
    private long id;
    @NotBlank(message = "Address is mandatory")
    private String address;

    private String firstName;
    private String lastName;

    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "bucketItem_id")
    private List<BucketItem> bucketItems = new ArrayList<>();

    private String paymentStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String firstName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BucketItem> getBucketItems() {
        return bucketItems;
    }

    public void setBucketItems(List<BucketItem> bucketItems) {
        this.bucketItems = bucketItems;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public static Checkout from(CheckoutDto checkoutDto, List<BucketItem> bucketItems) {
        Checkout checkout = new Checkout();
        checkout.setAddress(checkoutDto.getAddress());
        checkout.setFirstName(checkoutDto.getFirstName());
        checkout.setLastName(checkoutDto.getLastName());
        checkout.setEmail(checkoutDto.getEmail());
        checkout.setBucketItems(bucketItems);
        checkout.setPaymentStatus("Pending");
        return checkout;
    }
}
