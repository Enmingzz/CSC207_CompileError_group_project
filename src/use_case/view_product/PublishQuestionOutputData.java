package use_case.view_product;


import entity.comment.Question;
import entity.comment.QuestionFactory;
import entity.user.User;

public class PublishQuestionOutputData {
    private final String outputStr;
    private final String newQuestion;
    private final User questionUser;
    private final Question question;

    public PublishQuestionOutputData(String outputStr, String newQuestion, User questionUser, Question question){
        this.outputStr = outputStr;
        this.newQuestion = newQuestion;
        this.questionUser = questionUser;
        this.question = question;
    }

    public Question getQuestion(){
        return question;
    }

    public String getOutputStr(){
        return outputStr;
    }
    public String getNewQuestion(){ return newQuestion;}
    public User getQuestionUser(){ return questionUser;}
}
