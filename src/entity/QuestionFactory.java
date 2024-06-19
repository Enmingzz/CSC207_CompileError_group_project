package entity;

public interface QuestionFactory {
    Question createQuestion(String description, CommonUser commonUser, Answer answer);
}
