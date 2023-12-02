package Day2CubeConundrum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CubeMain {
    ArrayList<CubeConundrum> gameList;

    public CubeMain(String path){
        gameList = new ArrayList<>();
        String temp;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((temp = br.readLine()) != null){
                CubeConundrum c = new CubeConundrum(temp);
                gameList.add(c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int calculateSumID(int targetRed, int targetGreen, int targetBlue){
        int sum = 0;
        for (CubeConundrum c : gameList){
            if (c.checkIfGamePossible(targetRed,targetGreen,targetBlue)){
                sum += c.getGameID();
            }
        }
        return sum;
    }

    public int calculateSumMultipliedPower(){
        int sum = 0;
        for (CubeConundrum c : gameList){
            sum += c.getMultipliedPower();
        }
        return sum;
    }

    public static void main(String[] args) {
        CubeMain m = new CubeMain("src/Day2CubeConundrum/input");
        System.out.println(m.calculateSumID(12,13,14));
        System.out.println(m.calculateSumMultipliedPower());

    }
}
