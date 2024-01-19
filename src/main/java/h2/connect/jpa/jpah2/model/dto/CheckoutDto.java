package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.Checkout;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;


public class CheckoutDto {
    private long id;
    private String address;
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
    private String email;
    private List<BucketItemDto> bucketItems;
    private String paymentStatus;

    public static CheckoutDto from(Checkout checkout) {
        CheckoutDto checkoutDto = new CheckoutDto();
        checkoutDto.setId(checkout.getId());
        checkoutDto.setBucketItems(
                checkout.getBucketItems().stream().map(BucketItemDto::from).collect(Collectors.toList())
        );
        checkoutDto.setAddress(checkout.getAddress());
        checkoutDto.setFirstName(checkout.getFirstName());
        checkoutDto.setLastName(checkout.getLastName());
        checkoutDto.setEmail(checkout.getEmail());
        checkoutDto.setPaymentStatus(checkout.getPaymentStatus());
        return checkoutDto;
    }

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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<BucketItemDto> getBucketItems() {
        return bucketItems;
    }

    public void setBucketItems(List<BucketItemDto> bucketItemDtos) {
        bucketItems = bucketItemDtos;
    }
}