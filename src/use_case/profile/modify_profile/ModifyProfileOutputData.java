package use_case.profile.modify_profile;

/**
 * Represents the output data for modifying a profile.
 * Contains a message indicating the result of the profile modification operation.
 */

public class ModifyProfileOutputData {

    private final String message;

    /**
     * Constructs a ModifyProfileOutputData object with the given message.
     *
     * @param message the message indicating the result of the profile modification
     */

    public ModifyProfileOutputData(String message) {
        this.message = message;
    }

    /**
     * Returns the message indicating the result of the profile modification.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
