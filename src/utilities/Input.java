/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import Messeges.SystemMesseges;
import java.util.Scanner;

/**
 *
 * @author Deepak
 */
public class Input {
    static boolean check = true;
    static Scanner scn= new Scanner(System.in);
/**
 * Gets user to input alpha numeric string
 * used for capturing address
 * @return 
 */
    public static String getAlphaNumericInput() {
        String stringInput="",tempStr;
        do {
            tempStr = scn.next().trim();
            if (Validate.alphaNumericValidator(tempStr)) {                
                   stringInput = tempStr;
                    check = false;
                    scn.nextLine();  //resets scanner              
            } else {
               // scn.nextLine();
                System.out.println("This" + SystemMesseges.EMPTY_INPUT_MESSAGE+" or have special characters");
            }
        } while (check);
        // reset boolean for next input
        return stringInput;
    }
/**
 * Gets user to input alphabet string only for names
 * @return 
 */
    public static String getNameInput() {
        String stringInput="",tempStr;
        do {
            tempStr = scn.next().trim();
            if (Validate.nameValidator(tempStr)) {                
                   stringInput = tempStr;
                    check = false;
                    //scn.nextLine();  //resets scanner              
            } else {
                scn.nextLine();
                System.out.println("name" + SystemMesseges.EMPTY_INPUT_MESSAGE);
            }
        } while (check);
        // reset boolean for next input
        return stringInput;
    }
/**
 * Gets user to input only integer value & keeps asking until gets Integer value
 * @return 
 */
    public static int getIntInput() {
        int intInput=0, tempInt;
        do {
            if (scn.hasNextInt()) {
                tempInt = scn.nextInt();
                if (tempInt >= 0) {
                    intInput = tempInt;
                    check = false;
                    scn.nextLine();
                } else {
                    scn.nextLine();
                    System.out.println(SystemMesseges.INVALID_INTEGER_MESSAGE);
                }
            } else {
                scn.nextLine();
                System.out.println(SystemMesseges.INVALID_INTEGER_MESSAGE);
            }
        } while (check);
        // reset boolean for next input
     
        return intInput;
    }
/**
 * Gets user to input only double value & keeps asking until gets valid double value
 * @return 
 */
    public static double getDoubleInput() {
        double doubleInput=0.0, tempDbl;
        do {
            if (scn.hasNextDouble()) {
                tempDbl = scn.nextDouble();
                if (tempDbl > 0) {
                    doubleInput = tempDbl;
                    check = false;
                    scn.nextLine();
                } else {
                    scn.nextLine();
                    System.out.println(SystemMesseges.INVALID_DOUBLE_MESSAGE);
                }
            } else {
                scn.nextLine();
                System.out.println(SystemMesseges.INVALID_DOUBLE_MESSAGE);
            }
        } while (check);
        // reset boolean for next input
        return doubleInput;
    }
    /**
 * Gets user to input only double value & keeps asking until gets valid double value
 * @return 
 */
    public static boolean getBoolInput() {
         return getAlphaNumericInput().equalsIgnoreCase("Y");
            
    }

    public static void main(String[] args){

    String str =getAlphaNumericInput();
    int inte = getIntInput();
    double dbl = getDoubleInput();
    System.out.println(str+"\n"+inte+"\n"+dbl);
    }
}
