import Lesson_14_testng.Calculator;
import Lesson_14_testng.FactorialException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    @DataProvider
    public Object[][] getNegativeData() {
        return new Object[][]{{-1}, {-10}, {-100}};
    }

    @Test(dataProvider = "getNegativeData",
            expectedExceptions = FactorialException.class,
            expectedExceptionsMessageRegExp = "Число меньше 0")
    public void getFactorialForNegativeNumTest(int num) throws FactorialException {
        Calculator.getFactorial(num);
    }

    @DataProvider
    public Object[][] getPositiveData() {
        return new Object[][]{
                {0, "1"},
                {1, "1"},
                {2, "2"},
                {3, "6"},
                {5, "120"},
                {10, "3628800"},
                {15, "1307674368000"},
                {30, "265252859812191058636308480000000"},
                {40, "815915283247897734345611269596115894272000000000"},
        };
    }

    @Test(dataProvider = "getPositiveData")
    public void getFactorialForPositiveNumTest(int actual, String expected) throws FactorialException {
        BigInteger actualResult = Calculator.getFactorial(actual);
        BigInteger expectedResult = new BigInteger(expected);
        assertEquals(actualResult.compareTo(expectedResult), 0);
    }
}
