package entity.comment;

/**
 * Extends from CommonComment, have same attributes with commonAnswer, but with additional
 * attribute Answer.
 * @author CompileError group
 */

public class CommonQuestion extends CommonComment implements Question {
    private Answer answer;

    public CommonQuestion(String description, String studentNumber, Answer answer){
        super(description, studentNumber);
        this.answer = answer;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }
}
