package entity;

public interface QuestionFactory {
    Question createQuestion(String description, User commonUser, Answer answer);
}
