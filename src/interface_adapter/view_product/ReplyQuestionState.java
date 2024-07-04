package interface_adapter.view_product;

import entity.comment.Question;

public class ReplyQuestionState {
    private Question question = null;

    public ReplyQuestionState(Question question) {
        this.question = question;
    }

    public ReplyQuestionState(){};

    public Question getQuestion() {return question;}


    public void setQuestion(Question question){
        this.question = question;
    }

}
