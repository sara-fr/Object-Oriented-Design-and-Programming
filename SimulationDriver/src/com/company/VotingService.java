package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class VotingService {
    private int counter1, counter2 = 0;
    private int counterA, counterB, counterC, counterD = 0;
    private String CorrectAnswer;
    public void setCounter(HashMap <String, String> data, int q_typeNum){
        HashMap <String, String> answers = new HashMap <>(data);
        int q_num = q_typeNum;
        if (q_num == 0){
            counter1 = Collections.frequency(new ArrayList <String>(answers.values()), "1");
            counter2 = Collections.frequency(new ArrayList <String>(answers.values()), "2");
        }
        else if (q_num == 1){
            counterA = Collections.frequency(new ArrayList <String>(answers.values()), "A");
            counterB = Collections.frequency(new ArrayList <String>(answers.values()), "B");
            counterC = Collections.frequency(new ArrayList <String>(answers.values()), "C");
            counterD = Collections.frequency(new ArrayList <String>(answers.values()), "D");
        }
    }
    public void getCounter(int q_typeNum){
        int q_num = q_typeNum;
        if (q_num == 0){
            System.out.println("Total Result: \n 1. Right: " + counter1 + " \n 2. Wrong: " + counter2);
        }
        else if (q_num == 1){
            System.out.println("Total Result: \n A: " + counterA + "\n B: " + counterB + "\n C: " + counterC + "\n D: " + counterD);
        }
    }
    public void setCorrectAnswer(int q_typeNum){
        int q_num = q_typeNum;
        if (q_num == 0){
            Question.single_choice sq = new Question.single_choice();
            this.CorrectAnswer = sq.choice[new Random().nextInt(2)];
        }
        else if (q_num == 1){
            Question.multiple_choice mq =  new Question.multiple_choice();
            this.CorrectAnswer = mq.choice[new Random().nextInt(4)];
        }
    }
    public String getCorrectAnswer(){
        return CorrectAnswer;
    }
}
