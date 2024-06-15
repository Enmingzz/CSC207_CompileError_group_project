package entity;

/**
 * Implementation of the interface AnswerFactory and return an instance of CommonAnswer with upcasting to Answer
 * @author CompileError group
 */
public class CommonAnswerFactory {
    Answer createCommonAnswer(String description, CommonUser commonUser){
        return new CommonAnswer(description, commonUser);
    }
}
