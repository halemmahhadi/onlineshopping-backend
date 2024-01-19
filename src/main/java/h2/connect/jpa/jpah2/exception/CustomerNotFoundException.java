package h2.connect.jpa.jpah2.exception;

import h2.connect.jpa.jpah2.model.Address;
import h2.connect.jpa.jpah2.model.Customer;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.text.MessageFormat;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(long customer_id){
        super(MessageFormat.format("could not find customer with id:{0}",customer_id));

    }


}
