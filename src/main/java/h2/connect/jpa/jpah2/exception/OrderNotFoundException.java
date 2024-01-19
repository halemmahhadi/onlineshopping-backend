package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long order_id){
        super(MessageFormat.format("could not find address with id:{0}",order_id));
    }
}
