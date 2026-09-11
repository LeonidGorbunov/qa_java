package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void shouldGetKittensWithoutArgumentReturnOne () {
        felineSpy.getKittens();
        verify(felineSpy).getKittens(1);
    }

    @Test
    public void shouldGetKittensWithArgumentReturnKittensCount () {
        assertEquals("Метод getKittens(5) должен возвращать число 5.",5, felineSpy.getKittens(5));
    }

    @Test
    public void shouldGetFamilyReturnFamily () {
        assertEquals("Метод getFamily() должен возвращать \"Кошачьи\".","Кошачьи", felineSpy.getFamily());
    }

    @Test
    public void shouldEatMeatReturnPredatorMealList () throws Exception {
        assertEquals("Метод eatMeat() класса Feline должен возвращать список: \"Животные\", \"Птицы\", \"Рыба\".",
                List.of("Животные", "Птицы", "Рыба"), felineSpy.eatMeat());
        verify(felineSpy).getFood("Хищник");
    }

    @Test
    public void shouldEatMeatReturnPredatorMealListUsingSpy () throws Exception {
        doReturn(List.of("Животные", "Птицы", "Рыба")).when(felineSpy).getFood("Хищник");
        assertEquals("Метод eatMeat() класса Feline должен возвращать список: \"Животные\", \"Птицы\", \"Рыба\".",
                List.of("Животные", "Птицы", "Рыба"), felineSpy.eatMeat());
    }
}