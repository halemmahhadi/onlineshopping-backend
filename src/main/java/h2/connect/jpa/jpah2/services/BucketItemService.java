package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.BucketItemNotFoundException;
import h2.connect.jpa.jpah2.exception.CartDetailNotFoundException;
import h2.connect.jpa.jpah2.model.BucketItem;
import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.Products;
import h2.connect.jpa.jpah2.model.dto.ProductDTo;
import h2.connect.jpa.jpah2.repo.BucketItemRepository;
import h2.connect.jpa.jpah2.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BucketItemService {
    private final ProductRepository productRepository;
    private final BucketItemRepository bucketItemRepository;

    @Autowired
    public BucketItemService(
            ProductRepository productRepository,
            BucketItemRepository bucketItemRepository
    ) {
        this.productRepository = productRepository;
        this.bucketItemRepository = bucketItemRepository;
    }

    public BucketItem addBucketItem(ProductDTo productDto) {
        Products targetProduct = productRepository.getOne(productDto.getProduct_id());
        BucketItem bucketItem = BucketItem.from(targetProduct);
        return bucketItemRepository.save(bucketItem);
    }

    public BucketItem getBucketItemById(long id) {
        return bucketItemRepository.findById(id)
                .orElseThrow(() ->
                        new BucketItemNotFoundException(id));
    }

    public List<BucketItem> getBucketItems() {
        return StreamSupport
                .stream(bucketItemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public BucketItem deleteBucketItem(long id) {
        BucketItem bucketItem = getBucketItemById(id);
        bucketItemRepository.delete(bucketItem);
        return bucketItem;
    }
}
