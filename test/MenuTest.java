import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Menu.printGreeting();

        assertEquals("Hello World!\r\n", outContent.toString());
    }
}
