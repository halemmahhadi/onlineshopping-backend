package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.CartNotFoundException;
import h2.connect.jpa.jpah2.exception.DetialCartAlreadyAssignmentException;
import h2.connect.jpa.jpah2.exception.ProductIsAlreadyAssignmentException;
import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.ShoppingCart;
import h2.connect.jpa.jpah2.repo.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartDetailService cartDetailService;
    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CartDetailService cartDetailService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartDetailService = cartDetailService;
    }

    public ShoppingCart addCart(ShoppingCart shoppingCart) {

        return shoppingCartRepository.save(shoppingCart);
    }


    public List<ShoppingCart> getCart() {
        return StreamSupport
                .stream(shoppingCartRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public ShoppingCart getCartById(long id) {
        return shoppingCartRepository.findById(id)
                .orElseThrow(() ->
                        new CartNotFoundException(id));
    }

    public ShoppingCart deleteCart(long id) {
        ShoppingCart shoppingCart = getCartById(id);
        shoppingCartRepository.delete(shoppingCart);
        return shoppingCart;

    }

    @Transactional
    public ShoppingCart editCart(long id, ShoppingCart shoppingCart) {
        ShoppingCart cartToEdit = getCartById(id);
        cartToEdit.setCreated_date(shoppingCart.getCreated_date());
        cartToEdit.setTotal_price(shoppingCart.getTotal_price());
        cartToEdit.setTotal_quantity(shoppingCart.getTotal_quantity());
        return cartToEdit;


    }
    @Transactional

    public ShoppingCart addCartDetailToCart(long cart_id, long cartD_id) {
        ShoppingCart shoppingCart = getCartById(cart_id);
        CartDetails cartDetails = cartDetailService.getCartDetailById(cartD_id);
        if(Objects.nonNull(cartDetails.getShoppingCart())){
            throw new DetialCartAlreadyAssignmentException(cartD_id,cartDetails.getShoppingCart().getCart_id());
        }
        shoppingCart.addCartDetailToCart(cartDetails);
        return shoppingCart;

    }

    @Transactional
    public ShoppingCart removeCartDetailFromCart(long cart_id, long cartD_id) {
        ShoppingCart shoppingCart = getCartById(cart_id);
        CartDetails cartDetails = cartDetailService.getCartDetailById(cartD_id);
        shoppingCart.removeCartDetailFromCart(cartDetails);
        return shoppingCart;
    }
}
