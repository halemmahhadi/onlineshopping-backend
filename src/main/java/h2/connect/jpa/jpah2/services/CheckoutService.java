package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.BucketItemNotFoundException;
import h2.connect.jpa.jpah2.exception.CheckoutNotFoundException;
import h2.connect.jpa.jpah2.model.BucketItem;
import h2.connect.jpa.jpah2.model.Checkout;
import h2.connect.jpa.jpah2.model.dto.CheckoutDto;
import h2.connect.jpa.jpah2.model.dto.BucketItemDto;
import h2.connect.jpa.jpah2.repo.BucketItemRepository;
import h2.connect.jpa.jpah2.repo.CheckoutRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CheckoutService {
    private final BucketItemRepository bucketItemRepository;
    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutService(
            CheckoutRepository checkoutRepository,
            BucketItemRepository bucketItemRepository
    ) {
        this.checkoutRepository = checkoutRepository;
        this.bucketItemRepository = bucketItemRepository;
    }

    public Checkout addCheckout(CheckoutDto checkoutDto) {
        List<BucketItem> allBucketItems = bucketItemRepository.findAll();
        Checkout checkout = Checkout.from(checkoutDto, allBucketItems);
        return checkoutRepository.save(checkout);
    }

    public Checkout getCheckoutById(long id) {
        return checkoutRepository.findById(id)
                .orElseThrow(() ->
                        new CheckoutNotFoundException(id));
    }

    public List<Checkout> getAllCheckouts() {
        return StreamSupport
                .stream(checkoutRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Checkout deleteCheckout(long id) {
        Checkout checkout = getCheckoutById(id);
        List<BucketItem> bucketItems = checkout.getBucketItems();
        for (int i = 0; i < bucketItems.size(); i++) {
            BucketItem bucketItemToDelete = bucketItems.get(i);
            bucketItemRepository.delete(bucketItemToDelete);
        }
        checkoutRepository.delete(checkout);
        return checkout;
    }
}
