package use_case;


public class PublishQuestionOutputData {
    private final String outputStr;

    public PublishQuestionOutputData(String outputStr){
        this.outputStr = outputStr;
    }

    public String getOutputStr(){
        return outputStr;
    }
}
