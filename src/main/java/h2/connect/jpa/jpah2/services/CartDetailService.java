package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.CartDetailNotFoundException;
import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.repo.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartDetailService {
    private final CartDetailRepository cartDetailRepository;


    @Autowired

    public CartDetailService(CartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;

    }

    public CartDetails addCartDetail(CartDetails cartDetails) {

        return cartDetailRepository.save(cartDetails);
    }

    public List<CartDetails> getCartDetails() {
        return StreamSupport
                .stream(cartDetailRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public CartDetails getCartDetailById(long id) {
        return cartDetailRepository.findById(id)
                .orElseThrow(() ->
                        new CartDetailNotFoundException(id));
    }

    public CartDetails deleteCartDetail(long id) {
        CartDetails cartDetails = getCartDetailById(id);
        cartDetailRepository.delete(cartDetails);
        return cartDetails;

    }

    @Transactional
    public CartDetails editCartDetail(long id, CartDetails cartDetails) {
        CartDetails cartDetailToEdit = getCartDetailById(id);
        cartDetailToEdit.setPrice(cartDetails.getPrice());
        cartDetailToEdit.setCDquantity(cartDetails.getCDquantity());
        return cartDetails;


    }


}
