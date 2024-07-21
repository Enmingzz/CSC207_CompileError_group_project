package use_case.view_product;


import entity.user.User;

public class PublishQuestionOutputData {
    private final String outputStr;
    private final String newQuestion;
    private final User questionUser;

    public PublishQuestionOutputData(String outputStr, String newQuestion, User questionUser){
        this.outputStr = outputStr;
        this.newQuestion = newQuestion;
        this.questionUser = questionUser;
    }

    public String getOutputStr(){
        return outputStr;
    }
    public String getNewQuestion(){ return newQuestion;}
    public User getQuestionUser(){ return questionUser;}
}
