package entity;

public interface QuestionFactory {
    Question createQuestion(String description, String studentNumber, Answer answer);
}
