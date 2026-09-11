package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Mock Feline felineMock;

    @Test
    public void shouldGetKittensReturnOne () throws Exception {
        lion = new Lion("Самец", felineMock);
        when(felineMock.getKittens()).thenReturn(1);
        assertEquals("Метод getKittens() класса Lion должен возвращать число 1.",1, lion.getKittens());
        verify(felineMock).getKittens();
    }

    @Test
    public void shouldGetFoodReturnPredatorMealList () throws Exception {
        lion = new Lion("Самка", felineMock);
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals("Метод getFood() класса Lion должен возвращать список: \"Животные\", \"Птицы\", \"Рыба\"",
                List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(felineMock).getFood("Хищник");
    }

    @Test
    public void shouldLionConstructorThrowExceptionWhenSexIsInvalid() {
        try {
            new Lion("Кракозябра", felineMock);
            fail("Конструктор Lion(String sex, Feline feline) должен был выбросить исключение!");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

}