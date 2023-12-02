package Day2CubeConundrum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CubeConundrum {

    int gameID;
    ArrayList<Integer> red;
    ArrayList<Integer> blue;
    ArrayList<Integer> green;

    public CubeConundrum(){
        red = new ArrayList<>();
        blue = new ArrayList<>();
        green = new ArrayList<>();
    }

    public CubeConundrum(String input){
        red = new ArrayList<>();
        blue = new ArrayList<>();
        green = new ArrayList<>();
        recordGame(input);
    }

    public void analyseColorCube(String input){
        String[] temp = input.trim().split(" ");
        int cubeNr = Integer.parseInt(temp[0]);
        switch (temp[1]) {
            case "red": red.add(cubeNr); break;
            case "blue": blue.add(cubeNr); break;
            case "green": green.add(cubeNr); break;
        }
    }

    public int analyseGameID(String input){
        String temp = input.substring(input.lastIndexOf(' ')+1);
        return Integer.parseInt(temp);
    }

    public void recordGame(String input){
        String[] temp = input.split(":");
        setGameID(analyseGameID(temp[0]));
        String[] tempColorCube = temp[1].split("[,;]"); //to split the input string by either "," or ";"
        for (String s : tempColorCube){
            analyseColorCube(s);
        }
    }

    public boolean checkIfPossible(ArrayList<Integer> gameColorCubeNr, int targetColorCubeNr){
        ArrayList<Integer> temp = new ArrayList<>(gameColorCubeNr);
        Collections.sort(temp);
        if (temp.get(temp.size()-1)<=targetColorCubeNr){
            return true;
        }
        return false;
    }

    public boolean checkIfGamePossible(int targetRed, int targetGreen, int targetBlue){
        if (checkIfPossible(getRed(),targetRed) && checkIfPossible(getGreen(),targetGreen) && checkIfPossible(getBlue(),targetBlue)){
            return true;
        }
        return false;
    }

    public int getMultipliedPower(){
        Collections.sort(red);
        Collections.sort(green);
        Collections.sort(blue);
        int minRed = getRed().get(getRed().size()-1);
        int minGreen = getGreen().get(getGreen().size()-1);
        int minBlue = getBlue().get(getBlue().size()-1);
        return minRed*minGreen*minBlue;
    }

    public ArrayList<Integer> getRed() {
        return red;
    }

    public ArrayList<Integer> getBlue() {
        return blue;
    }

    public ArrayList<Integer> getGreen() {
        return green;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
}
