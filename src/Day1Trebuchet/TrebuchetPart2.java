package Day1Trebuchet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TrebuchetPart2 {

    ArrayList<String> calibrationList;

    public TrebuchetPart2(String path){
        calibrationList = new ArrayList<>();
        readFromFile(path);
    }

    public boolean isCharNumeric(char c){
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public char findFirstNrInString(String input){
        char c = ' ';
        for (int i = 0; i < input.length(); i++) {
            if (isCharNumeric(input.charAt(i))){
                c = input.charAt(i);
                break;
            }
        }
        return c;
    }

    public char findLastNrInString(String input){
        char c = ' ';
        for (int i = input.length()-1; i >= 0 ; i--) {
            if (isCharNumeric(input.charAt(i))){
                c = input.charAt(i);
                break;
            }
        }
        return c;
    }

    public char[] findFirstLastNrInString(String input){
        char[] temp = new char[2];
        temp[0] = findFirstNrInLetterString(input);
        temp[1] = findLastNrToCharInString(input);
        return temp;
    }

    public int calculateCalibrationValue(String input){
        char[] temp = findFirstLastNrInString(input);
        String s = "" + temp[0] + temp[1];
        return Integer.parseInt(s);
    }

    public void readFromFile(String path){
        String temp;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((temp = br.readLine()) != null){
                calibrationList.add(temp);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> getCalibrationList() {
        return calibrationList;
    }

    public int calculateCalibrationSum(){
        int temp = 0;
        for (String s : calibrationList){
            temp += calculateCalibrationValue(s);
        }
        return temp;
    }

    public char findFirstNrInLetterString(String input){
        char c = ' ';
        String[] letterList = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        char[] nrList = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < input.length(); i++) {
            if (isCharNumeric(input.charAt(i))){
                return c = input.charAt(i);
            }
            for (int j = 0; j < letterList.length; j++) {
                if (input.charAt(i)==letterList[j].charAt(0)
                        && input.charAt(i+1)==letterList[j].charAt(1)
                        && input.charAt(i+2)==letterList[j].charAt(2)
                ){
                    if (input.contains(letterList[j])){
                        return c = nrList[j];
                    }
                }
            }
        }
        return c;
    }

    public char findLastNrToCharInString(String input){
        char c = 'a';
        String[] letterList = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        char[] nrList = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = input.length()-1; i >= 0; i--) {
            if (isCharNumeric(input.charAt(i))){
                return c = input.charAt(i);
            }
            if (i>1){
                for (int j = 0; j < letterList.length; j++) {
                    if (input.charAt(i)==letterList[j].charAt(letterList[j].length()-1)
                            && input.charAt(i-1)==letterList[j].charAt(letterList[j].length()-2)
                            && input.charAt(i-2)==letterList[j].charAt(letterList[j].length()-3)
                    ){
                        if (input.contains(letterList[j])){
                            return c = nrList[j];
                        }
                    }
                }
            }
        }
        System.out.println(input);
        return c;
    }


    public static void main(String[] args) {
        TrebuchetPart2 t = new TrebuchetPart2("src/Day1Trebuchet/inputPart2");
        System.out.println(t.calculateCalibrationSum());
    }
}
