package h2.connect.jpa.jpah2.model;

import h2.connect.jpa.jpah2.model.dto.BucketItemDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BucketItem {
    @Id @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Products product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public static BucketItem from(Products product) {
        BucketItem bucketItem = new BucketItem();
        bucketItem.setProduct(product);
        return bucketItem;
    }

    public static BucketItem from(BucketItemDto bucketItemDto) {
        BucketItem bucketItem = new BucketItem();
        bucketItem.setProduct(Products.from(bucketItemDto.getProduct()));
        return bucketItem;
    }
}
