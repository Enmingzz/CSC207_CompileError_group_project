package entity.comment;

/**
 * Implementation of {@link QuestionFactory} for creating instances of {@link CommonQuestion}.
 */

public class CommonQuestionFactory implements QuestionFactory{

    /**
     * Creates a new instance of {@link CommonQuestion} with the specified description, student number, answer, and question ID.
     *
     * @param description   the description of the question
     * @param studentNumber the student number associated with the question
     * @param answer        the answer associated with the question
     * @param questionID    the unique ID of the question
     * @return a new {@link CommonQuestion} instance
     */

    public Question createQuestion(String description, String studentNumber, Answer answer, String questionID){
        return new CommonQuestion(description, studentNumber, answer, questionID);
    }
}
