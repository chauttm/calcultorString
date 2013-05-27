import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.java2d.pipe.Region;

/**
 * Created with IntelliJ IDEA.
 * User: khiemnt
 * Date: 5/21/13
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class calculatorStringTest {
    @Test
    public void testReturnZeroOnEmpty() {
        Assert.assertEquals(0, calculatorString.add(""));
    }

    @Test
    public void testOneNumber() {
        Assert.assertEquals(1, calculatorString.add("1"));
    }

    @Test
    public void testSimpleDelimiters() {
        Assert.assertEquals(7, calculatorString.add(",1,2,4"));
    }

    @Test
    public void testWithNewLine() {
        Assert.assertEquals(6, calculatorString.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiters() {
        Assert.assertEquals(14, calculatorString.add("//;\n1;2;8,3"));
    }

    @Test(expected = NumberFormatException.class)
    public void testWithException() {
        calculatorString.add("-1,2,3");

    }

    @Test
    public void testNumberGreater1000() {
        Assert.assertEquals(2, calculatorString.add("2,1001,1002"));
    }
    @Test
    public void testWithLengthDelimiters() {
        Assert.assertEquals(6, calculatorString.add("//[***]\n1***2***3"));
    }
    @Test
    public void testWithManyDelimiters() {
        Assert.assertEquals(6, calculatorString.add("//[*][%]\n1*2%3"));
    }
}
