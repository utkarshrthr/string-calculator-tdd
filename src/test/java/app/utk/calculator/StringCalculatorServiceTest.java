package app.utk.calculator;

import app.utk.exceptions.NegativesNotAllowedException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * @author UtkarshRathore on 17-01-2022
 **/
public class StringCalculatorServiceTest {

    @Test
    public void testForEmptyString(){
        StringCalculator calculator = new StringCalculatorImpl();
        int output = calculator.add(" ");
        assertEquals(output, 0);
    }

    @Test
    public void testForSingleNumber(){
        StringCalculator calculator = new StringCalculatorImpl();
        int output = calculator.add("45");
        assertEquals(output, 45);
    }

    @Test
    public void testForMultipleNumbers(){
        StringCalculator calculator = new StringCalculatorImpl();
        int output = calculator.add("1,22,33,4");
        assertEquals(output, 60);
    }

    @Test
    public void testForNewLineBetweenNumbers(){
        StringCalculator calculator = new StringCalculatorImpl();
        int output = calculator.add("1,22\n33,4");
        assertEquals(output, 60);
    }

    @Test
    public void testForInvalidStrings(){
        StringCalculator calculator = new StringCalculatorImpl();
        int output = calculator.add("1,\n");
        assertEquals(output, 0);
    }

    @Test
    public void testForNegativeNumbers(){
        StringCalculator calculator = new StringCalculatorImpl();
        assertThrows(NegativesNotAllowedException.class, ()->{
            calculator.add("-1,-2");
        });
    }

    @Test
    public void testForNumbersGreaterThan1000(){
        StringCalculator calculator = new StringCalculatorImpl();
        int output = calculator.add("1,1000,1");
        assertEquals(output, 2);
    }

    @Test
    public void testForDifferentDelimiter(){
        StringCalculator calculator = new StringCalculatorImpl();
        int output = calculator.add(":;1:2:3");
        assertEquals(output, 6);
    }
}
