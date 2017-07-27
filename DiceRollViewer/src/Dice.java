
/**
 * Name: Christian Paul Domingo
 * Date: 03 October 2011
 * Description:
 * Dice Class for Dice game
 */

import java.util.Random;

public class Dice {
//instance
    Random rNumber = new Random();
    private int diceFace;
    private int numberFaces;

//constructor
    public Dice(int noFaces){
        numberFaces = noFaces;
        diceFace = rNumber.nextInt(numberFaces)+1;
    }
//mutator
    public void throwDice(){

        diceFace = rNumber.nextInt(numberFaces)+1;
    }
//setters
    public void setDice(int value){
        numberFaces = value;
        
    }
//getters
    public int getDice(){

        return diceFace;
    }
//tostring
    public String toString(){

       return getClass().getName() +"New Dice Face is "+numberFaces+" initial face value is "+diceFace;


    }
}
