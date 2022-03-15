package com.techelevator;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
    Drink sut;

    @Before
    public void setUp() throws Exception {
        sut = new Drink("Coke", new BigDecimal("1.50"));
    }

    @Test
    public void testConstructor() {

        assertEquals("Coke", sut.getName());
        assertEquals("1.50", sut.getPrice().toString());
    }
}