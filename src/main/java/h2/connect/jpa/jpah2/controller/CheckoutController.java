package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.BucketItem;
import h2.connect.jpa.jpah2.model.Checkout;
import h2.connect.jpa.jpah2.model.dto.*;
import h2.connect.jpa.jpah2.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public ResponseEntity<CheckoutDto> addCheckout(@Valid @RequestBody final CheckoutDto checkoutDto) {
        Checkout checkout = checkoutService.addCheckout(checkoutDto);
        return new ResponseEntity<>(CheckoutDto.from(checkout), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CheckoutDto>> getCheckouts() {
        List<Checkout> checkouts = checkoutService.getAllCheckouts();
        List<CheckoutDto> checkoutsDtos = checkouts.stream().map(CheckoutDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(checkoutsDtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CheckoutDto> deleteCheckout(@PathVariable final long id) {
        Checkout checkout = checkoutService.deleteCheckout(id);
        return new ResponseEntity<>(CheckoutDto.from(checkout), HttpStatus.OK);
    }
}
