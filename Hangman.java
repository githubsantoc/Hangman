

package com.santoshi;

//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args){

        System.out.println("********Welcome to the Hangman game********");
    String word;
    int lives = 6;
    Scanner sc = new Scanner(System.in);

    /*if the word is in the test format inside some file then use below commented code
    File dictionary =new File("C:\\.............\\words.txt");
    Scanner file = new Scanner(dictionary);
    List<String> wordlist = new ArrayList<>();
    while(file.hasNext()){
     wordlist.add(file.nextLine());
    }
    word = wordlist.get((int)(Math.random()* wordlist.size()));

     */

        String[] wordlist = new String[]{"elephant", "donkey", "university","bedroom" };
    word = wordlist[((int)(Math.random()* wordlist.length))];
    char[] wordArray = word.toCharArray();
    char[] answers = new char[wordArray.length];


    for(int i=0; i<word.length(); i++){
        answers[i] = '?';
    }

    boolean finished = false;

    while(!finished) {
        System.out.println("Enter the letter: ");
        String letter = sc.next();

        while(letter.length() !=1 || Character.isDigit(letter.charAt(0))){
            System.out.println("Invalid input error");
            letter = sc.next();
        }

        //checks if the letter that we input matches in the word
        boolean letterFound = false;
        for(int i = 0; i<wordArray.length; i++) {
            if (letter.charAt(0) == wordArray[i]) {
                answers[i] = wordArray[i];
                letterFound = true;
            }
        }
            if(!letterFound){
                lives--;
                System.out.println("Wrong letter assumed");
            }

            boolean done = true;
        for (char answer : answers) {
            if (answer == '?') {
                System.out.print(" _");
                done = false;
            } else {
                System.out.print(" " + answer);
            }
        }
        System.out.println("\n"+"Total lives left : "+ lives);
            drawHangman(lives);
            if(done){
                System.out.println("Congratulation");
                finished = true;
            }
            if(lives <= 0){
                System.out.println("Sorry man you are dead");
                finished = true;
            }
    }
    }
    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}