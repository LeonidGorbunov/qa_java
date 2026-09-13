package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;
    private boolean expectedMane;

    @Mock
    private Feline felineMock;

    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }
    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldHaveMane () throws Exception {
        Lion lion = new Lion(sex, felineMock);
        boolean actualMane = lion.doesHaveMane();
        assertEquals("Ожидаемый результат для \"Самец\" - true, для \"Самка\" - false", expectedMane, actualMane);
    }

}
