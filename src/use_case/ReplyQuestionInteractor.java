package use_case;


import data_access.QuestionReadDataAccessInterface;
import data_access.QuestionUpdateDataAccessInterface;
import entity.*;

import java.sql.SQLException;
import java.util.Objects;

public class ReplyQuestionInteractor implements ReplyQuestionInputBoundary{
    private final QuestionUpdateDataAccessInterface questionUpdateDataAccessInterface;
    private final ReplyQuestionOutputBoundary replyPresenter;
    private final AnswerFactory answerFactory;
    private final QuestionFactory questionFactory;

    public ReplyQuestionInteractor(QuestionUpdateDataAccessInterface questionUpdateDataAccessInterface,
                                   ReplyQuestionOutputBoundary replyQuestionOutputBoundary,
                                   AnswerFactory answerFactory,
                                   QuestionFactory questionFactory){
        this.questionUpdateDataAccessInterface = questionUpdateDataAccessInterface;
        this.replyPresenter = replyQuestionOutputBoundary;
        this.answerFactory = answerFactory;
        this.questionFactory = questionFactory;
    }
    @Override
    public void execute(ReplyQuestionInputData replyQuestionInputData) throws SQLException{
        String answerDescription = replyQuestionInputData.getAnswerDescription();
        User seller = replyQuestionInputData.getSeller();
        Product product = replyQuestionInputData.getProduct();
        String questionContent = replyQuestionInputData.getQuestion().getDescription();

//这里不支持更改question的answer啊？？我只能创建和原来一样的question？因为我只能用dao read 再update？？
        //questionUpdateDAI感觉应该传入加入了新的answer的question。除非update可以自动检查到question已经上传过所以新传进来的直接覆盖。哦哦有道理！
        Answer sellerAnswer = answerFactory.createAnswer(answerDescription, seller.getStudentNumber());
        Question oldquestion = QuestionReadDataAccessInterface

        Question completeQuestion = questionFactory.createQuestion()
        if (Objects.equals(seller.getStudentNumber(), product.getSellerStudentNumber())){
            questionUpdateDataAccessInterface.updateQuestion();
        }

    }
}
