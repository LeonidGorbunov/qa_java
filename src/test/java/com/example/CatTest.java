package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private Cat cat;

    @Mock
    Feline felineMock;

    @Test
    public void shouldGetSoundReturnMyau () {
        cat = new Cat(felineMock);
        assertEquals("Метод getSound() класса Cat должен возвращать \"Мяу\"", "Мяу", cat.getSound());
    }

    @Test
    public void shouldGetFoodReturnPredatorMealList () throws Exception {
        cat = new Cat(felineMock);
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals("Метод getFood() класса Cat должен возвращать список: \"Животные\", \"Птицы\", \"Рыба\"",
                List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        verify(felineMock).eatMeat();
    }
}