package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(long payment_id){
        super(MessageFormat.format("could not find customer with id:{0}",payment_id));

    }
}
