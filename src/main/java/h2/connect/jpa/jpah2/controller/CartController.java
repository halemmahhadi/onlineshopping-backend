package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.Products;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import h2.connect.jpa.jpah2.model.dto.CartDto;
import h2.connect.jpa.jpah2.model.dto.ProductDTo;
import h2.connect.jpa.jpah2.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public CartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<CartDto> addCart(@RequestBody final CartDto cartDto) {
        ShoppingCart shoppingCart = shoppingCartService.addCart(ShoppingCart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(shoppingCart), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getCarts() {
        List<ShoppingCart> shoppingCart = shoppingCartService.getCart();
        List<CartDto> cartDto = shoppingCart.stream().map(CartDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable final long id) {
        ShoppingCart shoppingCart = shoppingCartService.getCartById(id);
        return new ResponseEntity<>(CartDto.from(shoppingCart), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CartDto> deleteCart(@PathVariable final long id) {
        ShoppingCart shoppingCart = shoppingCartService.deleteCart(id);
        return new ResponseEntity<>(CartDto.from(shoppingCart), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CartDto> editCart(@PathVariable final long id, @RequestBody final CartDto cartDto) {
        ShoppingCart editedCart = shoppingCartService.editCart(id, ShoppingCart.from(cartDto));
        return new ResponseEntity<>(CartDto.from(editedCart), HttpStatus.OK);
    }

    @PostMapping(value = "{card_id)/cartDetail/{cartD_id}/add")
    public ResponseEntity<CartDto> addCartDetailToCart(@PathVariable final long cart_id,
                                                        @PathVariable final long cartD_id) {
        ShoppingCart shoppingCart = shoppingCartService.addCartDetailToCart(cart_id, cartD_id);
        return new ResponseEntity<>(CartDto.from(shoppingCart), HttpStatus.OK);
    }

    @DeleteMapping(value = "{cart_id)/cartDetail/{cartD_id}/remove")
    public ResponseEntity<CartDto> removeCartDetailFromCart(@PathVariable final long cart_id,
                                                            @PathVariable final long cartD_id) {
        ShoppingCart shoppingCart = shoppingCartService.removeCartDetailFromCart(cart_id, cartD_id);
        return new ResponseEntity<>(CartDto.from(shoppingCart), HttpStatus.OK);
    }


}
