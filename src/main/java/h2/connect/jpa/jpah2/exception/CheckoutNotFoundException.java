package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class CheckoutNotFoundException extends RuntimeException {
    public CheckoutNotFoundException(long bucketItemId){
        super(MessageFormat.format("could not find checkout with id:{0}", bucketItemId));
    }
}
