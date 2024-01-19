package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class DetialOrderAlreadyAssignmentException extends  RuntimeException{
    public DetialOrderAlreadyAssignmentException(final long orderD_id,final long order_id ){
        super(MessageFormat.format("product:{0}is already assign to cart{1}",orderD_id,order_id));

    }
}
