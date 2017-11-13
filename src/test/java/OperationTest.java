import com.company.Operation;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OperationTest {

    @Test
    public void testAdd() {
        assertThat(Operation.ADD.calculate(1, 1), is(2.0));
    }

    @Test
    public void testSubtract() {
        assertThat(Operation.SUBTRACT.calculate(1, 1), is(0.0));
    }

    @Test
    public void testMultiply() {
        assertThat(Operation.MULTIPLY.calculate(1, 1), is(1.0));
    }

    @Test
    public void testDivide() {
        assertThat(Operation.DIVIDE.calculate(1, 1), is(1.0));
    }

    @Test
    public void testAddOperations() {
        assertThat(Operation.isOperation("ADD"), is(true));
        assertThat(Operation.isOperation("add"), is(true));
        assertThat(Operation.isOperation("PLUS"), is(true));
        assertThat(Operation.isOperation("plus"), is(true));
    }

    @Test
    public void testSubtractOperations() {

        assertThat(Operation.isOperation("subtract"), is(true));
        assertThat(Operation.isOperation("SUBTRACT"), is(true));
        assertThat(Operation.isOperation("minus"), is(true));
        assertThat(Operation.isOperation("MINUS"), is(true));
        assertThat(Operation.isOperation("less"), is(true));
        assertThat(Operation.isOperation("LESS"), is(true));
    }

    @Test
    public void testMultiplicationOperations() {

        assertThat(Operation.isOperation("multiplied-by"), is(true));
        assertThat(Operation.isOperation("MULTIPLIED-BY"), is(true));
        assertThat(Operation.isOperation("times"), is(true));
        assertThat(Operation.isOperation("TIMES"), is(true));
    }

    @Test
    public void testDivisionOperations() {
        assertThat(Operation.isOperation("divided-by"), is(true));
        assertThat(Operation.isOperation("DIVIDED-BY"), is(true));
        assertThat(Operation.isOperation("over"), is(true));
        assertThat(Operation.isOperation("OVER"), is(true));

    }

    @Test
    public void testInvalidOperations() {
        assertThat(Operation.isOperation("foo"), is(false));
    }

    @Test
    public void testPrioritySettings() {
        assertThat(Operation.ADD.isLowerPriority(Operation.SUBTRACT), is(true));
        assertThat(Operation.SUBTRACT.isLowerPriority(Operation.MULTIPLY), is(true));
        assertThat(Operation.MULTIPLY.isLowerPriority(Operation.DIVIDE), is(true));

    }

    @Test
    public void testFalsePrioritySettings() {
        assertThat(Operation.DIVIDE.isLowerPriority(Operation.MULTIPLY), is(false));
        assertThat(Operation.MULTIPLY.isLowerPriority(Operation.SUBTRACT), is(false));
        assertThat(Operation.SUBTRACT.isLowerPriority(Operation.ADD), is(false));
    }

    @Test
    public void testStringRepresentations() {
        assertThat(Operation.ADD.toString(), is("+"));
        assertThat(Operation.MULTIPLY.toString(), is("*"));
        assertThat(Operation.SUBTRACT.toString(), is("-"));
        assertThat(Operation.DIVIDE.toString(), is("/"));
    }

    @Test
    public void testFromName() {
        assertThat(Operation.fromName("add"), is(Operation.ADD));
        assertThat(Operation.fromName("subtract"), is(Operation.SUBTRACT));
        assertThat(Operation.fromName("multiplied-by"), is(Operation.MULTIPLY));
        assertThat(Operation.fromName("divided-by"), is(Operation.DIVIDE));
    }
}
