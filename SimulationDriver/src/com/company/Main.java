package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

//-----------SimulationDriver----------//
public class Main {
    public static void main(String[] args) {
        String q_type;
        int q_typeNum = 0;
        int numOfStudents = ThreadLocalRandom.current().nextInt(20,60);
        int numOfChanges = ThreadLocalRandom.current().nextInt(0,20);
        Student st = new Student();
        HashMap<String, String> student_answer = new HashMap <>();
        Question.single_choice sq =  new Question.single_choice();
        Question.multiple_choice mq =  new Question.multiple_choice();
        String[] q_types = {sq.singleQuestion(), mq.multipleQuestion()};
        q_type = q_types[new Random().nextInt(q_types.length)];
        VotingService vote = new VotingService();
        System.out.println(q_type);
        if (q_type.contains("single")){
            q_typeNum = 0;
        }
        else if (q_type.contains("multiple")){
            q_typeNum = 1;
        }
        vote.setCorrectAnswer(q_typeNum);
        System.out.println("The correct answer is : " + vote.getCorrectAnswer());
        System.out.println("Total Number of Participant Students: " + numOfStudents);
        for (int i = 0; i < numOfStudents; i++){
            st.setId();
            String stuID = ("stu" + (i) + st.getId());
            st.setAnswer(q_typeNum);
            student_answer.put(stuID, st.getAnswer());
        }
        for (String name: student_answer.keySet()){
            String key = name;
            String value = student_answer.get(name);
            System.out.println("Student ID: " + key + " choose answer: " + value);
        }
        System.out.println("Total Number of Students Who Changed Their Answers: " + numOfChanges);
        for (int i = 0; i < numOfChanges; i++){
            String stUpdate = (String) student_answer.keySet().toArray()[new Random().nextInt(student_answer.keySet().toArray().length)];
            st.setAnswer(q_typeNum);
            String answer_update = st.getAnswer();
            student_answer.replace(stUpdate, answer_update);
            System.out.println("Student ID: " + stUpdate + " changed answer to: " + answer_update);
        }
        vote.setCounter(student_answer, q_typeNum);
        vote.getCounter(q_typeNum);
        //System.out.println(student_answer + "\n");
    }
}
