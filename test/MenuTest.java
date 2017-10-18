import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Test class for Menu class of sarah's babysitting wage calculator.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class MenuTest {
    @Test
    public void printGreetingMethodReturnsHelloWorld() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Menu.printMessage("Hello World!");

        assertEquals("Hello World!\r\n", outContent.toString());
    }
}
