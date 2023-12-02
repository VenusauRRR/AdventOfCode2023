package Day2CubeConundrumTest;

import Day2CubeConundrum.CubeConundrum;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CubeConundrumTest {

    CubeConundrum c = new CubeConundrum();

    @Test
    public void analyseColorCubeTest(){
        String s1 = " 3 blue";
        String s2 = " 1 red";
        String s3 = " 2 green";
        String s4 = " 5 blue";

        c.analyseColorCube(s1);
        c.analyseColorCube(s2);
        c.analyseColorCube(s3);
        c.analyseColorCube(s4);

        Assertions.assertTrue(c.getBlue().get(0)==3);
        Assertions.assertTrue(c.getRed().get(0)==1);
        Assertions.assertTrue(c.getGreen().get(0)==2);
        Assertions.assertTrue(c.getBlue().get(1)==5);
    }

    @Test
    public void analyseGameIDTest(){
        String s1 = "Game 1";
        String s2 = "Game 99";
        Assertions.assertTrue(c.analyseGameID(s1)==1);
        Assertions.assertTrue(c.analyseGameID(s2)==99);
    }

    @Test
    public void recordGameTest(){

        CubeConundrum c1 = new CubeConundrum();

        String s1 = "Game 19: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        c1.recordGame(s1);
        Assertions.assertTrue(c1.getGameID()==19);
        Assertions.assertTrue(c1.getRed().get(0)==4);
        Assertions.assertTrue(c1.getRed().get(1)==1);
        Assertions.assertTrue(c1.getBlue().get(0)==3);
        Assertions.assertTrue(c1.getBlue().get(1)==6);
        Assertions.assertTrue(c1.getGreen().get(0)==2);
        Assertions.assertTrue(c1.getGreen().get(1)==2);

    }

    @Test
    public void checkIfPossibleTest(){
        CubeConundrum c2 = new CubeConundrum("Game 19: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");

        Assertions.assertTrue(c2.checkIfPossible(c2.getRed(),12));
        Assertions.assertTrue(c2.checkIfPossible(c2.getGreen(),13));
        Assertions.assertTrue(c2.checkIfPossible(c2.getBlue(),14));
        Assertions.assertFalse(c2.checkIfPossible(c2.getBlue(),5));
    }

    @Test
    public void checkIfGamePossibleTest(){
//
//        Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
//        Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
//        Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
//        Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
//        Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
        CubeConundrum c1 = new CubeConundrum("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        CubeConundrum c2 = new CubeConundrum("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        CubeConundrum c3 = new CubeConundrum("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");

        Assertions.assertTrue(c1.checkIfGamePossible(12,13,14));
        Assertions.assertFalse(c2.checkIfGamePossible(12,13,14));
        Assertions.assertFalse(c3.checkIfGamePossible(12,13,14));
    }

    @Test
    public void getMultipliedPowerTest(){
        CubeConundrum c1 = new CubeConundrum("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        CubeConundrum c2 = new CubeConundrum("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        CubeConundrum c3 = new CubeConundrum("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
        CubeConundrum c4 = new CubeConundrum("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
        CubeConundrum c5 = new CubeConundrum("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");

        Assertions.assertTrue(c1.getMultipliedPower()==48);
        Assertions.assertTrue(c2.getMultipliedPower()==12);
        Assertions.assertTrue(c3.getMultipliedPower()==1560);
        Assertions.assertTrue(c4.getMultipliedPower()==630);
        Assertions.assertTrue(c5.getMultipliedPower()==36);


    }


}
