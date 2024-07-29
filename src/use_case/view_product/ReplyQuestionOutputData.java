package use_case.view_product;

import entity.comment.Question;

import java.util.ArrayList;

/**
 * This class encapsulates the output data for the use case of replying to a question.
 * It contains a message indicating the result of the operation and the question entity.
 */
public class ReplyQuestionOutputData {
    private final String outputStr;
    private final ArrayList<Question> questions;

    /**
     * Constructs a ReplyQuestionOutputData object with the specified output message and question entity.
     *
     * @param outputStr the message indicating the result of the reply question operation.
     * @param questions the question entity that was replied to.
     */
    public ReplyQuestionOutputData(String outputStr, ArrayList<Question> questions) {
        this.outputStr = outputStr;
        this.questions = questions;
    }

    /**
     * Returns the message indicating the result of the reply question operation.
     *
     * @return the output message.
     */
    public String getOutputStr() {
        return outputStr;
    }

    /**
     * Returns the question entity that was replied to.
     *
     * @return the question entity.
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
