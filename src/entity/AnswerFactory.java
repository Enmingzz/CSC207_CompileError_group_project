package entity;

/**
 * The interface of CommonAnswerFactory which is used to create an instance of CommonAnswer.
 * @author CompileError group
 */
public interface AnswerFactory {
    public Answer createAnswer(String description, String studentNumber);

}
