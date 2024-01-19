package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class OrderDetailNotFoundException extends RuntimeException {
    public OrderDetailNotFoundException(long id){
        super(MessageFormat.format("could not find customer with id:{0}",id));

    }
}
