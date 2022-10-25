package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BeforeAllTest {
    private static String text;

    @BeforeAll
    public static void setup() {
        text = " Hello World ";
    }

    @Test
    public void testTrim() {
        text = text.trim();
        assertEquals("Hello World", text);
    }

    @Test
    public void testLength() {
        assertEquals(17, text.length());
    }
}