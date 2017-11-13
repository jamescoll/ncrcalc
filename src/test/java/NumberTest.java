import com.company.Number;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class NumberTest {


    @Test
    public void testStringRepresentations() {
        assertThat(Number.ZERO.toString(), is("0"));
        assertThat(Number.ONE.toString(), is("1"));
        assertThat(Number.TWO.toString(), is("2"));
        assertThat(Number.THREE.toString(), is("3"));
        assertThat(Number.FOUR.toString(), is("4"));
        assertThat(Number.FIVE.toString(), is("5"));
        assertThat(Number.SIX.toString(), is("6"));
        assertThat(Number.SEVEN.toString(), is("7"));
        assertThat(Number.EIGHT.toString(), is("8"));
        assertThat(Number.NINE.toString(), is("9"));

    }

    @Test
    public void testFalseStringRepresentation() {
        assertThat(Number.ZERO.toString(), is(not("1")));
    }

    @Test
    public void testFromName() {
        assertThat(Number.fromName("zero"), is(Number.ZERO));
        assertThat(Number.fromName("one"), is(Number.ONE));
        assertThat(Number.fromName("two"), is(Number.TWO));
        assertThat(Number.fromName("three"), is(Number.THREE));
        assertThat(Number.fromName("four"), is(Number.FOUR));
        assertThat(Number.fromName("five"), is(Number.FIVE));
        assertThat(Number.fromName("six"), is(Number.SIX));
        assertThat(Number.fromName("seven"), is(Number.SEVEN));
        assertThat(Number.fromName("eight"), is(Number.EIGHT));
        assertThat(Number.fromName("nine"), is(Number.NINE));

    }

    @Test
    public void testFalseFromName() {
        assertThat(Number.fromName("zero"), is(not(Number.ONE)));
    }

    @Test
    public void testIsNumber() {
        assertThat(Number.isNumber("zero"), is(true));
        assertThat(Number.isNumber("one"), is(true));
        assertThat(Number.isNumber("two"), is(true));
        assertThat(Number.isNumber("three"), is(true));
        assertThat(Number.isNumber("four"), is(true));
        assertThat(Number.isNumber("five"), is(true));
        assertThat(Number.isNumber("six"), is(true));
        assertThat(Number.isNumber("seven"), is(true));
        assertThat(Number.isNumber("eight"), is(true));
        assertThat(Number.isNumber("nine"), is(true));
        assertThat(Number.isNumber("ZERO"), is(true));
        assertThat(Number.isNumber("ONE"), is(true));
        assertThat(Number.isNumber("TWO"), is(true));
        assertThat(Number.isNumber("THREE"), is(true));
        assertThat(Number.isNumber("FOUR"), is(true));
        assertThat(Number.isNumber("FIVE"), is(true));
        assertThat(Number.isNumber("SIX"), is(true));
        assertThat(Number.isNumber("SEVEN"), is(true));
        assertThat(Number.isNumber("EIGHT"), is(true));
        assertThat(Number.isNumber("NINE"), is(true));
    }

    @Test
    public void testFalseIsNumber() {
        assertThat(Number.isNumber("eleven"), is(false));
    }
}
