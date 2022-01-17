package app.utk.exceptions;

/**
 * @author UtkarshRathore on 17-01-2022
 **/
public class NegativesNotAllowedException extends RuntimeException {

    public NegativesNotAllowedException(String message){
        super(message);
    }
}
