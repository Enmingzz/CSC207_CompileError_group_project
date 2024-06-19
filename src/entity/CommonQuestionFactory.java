package entity;

public class CommonQuestionFactory {
    public Question createQuestion(String description, User commonUser, Answer answer){
        return new CommonQuestion(description, commonUser, answer);
    }
}
