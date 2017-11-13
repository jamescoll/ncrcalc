import com.company.Calculator;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void testCalculationExamples() {

        String calculation;
        double actualResult = 0.0, expectedResult = 1.0;

        calculation = "nine over eight plus four times two divided-by three";
        actualResult = Calculator.calculate(calculation);
        expectedResult = 3.79;
        assertThat(expectedResult, is(roundedValue(actualResult)));

        calculation = "one plus six";
        actualResult = Calculator.calculate(calculation);
        expectedResult = 7.0;
        assertThat(expectedResult, is(roundedValue(actualResult)));

        calculation = "one plus two times three";
        actualResult = Calculator.calculate(calculation);
        expectedResult = 7.0;
        assertThat(expectedResult, is(roundedValue(actualResult)));

        calculation = "nine minus three times seven";
        actualResult = Calculator.calculate(calculation);
        expectedResult = -12.0;
        assertThat(expectedResult, is(roundedValue(actualResult)));

        calculation = "four minus eight plus six times nine";
        actualResult = Calculator.calculate(calculation);
        expectedResult = 50.0;
        assertThat(expectedResult, is(roundedValue(actualResult)));

        calculation = "seven over nine plus two";
        actualResult = Calculator.calculate(calculation);
        expectedResult = 2.78;
        assertThat(expectedResult, is(roundedValue(actualResult)));


    }

    @Test
    public void testWrongCalculationExamples() {

        String calculation;
        double actualResult = 0.0, expectedResult = 1.0;

        calculation = "nine over eight plus four times two divided-by three";
        actualResult = Calculator.calculate(calculation);
        expectedResult = 3.8;
        assertThat(expectedResult, is(not(roundedValue(actualResult))));

        calculation = "one plus six";
        actualResult = Calculator.calculate(calculation);
        expectedResult = 5.0;
        assertThat(expectedResult, is(not(roundedValue(actualResult))));


    }

    private double roundedValue(double value) {

        DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(value));

    }
}
