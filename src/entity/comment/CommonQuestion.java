package entity.comment;

/**
 * Extends from CommonComment, have same attributes with commonAnswer, but with additional
 * attribute Answer.
 * @author CompileError group
 */

public class CommonQuestion extends CommonComment implements Question {
    private Answer answer;
    private String questionID;

    public CommonQuestion(String description, String studentNumber, Answer answer, String questionID){
        super(description, studentNumber);
        this.answer = answer;
        this.questionID = questionID;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    public String getQuestionID() {
        return questionID;
    }
}
