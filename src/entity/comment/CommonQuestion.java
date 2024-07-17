package entity.comment;

/**
 * Extends from CommonComment, have same attributes with commonAnswer, but with additional
 * attribute Answer.
 * @author CompileError group
 */

public class CommonQuestion extends CommonComment implements Question {
    private Answer answer;
    private String questionID;

    /**
     * Constructs a {@code CommonQuestion} object with the specified description, student number, answer, and question ID.
     *
     * @param description   the description of the question
     * @param studentNumber the student number associated with the question
     * @param answer        the answer associated with the question
     * @param questionID    the unique ID of the question
     */

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
