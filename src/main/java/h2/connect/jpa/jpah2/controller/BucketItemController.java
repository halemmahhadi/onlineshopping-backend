package h2.connect.jpa.jpah2.controller;

import h2.connect.jpa.jpah2.model.BucketItem;
import h2.connect.jpa.jpah2.model.Customer;
import h2.connect.jpa.jpah2.model.Orders;
import h2.connect.jpa.jpah2.model.dto.BucketItemDto;
import h2.connect.jpa.jpah2.model.dto.CustomerDto;
import h2.connect.jpa.jpah2.model.dto.OrderDto;
import h2.connect.jpa.jpah2.model.dto.ProductDTo;
import h2.connect.jpa.jpah2.services.BucketItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/BucketItem")
public class BucketItemController {
    private final BucketItemService bucketItemService;

    @Autowired
    public BucketItemController(BucketItemService bucketItemService) {
        this.bucketItemService = bucketItemService;
    }

    @PostMapping
    public ResponseEntity<BucketItemDto> addBucketItem(@RequestBody final ProductDTo productDto) {
        BucketItem bucketItem = bucketItemService.addBucketItem(productDto);
        return new ResponseEntity<>(BucketItemDto.from(bucketItem), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BucketItemDto>> getBucketItems() {
        List<BucketItem> bucketItems = bucketItemService.getBucketItems();
        List<BucketItemDto> bucketItemDtos = bucketItems.stream().map(BucketItemDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(bucketItemDtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<BucketItemDto> deleteBucketItem(@PathVariable final long id) {
        BucketItem bucketItem = bucketItemService.deleteBucketItem(id);
        return new ResponseEntity<>(BucketItemDto.from(bucketItem), HttpStatus.OK);
    }
}
