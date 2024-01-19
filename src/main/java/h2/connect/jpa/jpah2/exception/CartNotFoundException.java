package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(long cart_id){
        super(MessageFormat.format("could not find customer with id:{0}",cart_id));

    }
}
