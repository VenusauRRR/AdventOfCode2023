//package Day1Trebuchet;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Trebuchet {
//
//    ArrayList<String> calibrationList;
//
//    public Trebuchet(String path){
//        calibrationList = new ArrayList<>();
//        readFromFile(path);
//    }
//
//    public boolean isCharNumeric(char c){
//        try {
//            Integer.parseInt(String.valueOf(c));
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
//    public char[] findFirstLastNrInString(String input){
//        int count = 0;
//        char[] temp = new char[2];
//        for (int i = 0; i < input.length(); i++) {
//            if (isCharNumeric(input.charAt(i))){
//                temp[0] = input.charAt(i);
//                break;
//            }
//        }
//        for (int i = input.length()-1; i >= 0 ; i--) {
//            if (isCharNumeric(input.charAt(i))){
//                temp[1] = input.charAt(i);
//                break;
//            }
//        }
//        return temp;
//    }
//
//    public int calculateCalibrationValue(String input){
//        char[] temp = findFirstLastNrInString(input);
//        String s = "" + temp[0] + temp[1];
//        return Integer.parseInt(s);
//    }
//
//    public void readFromFile(String path){
//        String temp;
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(path));
//            while ((temp = br.readLine()) != null){
//                calibrationList.add(temp);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public ArrayList<String> getCalibrationList() {
//        return calibrationList;
//    }
//
//    public int calculateCalibrationSum(){
//        int temp = 0;
//        for (String s : calibrationList){
//            temp += calculateCalibrationValue(s);
//        }
//        return temp;
//    }
//
//    public static void main(String[] args) {
//        Trebuchet t = new Trebuchet("src/Day1Trebuchet/input");
//        System.out.println(t.calculateCalibrationSum());
//    }
//}
