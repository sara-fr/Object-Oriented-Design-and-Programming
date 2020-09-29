package com.company;

public class Question {
    String questionChoice;
    Question(){
        questionChoice = "This is a question!";
    }
    static class single_choice extends Question{
        String[] choice = {"1", "2"};
        String singleQuestion(){
            questionChoice = "This is a single choice question! \n " +
                    "Options are: 1. Right      2. Wrong";
            return questionChoice;
        }
    }
    static class multiple_choice extends Question{
        String[] choice = {"A", "B", "C", "D"};
        String multipleQuestion(){
            questionChoice = "This is a multiple question! \n " +
                    "Options are: A     B     C     D";
            return questionChoice;
        }
    }
}
