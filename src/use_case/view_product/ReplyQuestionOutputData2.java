package use_case.view_product;

import entity.comment.Question;

public class ReplyQuestionOutputData2 {
    private String outputStr;
    private Question question;

    public ReplyQuestionOutputData2(String outputStr, Question question){
        this.outputStr = outputStr;
        this.question = question;
    }

    public String getOutputStr(){
        return outputStr;
    }
    public Question getQuestion(){return question;}
}
