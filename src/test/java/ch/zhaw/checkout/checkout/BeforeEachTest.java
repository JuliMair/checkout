package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeEachTest {
    private String text;

    @BeforeEach
    public void setup() {
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
