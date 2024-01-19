package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(long address_id){
        super(MessageFormat.format("could not find address with id:{0}",address_id));

    }
}
