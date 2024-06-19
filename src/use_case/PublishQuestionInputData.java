package use_case;
import entity.CommonQuestion;

public class PublishQuestionInputData {
    private final CommonQuestion commonQuestion; //

    public PublishQuestionInputData(CommonQuestion commonQuestion) {
        this.commonQuestion = commonQuestion;
    }

    public CommonQuestion getCommonQuestion() {
        return commonQuestion;
    }
}
