package entity.comment;

public class CommonQuestionFactory {
    public Question createQuestion(String description, String studentNumber, Answer answer){
        return new CommonQuestion(description, studentNumber, answer);
    }
}
