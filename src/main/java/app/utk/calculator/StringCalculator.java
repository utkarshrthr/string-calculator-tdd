package app.utk.calculator;

import app.utk.exceptions.NegativesNotAllowedException;

/**
 * @author UtkarshRathore on 17-01-2022
 **/
public interface StringCalculator {
    int add(String numbers) throws NegativesNotAllowedException;
}
