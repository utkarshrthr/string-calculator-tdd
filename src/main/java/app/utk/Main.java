package app.utk;

import app.utk.calculator.StringCalculator;
import app.utk.calculator.StringCalculatorImpl;

/**
 * @author UtkarshRathore on 17-01-2022
 **/
public class Main {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculatorImpl();
        System.out.println(calculator.add("12, 45"));
    }
}
