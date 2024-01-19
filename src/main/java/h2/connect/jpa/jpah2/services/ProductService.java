package h2.connect.jpa.jpah2.services;

import h2.connect.jpa.jpah2.exception.ProductIsAlreadyAssignmentException;
import h2.connect.jpa.jpah2.exception.ProductNotFoundException;
import h2.connect.jpa.jpah2.model.CartDetails;
import h2.connect.jpa.jpah2.model.OrderDetail;
import h2.connect.jpa.jpah2.model.Products;
import h2.connect.jpa.jpah2.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartDetailService cartDetailService;
    private final OrderDetialService orderDetialService;
@Autowired
    public ProductService(ProductRepository productRepository, CartDetailService cartDetailService, OrderDetialService orderDetialService) {
        this.productRepository = productRepository;
        this.cartDetailService = cartDetailService;
        this.orderDetialService = orderDetialService;
    }


    public Products addProduct(Products products) {

        return productRepository.save(products);
    }

    public List<Products> getAllProduct() {
        List<Products> products = new ArrayList<Products>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    public Products getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(id));
    }

    public Products deleteProduct(long id) {
        Products products = getProductById(id);
        productRepository.delete(products);
        return products;

    }

    @Transactional
    public Products editProduct(long id, Products products) {
        Products productToEdit = getProductById(id);
        productToEdit.setProduct_name(products.getProduct_name());
        productToEdit.setDescriptions(products.getDescriptions());
        productToEdit.setImage(products.getImage());
        productToEdit.setPrice(products.getPrice());
        productToEdit.setQuantity(products.getQuantity());
        return productToEdit;


    }
    @Transactional

    public Products addProductToCart( long product_id,long cartD_id) {
        Products products = getProductById(product_id);
        CartDetails cartDetails = cartDetailService.getCartDetailById(cartD_id);
        if(Objects.nonNull(cartDetails.getProduct())){
            throw new ProductIsAlreadyAssignmentException(cartD_id,cartDetails.getProduct().getProduct_id());
        }
        products.addProductToCartDetail(cartDetails);
        return products;

    }

    @Transactional
    public Products removeProductFromCart(long product_id,long cartD_id) {
        Products products = getProductById(product_id);
        CartDetails cartDetails = cartDetailService.getCartDetailById(cartD_id);
        products.removeProductFromCartDetail(cartDetails);
        return products;

    }

    @Transactional

    public Products addProductToOrder( long product_id,long orderD_id) {
        Products products = getProductById(product_id);
        OrderDetail orderDetail = orderDetialService.getOrderDetailById(orderD_id);
        if(Objects.nonNull(orderDetail.getProducts())){
            throw new ProductIsAlreadyAssignmentException(orderD_id,orderDetail.getProducts().getProduct_id());
        }
        products.addProductToOrderDetail(orderDetail);
        return products;

    }

    @Transactional
    public Products removeProductFromOrder(long product_id,long orderD_id) {
        Products products = getProductById(product_id);
        OrderDetail orderDetail = orderDetialService.getOrderDetailById(orderD_id);
        products.removeProductFromOrderDetail(orderDetail);
        return products;

    }


}
