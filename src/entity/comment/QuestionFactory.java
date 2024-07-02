package entity.comment;

/**
 * The interface of CommonQuestionFactory to generate an instance of CommonQuestion with upcasting
 * to question
 * @author CompileError group
 */

public interface QuestionFactory {

    Question createQuestion(String description, String studentNumber, Answer answer);

}
