package entity.comment;

public class CommonQuestionFactory implements QuestionFactory{
    public Question createQuestion(String description, String studentNumber, Answer answer, String questionID){
        return new CommonQuestion(description, studentNumber, answer, questionID);
    }
}
