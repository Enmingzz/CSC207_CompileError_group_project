package use_case.view_product;

import entity.comment.Question;
import entity.user.User;

/**
 * This class encapsulates the output data for the use case of publishing a question.
 * It contains a message indicating the result of the operation, the new question, the user who asked the question, and the question entity.
 */
public class PublishQuestionOutputData {
    private final String outputStr;
    private final String newQuestion;
    private final User questionUser;
    private final Question question;

    /**
     * Constructs a PublishQuestionOutputData object with the specified output message, new question, user, and question entity.
     *
     * @param outputStr the message indicating the result of the publish question operation.
     * @param newQuestion the new question that was published.
     * @param questionUser the user who asked the question.
     * @param question the question entity.
     */
    public PublishQuestionOutputData(String outputStr, String newQuestion, User questionUser, Question question) {
        this.outputStr = outputStr;
        this.newQuestion = newQuestion;
        this.questionUser = questionUser;
        this.question = question;
    }

    /**
     * Returns the question entity.
     *
     * @return the question entity.
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Returns the message indicating the result of the publish question operation.
     *
     * @return the output message.
     */
    public String getOutputStr() {
        return outputStr;
    }

    /**
     * Returns the new question that was published.
     *
     * @return the new question.
     */
    public String getNewQuestion() {
        return newQuestion;
    }

    /**
     * Returns the user who asked the question.
     *
     * @return the user.
     */
    public User getQuestionUser() {
        return questionUser;
    }
}
