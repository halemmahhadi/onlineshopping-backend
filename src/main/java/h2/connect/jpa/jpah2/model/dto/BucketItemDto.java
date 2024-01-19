package h2.connect.jpa.jpah2.model.dto;

import h2.connect.jpa.jpah2.model.BucketItem;


public class BucketItemDto {
    private long id;
    private ProductDTo product;

    public static BucketItemDto from(BucketItem bucketItem) {
        BucketItemDto bucketItemDto = new BucketItemDto();
        bucketItemDto.setId(bucketItem.getId());
        bucketItemDto.setProduct(ProductDTo.from(bucketItem.getProduct()));

        return bucketItemDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDTo getProduct() {
        return product;
    }

    public void setProduct(ProductDTo plainProductDto) {
        this.product = plainProductDto;
    }
}