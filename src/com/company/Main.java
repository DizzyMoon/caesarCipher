package com.company;

import java.util.Scanner;

public class Main {

    public char[] getAlphabet() {
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Æ', 'Ø', 'Å'};
        return alphabet;
    }

    public int arrayIndexOf(char[] arrayIn, char input) {
        for (int i = 0; i < arrayIn.length; i++) {
            if (arrayIn[i] == input) {
                return i;
            }
        }
        return -1;
    }

    public int charToNum(char input) {
        if (!(input == ' ')) {
            return arrayIndexOf(getAlphabet(), input) + 1;
        } else return 0;
    }

    public char numToChar(int input) {
        if (!(input == 0)) {
            return getAlphabet()[input - 1];
        } else return ' ';
    }

    public char[] stringToArray(String input) {
        return input.toUpperCase().toCharArray();
    }

    public String decryptString(String input, int shift) {
        char[] charArray = stringToArray(input.toUpperCase());
        int[] intArray = new int[charArray.length];
        int[] decryptedIntArray = new int[intArray.length];
        char[] decryptedCharArray = new char[decryptedIntArray.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charToNum(charArray[i]);
        }
        for (int i = 0; i < intArray.length; i++) {
            if (!(intArray[i] == 0)) {
                decryptedIntArray[i] = intArray[i] - shift;
                if (decryptedIntArray[i] < 1) {
                    decryptedIntArray[i] = decryptedIntArray[i] + 29;
                }
            } else {
                decryptedIntArray[i] = 0;
            }
        }
        return buildString(decryptedIntArray, decryptedCharArray, sb);
    }

    private String buildString(int[] decryptedIntArray, char[] decryptedCharArray, StringBuilder sb) {
        for (int i = 0; i < decryptedIntArray.length; i++) {
            decryptedCharArray[i] = numToChar(decryptedIntArray[i]);
        }
        for (int i = 0; i < decryptedCharArray.length; i++) {
            sb.append(decryptedCharArray[i]);
        }
        String output = String.valueOf(sb);
        return output;
    }

    public String encryptString(String input, int shift) {
        char[] charArray = stringToArray(input.toUpperCase());
        int[] intArray = new int[charArray.length];
        int[] encryptedIntArray = new int[intArray.length];
        char[] encryptedCharArray = new char[encryptedIntArray.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charToNum(charArray[i]);
        }
        for (int i = 0; i < intArray.length; i++) {
            if (!(intArray[i] == 0)) {
                encryptedIntArray[i] = intArray[i] + shift;
                if (encryptedIntArray[i] > 29) {
                    encryptedIntArray[i] = encryptedIntArray[i] - 29;
                }
            } else {
                encryptedIntArray[i] = 0;
            }
        }
        return buildString(encryptedIntArray, encryptedCharArray, sb);
    }

    public void execute() {

        //DECLARE VARIABLES
        boolean validInput;
        boolean runAgain = true;
        Scanner sc = new Scanner(System.in);

        //RUN
        System.out.println("Velkommen til Mikkel's Caesar Cipher maskine");
        while (runAgain) {
            validInput = false;
            while (!validInput) {    //RETURN POINT IF INPUT IS INVALID
                System.out.println("Do you want to (e)ncrypt or (d)ecrypt?");
                String userChoice = sc.nextLine();
                if (userChoice.equals("e") || userChoice.equals("E")) {
                    validInput = true;
                    System.out.print("Please enter text to encrypt: ");
                    String input = sc.nextLine();
                    System.out.print("Please enter shift value: ");
                    int key = Integer.parseInt(sc.nextLine());
                    System.out.println("Encrypted text: " + encryptString(input, key));
                } else if (userChoice.equals("d") || userChoice.equals("D")) {
                    validInput = true;
                    System.out.print("Please enter text to decrypt: ");
                    String input = sc.nextLine();
                    System.out.print("Please enter key value: ");
                    int key = Integer.parseInt(sc.nextLine());
                        System.out.println("Decrypted text: " + decryptString(input, key));
                } else {
                    System.out.println("Please type either \"e\" or \"d\"");
                }
            }
            validInput = false;
            while (!(validInput)) {
                System.out.println("Do you want to encrypt or decrypt another text? y/n");
                String answer = sc.nextLine();
                if (answer.equals("n") || answer.equals("N")) {
                    runAgain = false;
                    validInput = true;
                } else if (answer.equals("y") || answer.equals(("Y"))) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a valid input");
                }
            }
        }
        System.out.println("Closing...");
    }

    public static void main(String[] args) {
        new com.company.Main().execute();
    }
}