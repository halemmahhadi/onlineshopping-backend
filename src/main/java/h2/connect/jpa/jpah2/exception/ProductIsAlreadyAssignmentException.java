package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class ProductIsAlreadyAssignmentException extends RuntimeException {
    public ProductIsAlreadyAssignmentException(final long id,final long product_id ){
        super(MessageFormat.format("product:{0}is already assign to cart{1}",id,product_id));

    }
}
