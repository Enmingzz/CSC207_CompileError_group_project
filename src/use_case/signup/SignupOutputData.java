package use_case.signup;

public class SignupOutputData {
    private final String username;
    private final String Utorid;
    private boolean useCaseFailed;

    public SignupOutputData(String username, String utorid, boolean useCaseFailed) {
        this.username = username;
        Utorid = utorid;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public String getUtorid() {
        return Utorid;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }

}
