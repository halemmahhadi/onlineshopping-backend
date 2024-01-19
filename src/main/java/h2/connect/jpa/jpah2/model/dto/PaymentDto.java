package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.Customer;
import h2.connect.jpa.jpah2.model.Payment;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentDto {
    private long id;
    private Date paid_date;
    private double total;
    private Customer customer;

    public  static PaymentDto from(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaid_date(payment.getPaid_date());
        paymentDto.setTotal(payment.getTotal());
        paymentDto.setCustomer(payment.getCustomer());
        return paymentDto;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(Date paid_date) {
        this.paid_date = paid_date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
