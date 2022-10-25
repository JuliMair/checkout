package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    private String text;

    @BeforeEach
    public void setup(){
        text = "Hello World";
    }

    @Test
    public void TestHellowWorld() {
        String trimmed = text.trim();
        assertEquals("Hello World", trimmed);
    }
}
