package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.PaymentDto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id @GeneratedValue
    private long id;
    private Date paid_date;
    private double total;

    @OneToOne(mappedBy = "payment")
    private Orders orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public Payment() {
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public  static Payment from(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setPaid_date(paymentDto.getPaid_date());
        payment.setTotal(paymentDto.getTotal());
        payment.setCustomer(paymentDto.getCustomer());
        return payment;

    }
}
