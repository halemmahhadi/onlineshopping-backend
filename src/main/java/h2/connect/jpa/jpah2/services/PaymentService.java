package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.CartNotFoundException;
import h2.connect.jpa.jpah2.exception.PaymentNotFoundException;
import h2.connect.jpa.jpah2.model.Payment;
import h2.connect.jpa.jpah2.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }


    public List<Payment> getPayments() {
        return StreamSupport
                .stream(paymentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Payment getPaymentById(long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new PaymentNotFoundException(id));
    }

    public Payment deletePayment(long id) {
        Payment payment = getPaymentById(id);
        paymentRepository.delete(payment);
        return payment;

    }

    @Transactional
    public Payment editPayment(long id,Payment payment) {
        Payment paymentToEdit = getPaymentById(id);
        paymentToEdit.setPaid_date(payment.getPaid_date());
        paymentToEdit.setTotal(payment.getTotal());
        return paymentToEdit;


    }
}
