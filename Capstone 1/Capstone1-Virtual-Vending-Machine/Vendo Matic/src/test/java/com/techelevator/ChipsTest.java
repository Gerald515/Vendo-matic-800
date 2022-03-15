package com.techelevator;


import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {
    Chips sut;

    @Before
    public void setUp() throws Exception {
        sut = new Chips("Lays", new BigDecimal("1.50"));
    }

    @Test
    public void testConstructor() {

        assertEquals("Lays", sut.getName());
        assertEquals("1.50", sut.getPrice().toString());
    }
}
