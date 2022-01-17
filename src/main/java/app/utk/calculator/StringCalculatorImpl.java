package app.utk.calculator;

import app.utk.exceptions.NegativesNotAllowedException;

import java.util.StringTokenizer;

/**
 * @author UtkarshRathore on 17-01-2022
 **/
public class StringCalculatorImpl implements StringCalculator{

    @Override
    public int add(String numbers) {
        StringBuilder negativeNumbers = new StringBuilder();
        int sum = 0;
        if(numbers == null || numbers.trim().isEmpty())
            return 0;
        String delimiter = ","; // default delimiter
        StringTokenizer input = new StringTokenizer(numbers, ";");
        if (input.countTokens() > 1){
            delimiter = input.nextToken();
            numbers = input.nextToken();
        }
        StringTokenizer tokenizer = new StringTokenizer(numbers, delimiter);
        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            StringTokenizer tokenizer2 = new StringTokenizer(token, "\n");
            if (tokenizer2.countTokens()>1){
                while (tokenizer2.hasMoreTokens()) {
                    try {
                        int number = Integer.parseInt(tokenizer2.nextToken());
                        if(number < 0){
                            negativeNumbers.append(number).append(" ");
                        }
                        else if( number < 1000)
                            sum += number;
                    }
                    catch (NumberFormatException e){
                        return 0;
                    }
                }
            }
            else {
                try {
                    int number = Integer.parseInt(token);
                    if(number < 0){
                        negativeNumbers.append(number).append(" ");
                    }
                    else if( number < 1000)
                        sum += number;
                }
                catch (NumberFormatException e){
                    return 0;
                }
            }
        }
        if(negativeNumbers.length() > 0){
            throw new NegativesNotAllowedException(negativeNumbers.toString());
        }
        return sum;
    }
}
