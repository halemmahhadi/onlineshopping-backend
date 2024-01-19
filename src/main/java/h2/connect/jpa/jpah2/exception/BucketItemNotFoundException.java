package h2.connect.jpa.jpah2.exception;

import java.text.MessageFormat;

public class BucketItemNotFoundException extends RuntimeException {
    public BucketItemNotFoundException(long bucketItemId){
        super(MessageFormat.format("could not find bucket item with id:{0}", bucketItemId));
    }
}
