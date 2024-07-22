package entity.comment;

/**
 * The subclass of CommonComment, representing an answer with no additional attributes or methods.
 * Uses the super constructor to create a new CommonAnswer.
 * Implements the Answer interface.
 *
 * @see CommonComment
 * @see Answer
 */

public class CommonAnswer extends CommonComment implements Answer {

    /**
     * Constructs a new CommonAnswer with the specified description and student number.
     *
     * @param description the description of the answer
     * @param studentNumber the student number associated with the answer
     */
    public CommonAnswer(String description, String studentNumber) {
        super(description, studentNumber);
    }
}
