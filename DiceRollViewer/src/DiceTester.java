/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Name: Christian Paul Domingo
 *Date: 4 February 2010
 *Description:
 *
 * This is the diceTester file
 * @author eeuc1c
 */

public class DiceTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dice newDice = new Dice(6);
        
        System.out.println("DiceTest Running...");
        System.out.println("6 faced die with initial face value "+ newDice.getDice() +" created \n");

        System.out.println("Dice is thrown...");
        newDice.throwDice();
        System.out.println("Face Value = " + newDice.getDice()+"\n");

        System.out.println("New set of dice is used...");
        newDice.setDice(8);
        System.out.println("The new set of dice has 8 faces\n");

        System.out.println("Dice is thrown...");
        newDice.throwDice();
        System.out.println("Fave value = " + newDice.getDice());

        System.out.println("\n"+newDice.toString()+"\n");

        System.out.println("Test Finish");
       
        



        

    }

}
