package entity.comment;

/**
 * Implementation of the interface AnswerFactory and return an instance of CommonAnswer with upcasting to Answer
 * @author CompileError group
 */
public class CommonAnswerFactory {
    Answer createCommonAnswer(String description, String studentNumber){
        return new CommonAnswer(description, studentNumber);
    }
}
