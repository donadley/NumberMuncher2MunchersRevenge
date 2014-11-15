/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbermuncher2munchersrevenge;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Don Adley Jr
 */

/**
 * 
 * The GameQuestions class stores and distributes 
 */
public class GameQuestions {
    private int panelSize = 25;
    private ArrayList<String> questionlist;
    private ArrayList<Integer> correctAnswers;
    private ArrayList<Integer> wrongAnswers;
    private int[][] doublearray;
    private int questionPicked;
    
    private String two = "Numbers that are divisible by two";
    private String four = "Numbers that are divisible by four";

    public GameQuestions(int numberofPanels) {
        this.panelSize = numberofPanels;
        this.questionlist = new ArrayList<>();
        this.questionlist.add(two);
        this.questionlist.add(four);
        questionPicked = pickQuestion();
        
    }
    /**
     * Create the Correct and Incorrect answers and stores them
     * case 0 is question(Numbers that are divisible by two)
     * case 1 is question(Numbers that are divisible by four)
     * @return Answer An Array of Correct and incorrect answers for the game
     */
    public int[][] createAnswers(){
        Random ran = new Random();
        doublearray = new int[5][5];
        ArrayList<Integer> answers = new ArrayList<>();
        correctAnswers = new ArrayList<>();
        wrongAnswers = new ArrayList<>();
        switch(questionPicked){
            case 0:                
                    while(correctAnswers.size() < 15){                        
                        int ranNum = ran.nextInt(30)+1;
                        if(ranNum % 2 == 0){
                            correctAnswers.add(ranNum);
                        }
                    }
                     while(wrongAnswers.size() < 10){                        
                        int ranNum = ran.nextInt(30)+1;
                        if(ranNum % 2 != 0){
                            wrongAnswers.add(ranNum);
                        }
                    }
                    
                    answers = correctAnswers;
                
                    for(int answer = 0; answer < wrongAnswers.size(); answer++){
                        answers.add(wrongAnswers.get(answer));
                    }
                     
                    break;
                
            case 1:
                 while(correctAnswers.size() < 15){                        
                        int ranNum = ran.nextInt(30)+1;
                        if(ranNum % 4 == 0){
                            correctAnswers.add(ranNum);
                        }
                    }
                while(wrongAnswers.size() < 10){                        
                   int ranNum = ran.nextInt(30)+1;
                   if(ranNum % 2 != 0){
                       wrongAnswers.add(ranNum);
                   }
                }
                
                answers = correctAnswers;

                 for(int answer = 0; answer < wrongAnswers.size(); answer++){
                     answers.add(wrongAnswers.get(answer));
                 }

                 break; 
        }
        int count=0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.println("Count: " + count);
                int tempint = answers.get(count);
                System.out.println("temp "+tempint);
                System.out.println("Size: " + answers.size());
                doublearray[i][j] = (tempint);
                count++;
            }
        }
        
        return doublearray;   
    }
    
    public int pickQuestion(){
        Random ran = new Random();
        return ran.nextInt(questionlist.size());
    }
    
    public ArrayList<Integer> getCorrectAnswers(){
        return correctAnswers;
    }
    
     public ArrayList<Integer> getWrongAnswers(){
        return wrongAnswers;
    }
    
    public String getQuestion(){
        return questionlist.get(questionPicked);
    } 
}
