package entity;

public class CommonQuestionFactory {
    public Question createQuestion(String description, CommonUser commonUser, Answer answer){
        return new CommonQuestion(description, commonUser, answer);
    }
}
