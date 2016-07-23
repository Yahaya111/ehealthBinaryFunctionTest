/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryparser;

import java.util.Scanner;

/**
 *
 * @author HP 1
 */
public class BinaryParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int acceptInput=1;
        while(acceptInput!=-1){
            System.out.print("Please Enter an Integer -1 to quit: ");
            int userInput = scanner.nextInt();
            if(userInput == -1)
                acceptInput=-1;
            else{
                BinaryParser bp = new BinaryParser();
                int output = bp.getMaxOccurrenceOfZeros(userInput);
                System.out.println("Output is: "+output);
            }
        }
    }
    
    public int getMaxOccurrenceOfZeros(int n){
        //Declare local variables to hold binary conversion of n
       
        String strBinaryResult = "";
        strBinaryResult = Integer.toBinaryString(n);
        //declare start and end index to ensure that some 0's in binary representation of n are sorrounded by 1
        int startIndex = strBinaryResult.indexOf("1");
        int endIndex = strBinaryResult.lastIndexOf("1");
        //if no existence of 0's sorrounded by one return 0;
        if(startIndex ==1 || endIndex==-1){
            return 0;
        }
        //create a substring of binary values sorrounded by 1.
        String finalBinary = strBinaryResult.substring(startIndex,endIndex);
        
        //tokenize all occrrences of 0's between 1.
        String[] resultToken = finalBinary.split("1");
        //initialize maximum occurrence of 0's to be zero.
        int maxOccurrence = 0;
        
        //assume the first string set of 0's sorrunded by 1 is maximum.
        maxOccurrence = resultToken[0].length();
        for(String s:resultToken){
            //if there exist any other occurrence greater than the initial one replace maxOccurrence with new value.
            if(maxOccurrence<s.length())
                maxOccurrence = s.length();
        }
            
        
        return maxOccurrence;
    }
    
}
