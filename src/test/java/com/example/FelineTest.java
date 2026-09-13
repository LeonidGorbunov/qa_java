package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void shouldGetKittensWithoutArgumentReturnOne () {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals("Метод getKittens() без аргументов должен возвращать число 1.", 1, actual);
    }

    @Test
    public void shouldGetKittensWithArgumentReturnKittensCount () {
        Feline feline = new Feline();
        assertEquals("Метод getKittens(5) должен возвращать число 5.",5, feline.getKittens(5));
    }

    @Test
    public void shouldGetFamilyReturnFamily () {
        Feline feline = new Feline();
        assertEquals("Метод getFamily() должен возвращать \"Кошачьи\".","Кошачьи", feline.getFamily());
    }

    @Test
    public void shouldEatMeatReturnPredatorMealList () throws Exception {
        doReturn(List.of("Животные", "Птицы", "Рыба")).when(felineSpy).getFood("Хищник");
        assertEquals("Метод eatMeat() класса Feline должен возвращать список: \"Животные\", \"Птицы\", \"Рыба\".",
                List.of("Животные", "Птицы", "Рыба"), felineSpy.eatMeat());
    }

}