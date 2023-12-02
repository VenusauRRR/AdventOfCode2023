package Day2CubeConundrumTest;

import Day2CubeConundrum.CubeConundrum;
import Day2CubeConundrum.CubeMain;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class MainTest {
        CubeMain m = new CubeMain("Test/Day2CubeConundrumTest/inputTest");

        CubeConundrum c1 = new CubeConundrum("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        CubeConundrum c2 = new CubeConundrum("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        CubeConundrum c3 = new CubeConundrum("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        CubeConundrum c4 = new CubeConundrum("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        CubeConundrum c5 = new CubeConundrum("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");
    @Test
    public void calculateSumIDTest(){
        ArrayList<CubeConundrum> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        Assertions.assertTrue(m.calculateSumID(12,13,14)==8);
        Assertions.assertFalse(m.calculateSumID(12,13,14)==9);
    }

    @Test
    public void calculateSumMultipliedPowerTest(){
        Assertions.assertTrue(m.calculateSumMultipliedPower()==2286);
    }
}
