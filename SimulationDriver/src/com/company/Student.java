package com.company;
import java.security.SecureRandom;
import java.util.Random;
import static java.util.UUID.randomUUID;

public class Student {
    private String id;
    private String answer;
    private String getAnswer;
    SecureRandom random = new SecureRandom();
    public void setId() {
        this.id = String.valueOf(random.nextInt(100000));
        //this.id = String.valueOf(randomUUID());
    }
    public String getId() {
        return id;
    }
    public void setAnswer(int q_typeNum) {
        int q_num = q_typeNum;
        if (q_num == 0){
            Question.single_choice sq = new Question.single_choice();
            getAnswer = sq.choice[new Random().nextInt(2)];
            this.answer = getAnswer;
        }
        else if (q_num == 1){
            Question.multiple_choice mq =  new Question.multiple_choice();
            getAnswer = mq.choice[new Random().nextInt(4)];
            this.answer = getAnswer;
        }
    }
    public String getAnswer() {
        return answer;
    }
}
