package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(long product_id){
        super(MessageFormat.format("could not find address with id:{0}",product_id));
    }
}
