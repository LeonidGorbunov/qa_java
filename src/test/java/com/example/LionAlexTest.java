package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    private LionAlex lionAlex;

    @Mock
    Feline felineMock;

    @Test
    public void shouldGetKittensReturnZero () throws Exception {
        lionAlex = new LionAlex(felineMock);
        assertEquals("Метод getKittens() класса LionAlex должен возвращать число 0.",0, lionAlex.getKittens());
    }

    @Test
    public void shouldGetFriendsReturnFriendsList () throws Exception {
        lionAlex = new LionAlex(felineMock);
        assertEquals("Метод getFriends() класса LionAlex должен возвращать список: \"Марти\", \"Глория\", \"Мелман\".",
                List.of("Марти", "Глория", "Мелман"), lionAlex.getFriends());
    }

    @Test
    public void shouldGetPlaceOfLivingReturnPlace () throws Exception {
        lionAlex = new LionAlex(felineMock);
        assertEquals("Метод getPlaceOfLiving() класса LionAlex должен возвращать \"Зоопарк Нью-Йорка\".",
                "Зоопарк Нью-Йорка", lionAlex.getPlaceOfLiving());
    }

}