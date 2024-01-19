package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import h2.connect.jpa.jpah2.model.dto.CartDetailDto;
import h2.connect.jpa.jpah2.model.dto.CartDto;
import h2.connect.jpa.jpah2.services.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartDetails")
public class CartDetailController {
    private final CartDetailService cartDetailService;

    @Autowired
    public CartDetailController(CartDetailService cartDetailService) {
        this.cartDetailService = cartDetailService;
    }

    @PostMapping
    public ResponseEntity<CartDetailDto> addCartDetail(@RequestBody final CartDetailDto cartDetailDto) {
        CartDetails cartDetails = cartDetailService.addCartDetail(CartDetails.from(cartDetailDto));
        return new ResponseEntity<>(CartDetailDto.from(cartDetails), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CartDetailDto>> getCartDetails() {
        List<CartDetails> cartDetails = cartDetailService.getCartDetails();
        List<CartDetailDto> cartDetailDto = cartDetails.stream().map(CartDetailDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(cartDetailDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CartDetailDto> getCarDetailtById(@PathVariable final long id) {
        CartDetails cartDetails = cartDetailService.getCartDetailById(id);
        return new ResponseEntity<>(CartDetailDto.from(cartDetails), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CartDetailDto> deleteCartDetail(@PathVariable final long id) {
        CartDetails cartDetails = cartDetailService.deleteCartDetail(id);
        return new ResponseEntity<>(CartDetailDto.from(cartDetails ), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CartDetailDto> editCartDetails(@PathVariable final long id, @RequestBody final CartDetailDto cartDetailDto) {
        CartDetails editedCartDetail = cartDetailService.editCartDetail(id, CartDetails.from(cartDetailDto));
        return new ResponseEntity<>(CartDetailDto.from(editedCartDetail), HttpStatus.OK);
    }



}
