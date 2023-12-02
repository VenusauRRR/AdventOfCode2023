package Day1TrebuchetTest;
import Day1Trebuchet.TrebuchetPart2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class TrebuchetTest {

    TrebuchetPart2 t = new TrebuchetPart2("Test/Day1TrebuchetTest/inputTest");

//    pqr3stu8vwx
//            a1b2c3d4e5f
//    treb7uchet

    String s1 = "1abc2";
    String s2 = "pqr3stu8vwx";
    String s3 = "a1b2c3d4e5f";
    String s4 = "treb7uchet";

    @Test
    public void isCharNumericTest(){
        char c1 = 'p';
        char c2 = '2';
        Assertions.assertFalse(t.isCharNumeric(c1));
        Assertions.assertTrue(t.isCharNumeric(c2));
    }

    @Test
    public void findFirstLastNrInStringTest(){
        char[] n1 = {'1','2'};
        char[] n2 = {'3','8'};
        char[] n3 = {'1','5'};
        char[] n4 = {'7','7'};
        Assertions.assertTrue(Arrays.equals(t.findFirstLastNrInString(s1),n1));
        Assertions.assertTrue(Arrays.equals(t.findFirstLastNrInString(s2),n2));
        Assertions.assertTrue(Arrays.equals(t.findFirstLastNrInString(s3),n3));
        Assertions.assertTrue(Arrays.equals(t.findFirstLastNrInString(s4),n4));
        Assertions.assertFalse(Arrays.equals(t.findFirstLastNrInString(s4),n1));
        Assertions.assertFalse(Arrays.equals(t.findFirstLastNrInString(s3),n2));
        Assertions.assertFalse(Arrays.equals(t.findFirstLastNrInString(s2),n3));
        Assertions.assertFalse(Arrays.equals(t.findFirstLastNrInString(s1),n4));
    }

    @Test
    public void calculateCalibrationValueTest(){
        Assertions.assertTrue(t.calculateCalibrationValue(s1)==12);
        Assertions.assertTrue(t.calculateCalibrationValue(s2)==38);
        Assertions.assertTrue(t.calculateCalibrationValue(s3)==15);
        Assertions.assertTrue(t.calculateCalibrationValue(s4)==77);
        Assertions.assertFalse(t.calculateCalibrationValue(s4)==76);
    }

    @Test
    public void readFromFileTest(){
        String path = "Test/Day1TrebuchetTest/inputTest";
        t.readFromFile(path);
        Assertions.assertTrue(t.getCalibrationList().get(0).equals(s1));
        Assertions.assertTrue(t.getCalibrationList().get(1).equals(s2));
        Assertions.assertTrue(t.getCalibrationList().get(2).equals(s3));
        Assertions.assertTrue(t.getCalibrationList().get(3).equals(s4));
        Assertions.assertFalse(t.getCalibrationList().get(3).equals(s1));
    }

    @Test
    public void calculateCalibrationSumTest(){
        Assertions.assertTrue(t.calculateCalibrationSum()==142);
        Assertions.assertFalse(t.calculateCalibrationSum()==143);
    }

//    @Test
//    public void replaceLetterToNumberTest(){
//        TrebuchetPart2 t2 = new TrebuchetPart2("Test/Day1TrebuchetTest/input2Test");
////        two1nine
////                eightwothree
////        abcone2threexyz
////                xtwone3four
////        4nineeightseven2
////                zoneight234
////        7pqrstsixteen
//        String s1 = "219";
//        String s2 = "8wo3";
//        String s3 = "abc123xyz";
//        String s4 = "x2ne34";
//        String s5 = "49872";
//        String s6 = "z1ight234";
//        String s7 = "7pqrst6teen";
//        Assertions.assertTrue(t2.replaceLetterToNumber("two1nine").equals(s1));
//        Assertions.assertTrue(t2.replaceLetterToNumber("eightwothree").equals(s2));
//        Assertions.assertTrue(t2.replaceLetterToNumber("abcone2threexyz").equals(s3));
//        Assertions.assertTrue(t2.replaceLetterToNumber("xtwone3four").equals(s4));
//        Assertions.assertTrue(t2.replaceLetterToNumber("4nineeightseven2").equals(s5));
//        Assertions.assertTrue(t2.replaceLetterToNumber("zoneight234").equals(s6));
//        Assertions.assertTrue(t2.replaceLetterToNumber("7pqrstsixteen").equals(s7));
//        Assertions.assertFalse(t2.replaceLetterToNumber("7pqrstsixteen").equals(s1));
//    }

    @Test
    public void findFirstNrInLetterStringTest(){
//
//        4nineeightseven2
//                zoneight234
//        7pqrstsixteen
        TrebuchetPart2 t2 = new TrebuchetPart2("Test/Day1TrebuchetTest/input2Test");
        Assertions.assertTrue(t2.findFirstNrInLetterString("two1nine")=='2');
        Assertions.assertTrue(t2.findFirstNrInLetterString("eightwothree")=='8');
        Assertions.assertTrue(t2.findFirstNrInLetterString("abcone2threexyz")=='1');
        Assertions.assertTrue(t2.findFirstNrInLetterString("xtwone3four")=='2');
        Assertions.assertTrue(t2.findFirstNrInLetterString("4nineeightseven2")=='4');
        Assertions.assertTrue(t2.findFirstNrInLetterString("zoneight234")=='1');
        Assertions.assertTrue(t2.findFirstNrInLetterString("7pqrstsixteen")=='7');

        Assertions.assertTrue(t2.findFirstNrInLetterString("three6two9jckvk")=='3');
        Assertions.assertTrue(t2.findFirstNrInLetterString("1v")=='1');
        Assertions.assertTrue(t2.findFirstNrInLetterString("t1")=='1');

        Assertions.assertFalse(t2.findFirstNrInLetterString("xtwone3four")=='1');
    }

    @Test
    public void findLastNrToCharInStringTest(){
        TrebuchetPart2 t2 = new TrebuchetPart2("Test/Day1TrebuchetTest/input2Test");
        Assertions.assertTrue(t2.findLastNrToCharInString("two1nine")=='9');
        Assertions.assertTrue(t2.findLastNrToCharInString("eightwothree")=='3');
        Assertions.assertTrue(t2.findLastNrToCharInString("xtwone3four")=='4');
        Assertions.assertTrue(t2.findLastNrToCharInString("4nineeightseven2")=='2');
        Assertions.assertTrue(t2.findLastNrToCharInString("abcone2threexyz")=='3');
        Assertions.assertTrue(t2.findLastNrToCharInString("zoneight234")=='4');
        Assertions.assertTrue(t2.findLastNrToCharInString("7pqrstsixteen")=='6');

        Assertions.assertFalse(t2.findFirstNrInLetterString("xtwone3four")=='3');

        Assertions.assertTrue(t2.findLastNrToCharInString("51591twosix4dhsxvgghxq")=='4');
        Assertions.assertTrue(t2.findLastNrToCharInString("425nine")=='9');
        Assertions.assertTrue(t2.findLastNrToCharInString("3two3eightjszbfourkxbh5twonepr")=='1');
        Assertions.assertTrue(t2.findLastNrToCharInString("1v")=='1');
        Assertions.assertTrue(t2.findLastNrToCharInString("1z")=='1');

        Assertions.assertTrue(t2.calculateCalibrationSum()==281);

    }


}
