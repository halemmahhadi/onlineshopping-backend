package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.Payment;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import h2.connect.jpa.jpah2.model.dto.CartDto;
import h2.connect.jpa.jpah2.model.dto.PaymentDto;
import h2.connect.jpa.jpah2.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payment")
public class PaymentController {
     private final PaymentService paymentService;

     @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDto> addPayment(@RequestBody final PaymentDto paymentDto) {
       Payment payment = paymentService.addPayment(Payment.from(paymentDto));
        return new ResponseEntity<>(PaymentDto.from(payment), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getPayments() {
        List<Payment> payment = paymentService.getPayments();
        List<PaymentDto> paymentDto = payment.stream().map(PaymentDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(paymentDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PaymentDto> getPaymenttById(@PathVariable final long id) {
        Payment payment = paymentService.getPaymentById(id);
        return new ResponseEntity<>(PaymentDto.from(payment), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<PaymentDto> deletePayment(@PathVariable final long id) {
        Payment payment = paymentService.deletePayment(id);
        return new ResponseEntity<>(PaymentDto.from(payment), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<PaymentDto> editPayment(@PathVariable final long id, @RequestBody final PaymentDto paymentDto) {
        Payment editedPayment = paymentService.editPayment(id, Payment.from(paymentDto));
        return new ResponseEntity<>(PaymentDto.from(editedPayment), HttpStatus.OK);
    }
}
