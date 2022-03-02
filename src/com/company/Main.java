package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

  char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Æ','Ø','Å'};

  public int arrayIndexOf(char[] arrayIn, char input){
    for(int i = 0; i < arrayIn.length; i++){
      if (arrayIn[i] == input){
        return i;
      }
    }
    return -1;
  }

  public int charToNum(char input) {
    if (!(input == ' ')) {
      return arrayIndexOf(alphabet, input) + 1;
    } else return 0;
  }

  public char numToChar(int input) {
    if (!(input == 0)) {
      return alphabet[input - 1];
    } else return ' ';
  }

  public char[] stringToArray(String input){
    return input.toCharArray();
  }

  public String arrayToString(int[] input){
    return Arrays.toString(input);
  }

  public String arrayToString(char[] input){
    return Arrays.toString(input);
  }

  public String encrypt(String input, int shift){
    char[] charArray = stringToArray(input.toUpperCase());
    int[] intArray = new int[charArray.length];
    int [] encryptedIntArray = new int[intArray.length];
    char[] encryptedCharArray = new char[encryptedIntArray.length];


    for (int i = 0; i <= charArray.length; i++){
      intArray[i] = charToNum(charArray[i]);
    }
    System.out.println("charArray made successfully");
    for (int i = 0; i <= intArray.length; i++){
      encryptedIntArray[i] = intArray[i + shift];
    }
    System.out.println("intArray made successfully");
    for (int i = 0; i <= encryptedIntArray.length; i++){
      encryptedCharArray[i] = numToChar(encryptedIntArray[i]);
    }
    System.out.println("encryptedIntArray made successfully");
    String encryptedString = arrayToString(encryptedCharArray);

    return encryptedString;
  }


  public void execute(){
    boolean validInput = false;
    Scanner sc = new Scanner(System.in);


    while (!validInput) {
      System.out.println("Do you want to (e)ncrypt or (d)ecrypt?");
      String userChoice = sc.nextLine();
      if (userChoice.equals("e") || userChoice.equals("E")) {
        validInput = true;
        System.out.print("Please enter text to encrypt: ");
        String input = sc.nextLine();
        System.out.print("Please enter shift value: ");
        int shift = Integer.parseInt(sc.nextLine());
        System.out.println("Encrypted text: " + encrypt(input, shift));

      } else if (userChoice.equals("d") || userChoice.equals("D")) {
        validInput = true;
      } else {
        System.out.println("Please type either \"e\" or \"d\"");
      }
    }
  }

  public static void main(String[] args) {
    new com.company.Main().execute();
  }
}
