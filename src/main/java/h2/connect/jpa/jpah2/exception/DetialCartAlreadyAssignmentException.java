package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class DetialCartAlreadyAssignmentException extends RuntimeException {
    public DetialCartAlreadyAssignmentException(final long cartD_id,final long cart_id ){
        super(MessageFormat.format("product:{0}is already assign to cart{1}",cartD_id,cart_id));

    }
}
