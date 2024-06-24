package interface_adapter.view_product;

import entity.comment.Question;

public class ReplyQuestionState {
    private Question question;
    private String prompt_str;

    public ReplyQuestionState(Question question, String prompt_str) {
        this.question = question;
        this.prompt_str = prompt_str;
    }

    public ReplyQuestionState(){};

    public Question getQuestion() {return question;}

    public String getPrompt_str() {return prompt_str;}

    public void setQuestion(Question question){
        this.question = question;
    }

    public void setPrompt_str(String prompt_str){
        this.prompt_str = prompt_str;
    }
}
