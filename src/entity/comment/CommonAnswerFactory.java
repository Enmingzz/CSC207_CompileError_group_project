package entity.comment;

/**
 * Implementation of the interface AnswerFactory and return an instance of CommonAnswer with upcasting to Answer
 * @author CompileError group
 */

public class CommonAnswerFactory implements AnswerFactory{

    /**
     * Creates a new instance of {@link CommonAnswer} with the specified description and student number.
     *
     * @param description   the description of the answer
     * @param studentNumber the student number associated with the answer
     * @return a new {@link CommonAnswer} instance
     */

    public Answer createAnswer(String description, String studentNumber){
        return new CommonAnswer(description, studentNumber);
    }

}
